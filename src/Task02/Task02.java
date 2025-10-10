/*В компании XXX есть несколько складов с продукцией, каждый склад имеет
свой собственный юридический адрес. Регистрация поступления или отгрузки товаров осуществляется по накладной (документ).
Товары могут поступать как от внешних поставщиков, так и перемещаться между складами компании.
Накладная имеет такие данные (см. рисунок).
Задача – разработать программу складского учета. Программа должна:
- содержать форму ввода накладной;
- выводить список всех товаров на складе;
- выводить список всех внешних поставщиков;
- искать товар на складе по наименованию.
*/

package Task02;

import java.util.*;
import java.time.LocalDate;

public class Task02 {
    public static void main(String[] args) {
        WarehouseSystem system = new WarehouseSystem();

        // Создаем склады
        Warehouse mainWarehouse = new Warehouse("Основной склад", "ул. Центральная, 1");
        Warehouse secondWarehouse = new Warehouse("Дополнительный склад", "ул. Заводская, 15");

        system.addWarehouse(mainWarehouse);
        system.addWarehouse(secondWarehouse);

        // Создаем поставщиков
        Supplier supplier1 = new Supplier("ООО 'ТехноПоставка'", "ул. Поставщиков, 10", "+7-999-111-11-11");
        Supplier supplier2 = new Supplier("ИП Иванов", "ул. Торговая, 25", "+7-999-222-22-22");

        system.addSupplier(supplier1);
        system.addSupplier(supplier2);

        // Создаем товары
        Product laptop = new Product("Ноутбук Dell", "шт.", 75000.0);
        Product mouse = new Product("Мышь компьютерная", "шт.", 2500.0);
        Product keyboard = new Product("Клавиатура механическая", "шт.", 5500.0);
        Product monitor = new Product("Монитор 27\"", "шт.", 35000.0);

        system.addProduct(laptop);
        system.addProduct(mouse);
        system.addProduct(keyboard);
        system.addProduct(monitor);

        // 1. ФОРМА ВВОДА НАКЛАДНОЙ - ПРИХОД
        System.out.println("\n1. ФОРМА ВВОДА НАКЛАДНОЙ - ПРИХОД ОТ ПОСТАВЩИКА:");
        System.out.println("=================================================");

        Invoice invoice1 = system.createInvoice("ПР-001", LocalDate.of(2024, 1, 15), "ПРИХОД");
        invoice1.setSupplier(supplier1);
        invoice1.setToWarehouse(mainWarehouse);
        invoice1.setBasis("Договор поставки №123 от 10.01.2024");

        // Добавляем товары в накладную
        invoice1.addItem(laptop, 5);
        invoice1.addItem(mouse, 20);
        invoice1.addItem(keyboard, 10);

        // Обрабатываем накладную
        system.processInvoice(invoice1);

        // Выводим данные накладной (как в форме)
        System.out.println("Накладная №: " + invoice1.getNumber());
        System.out.println("Дата: " + invoice1.getDate());
        System.out.println("Тип: " + invoice1.getType());
        System.out.println("Поставщик: " + invoice1.getSupplier());
        System.out.println("Склад получения: " + invoice1.getToWarehouse());
        System.out.println("Основание: " + invoice1.getBasis());
        System.out.println("\nТовары:");
        System.out.println("----------------------------------------");
        System.out.println("Наименование\tЕд.изм.\tКол-во\tЦена\tСумма");
        System.out.println("----------------------------------------");

        double totalAmount = 0;
        for (Map.Entry<Product, Integer> entry : invoice1.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double sum = product.getPrice() * quantity;
            totalAmount += sum;

            System.out.printf("%s\t%s\t%d\t%.2f\t%.2f\n",
                    product.getName(), product.getUnit(), quantity, product.getPrice(), sum);
        }
        System.out.println("----------------------------------------");
        System.out.printf("ИТОГО: %.2f руб.\n", totalAmount);

        // 2. ВТОРАЯ НАКЛАДНАЯ - ПЕРЕМЕЩЕНИЕ МЕЖДУ СКЛАДАМИ
        System.out.println("\n\n2. ФОРМА ВВОДА НАКЛАДНОЙ - ПЕРЕМЕЩЕНИЕ МЕЖДУ СКЛАДАМИ:");
        System.out.println("========================================================");

        Invoice invoice2 = system.createInvoice("ПЕР-001", LocalDate.now(), "ПЕРЕМЕЩЕНИЕ");
        invoice2.setFromWarehouse(mainWarehouse);
        invoice2.setToWarehouse(secondWarehouse);
        invoice2.setBasis("Внутреннее перемещение");

        invoice2.addItem(laptop, 2);
        invoice2.addItem(mouse, 5);

        system.processInvoice(invoice2);

        System.out.println("Накладная №: " + invoice2.getNumber());
        System.out.println("Склад отправитель: " + invoice2.getFromWarehouse());
        System.out.println("Склад получатель: " + invoice2.getToWarehouse());
        System.out.println("Товары перемещены успешно");

        // 3. ВЫВОДИМ СПИСОК ВСЕХ ТОВАРОВ НА СКЛАДАХ
        System.out.println("\n\n3. СПИСОК ВСЕХ ТОВАРОВ НА СКЛАДАХ:");
        System.out.println("===================================");

        for (Warehouse warehouse : system.getWarehouses()) {
            System.out.println("\n" + warehouse + ":");
            Map<Product, Integer> warehouseInventory = system.getWarehouseInventory(warehouse);

            if (warehouseInventory.isEmpty()) {
                System.out.println("  Склад пуст");
            } else {
                System.out.println("  Наименование\tКол-во\tЕд.изм.");
                System.out.println("  ---------------------------------");
                for (Map.Entry<Product, Integer> entry : warehouseInventory.entrySet()) {
                    System.out.printf("  %s\t%d\t%s\n",
                            entry.getKey().getName(), entry.getValue(), entry.getKey().getUnit());
                }
            }
        }

        // 4. ВЫВОДИМ СПИСОК ВСЕХ ВНЕШНИХ ПОСТАВЩИКОВ
        System.out.println("\n\n4. СПИСОК ВСЕХ ВНЕШНИХ ПОСТАВЩИКОВ:");
        System.out.println("===================================");

        for (Supplier supplier : system.getSuppliers()) {
            System.out.println("  " + supplier);
        }

        // 5. ПОИСК ТОВАРА ПО НАИМЕНОВАНИЮ
        System.out.println("\n\n5. ПОИСК ТОВАРА 'МЫШЬ' НА ВСЕХ СКЛАДАХ:");
        System.out.println("========================================");

        Map<Warehouse, Integer> searchResults = system.searchProductInWarehouses("мышь");
        if (searchResults.isEmpty()) {
            System.out.println("  Товар не найден");
        } else {
            for (Map.Entry<Warehouse, Integer> entry : searchResults.entrySet()) {
                System.out.println("  " + entry.getKey().getName() + ": " + entry.getValue() + " шт.");
            }
        }

        // 6. РАСХОДНАЯ НАКЛАДНАЯ
        System.out.println("\n\n6. ФОРМА ВВОДА НАКЛАДНОЙ - РАСХОД:");
        System.out.println("===================================");

        Invoice invoice3 = system.createInvoice("РСХ-001", LocalDate.now(), "РАСХОД");
        invoice3.setFromWarehouse(mainWarehouse);
        invoice3.setBasis("Заказ клиента №456");

        invoice3.addItem(mouse, 3);
        invoice3.addItem(keyboard, 2);

        system.processInvoice(invoice3);

        System.out.println("Накладная №: " + invoice3.getNumber());
        System.out.println("Товары отгружены со склада: " + invoice3.getFromWarehouse());
        System.out.println("Основание: " + invoice3.getBasis());

        // ФИНАЛЬНОЕ СОСТОЯНИЕ СКЛАДОВ
        System.out.println("\n\nФИНАЛЬНОЕ СОСТОЯНИЕ СКЛАДОВ:");
        System.out.println("============================");

        for (Warehouse warehouse : system.getWarehouses()) {
            System.out.println("\n" + warehouse + ":");
            Map<Product, Integer> warehouseInventory = system.getWarehouseInventory(warehouse);

            for (Map.Entry<Product, Integer> entry : warehouseInventory.entrySet()) {
                System.out.printf("  %s: %d %s\n",
                        entry.getKey().getName(), entry.getValue(), entry.getKey().getUnit());
            }
        }
    }
}