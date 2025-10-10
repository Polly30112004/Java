package Task02;

import java.util.*;
import java.time.LocalDate;
import java.util.*;

public class WarehouseSystem {
    private List<Warehouse> warehouses;
    private List<Supplier> suppliers;
    private List<Product> products;
    private List<Invoice> invoices;
    private Map<Warehouse, Map<Product, Integer>> inventory; // склад -> (товар -> количество)

    public WarehouseSystem() {
        this.warehouses = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.invoices = new ArrayList<>();
        this.inventory = new HashMap<>();
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
        inventory.put(warehouse, new HashMap<>());
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Invoice createInvoice(String number, LocalDate date, String type) {
        Invoice invoice = new Invoice(number, date, type);
        invoices.add(invoice);
        return invoice;
    }

    public void processInvoice(Invoice invoice) {
        switch (invoice.getType()) {
            case "ПРИХОД":
                processIncoming(invoice);
                break;
            case "РАСХОД":
                processOutgoing(invoice);
                break;
            case "ПЕРЕМЕЩЕНИЕ":
                processTransfer(invoice);
                break;
        }
    }

    private void processIncoming(Invoice invoice) {
        Warehouse warehouse = invoice.getToWarehouse();
        Map<Product, Integer> warehouseInventory = inventory.get(warehouse);

        for (Map.Entry<Product, Integer> entry : invoice.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            warehouseInventory.put(product, warehouseInventory.getOrDefault(product, 0) + quantity);
        }
    }

    private void processOutgoing(Invoice invoice) {
        Warehouse warehouse = invoice.getFromWarehouse();
        Map<Product, Integer> warehouseInventory = inventory.get(warehouse);

        for (Map.Entry<Product, Integer> entry : invoice.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int current = warehouseInventory.getOrDefault(product, 0);

            if (current < quantity) {
                throw new IllegalArgumentException("Недостаточно товара: " + product.getName());
            }
            warehouseInventory.put(product, current - quantity);
        }
    }

    private void processTransfer(Invoice invoice) {
        // Сначала списываем с исходного склада
        processOutgoing(invoice);

        // Затем добавляем на целевой склад
        // Меняем тип на "ПРИХОД" для обработки
        Invoice tempInvoice = new Invoice(invoice.getNumber(), invoice.getDate(), "ПРИХОД");
        tempInvoice.setToWarehouse(invoice.getToWarehouse());
        tempInvoice.getItems().putAll(invoice.getItems());
        processIncoming(tempInvoice);
    }

    // Геттеры
    public List<Warehouse> getWarehouses() { return new ArrayList<>(warehouses); }
    public List<Supplier> getSuppliers() { return new ArrayList<>(suppliers); }
    public List<Product> getProducts() { return new ArrayList<>(products); }
    public List<Invoice> getInvoices() { return new ArrayList<>(invoices); }

    public Map<Product, Integer> getWarehouseInventory(Warehouse warehouse) {
        return new HashMap<>(inventory.getOrDefault(warehouse, new HashMap<>()));
    }

    public List<Product> searchProduct(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Warehouse, Integer> searchProductInWarehouses(String productName) {
        Map<Warehouse, Integer> result = new HashMap<>();
        for (Warehouse warehouse : warehouses) {
            Map<Product, Integer> warehouseInventory = inventory.get(warehouse);
            for (Map.Entry<Product, Integer> entry : warehouseInventory.entrySet()) {
                if (entry.getKey().getName().toLowerCase().contains(productName.toLowerCase())) {
                    result.put(warehouse, result.getOrDefault(warehouse, 0) + entry.getValue());
                }
            }
        }
        return result;
    }
}