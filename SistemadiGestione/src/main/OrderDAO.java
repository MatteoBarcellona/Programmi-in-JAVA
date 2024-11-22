import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    boolean save(Order order);
    Optional<Order> findById(int id);
    List<Order> findAll();
    boolean delete(int id);
}
