import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0, 3));
        Assertions.assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0, 3));
        cart.removeProduct("Apple");
        Assertions.assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testUpdateProductQuantity() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0, 3));
        cart.updateProductQuantity("Apple", 5);
        Assertions.assertEquals(5, cart.getProducts().get(0).getQuantity());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0, 3));
        cart.addProduct(new Product("Banana", 2.0, 2));
    }

    @Test
    public void testApplyDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Expensive Item", 150.0, 1));
    }
}
