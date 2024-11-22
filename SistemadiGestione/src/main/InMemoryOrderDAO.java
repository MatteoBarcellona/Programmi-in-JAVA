import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryOrderDAO implements OrderDAO {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public boolean save(Order order) {
        return orders.add(order);
    }

    @Override
    public Optional<Order> findById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean delete(int id) {
        return orders.removeIf(order -> order.getId() == id);
    }
}
