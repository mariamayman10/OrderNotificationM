package OrderNotificationM.example.OrderNotificationM;


public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private double price;
    private Category category;
    public Product(String serialNumber, String name, String vendor, double price, Category category) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.category = category;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
