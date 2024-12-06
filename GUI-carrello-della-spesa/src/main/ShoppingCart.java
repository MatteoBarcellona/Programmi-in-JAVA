import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products.removeIf(product -> product.getName().equals(productName));
    }

    public void updateProductQuantity(String productName, int newQuantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setQuantity(newQuantity);
                return;
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getTotalPrice).sum();
    }

    public double applyDiscount() {
        double total = calculateTotal();
        return total > 100 ? total * 0.9 : total;
    }
}
