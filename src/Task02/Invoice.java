package Task02;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Invoice {
    private String number;
    private LocalDate date;
    private String type; // "ПРИХОД", "РАСХОД", "ПЕРЕМЕЩЕНИЕ"
    private Supplier supplier;
    private Warehouse fromWarehouse;
    private Warehouse toWarehouse;
    private String basis; // основание
    private Map<Product, Integer> items; // товар -> количество

    public Invoice(String number, LocalDate date, String type) {
        this.number = number;
        this.date = date;
        this.type = type;
        this.items = new HashMap<>();
    }

    // Сеттеры
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setFromWarehouse(Warehouse warehouse) { this.fromWarehouse = warehouse; }
    public void setToWarehouse(Warehouse warehouse) { this.toWarehouse = warehouse; }
    public void setBasis(String basis) { this.basis = basis; }

    // Геттеры
    public String getNumber() { return number; }
    public LocalDate getDate() { return date; }
    public String getType() { return type; }
    public Supplier getSupplier() { return supplier; }
    public Warehouse getFromWarehouse() { return fromWarehouse; }
    public Warehouse getToWarehouse() { return toWarehouse; }
    public String getBasis() { return basis; }
    public Map<Product, Integer> getItems() { return new HashMap<>(items); }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double getTotalAmount() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return "Накладная №" + number + " от " + date + " (" + type + ")";
    }
}