package Task02;
public class Product {
    private String name;
    private String unit;
    private double price;

    public Product(String name, String unit, double price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getName() { return name; }
    public String getUnit() { return unit; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + unit + ") - " + price + " руб.";
    }
}