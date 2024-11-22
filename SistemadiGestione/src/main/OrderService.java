import java.util.List;
import java.util.Optional;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public boolean aggiungiOrdine(Order order) {
        return orderDAO.save(order);
    }

    public Order trovaOrdine(int id) {
        Optional<Order> ordine = orderDAO.findById(id);
        return ordine.orElseThrow(() -> new RuntimeException("Ordine non trovato con ID: " + id));
    }

    public List<Order> tuttiGliOrdini() {
        return orderDAO.findAll();
    }

    public boolean eliminaOrdine(int id) {
        return orderDAO.delete(id);
    }

    public double calcolaTotaleOrdini() {
        return orderDAO.findAll().stream()
                .mapToDouble(Order::getPrezzoTotale)
                .sum();
    }
}
