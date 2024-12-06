public class Product {
    private String name;
    private double unitPrice;
    private int quantity;
    
    public Product(String name, double unitPrice, int quantity) {

        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " x " + unitPrice + "€";
    }
}
