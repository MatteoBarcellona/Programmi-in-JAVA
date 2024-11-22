import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {
    private OrderDAO orderDAO;
    private OrderService orderService;
    @BeforeEach
    void setUp() {
        orderDAO = mock(OrderDAO.class);
        orderService = new OrderService(orderDAO);
    }

    @Test
    void testAggiungiOrdine() {
        Order order = new Order(1, "cliente A", List.of("prodotto1"), 100.0);
        when(orderDAO.save(order)).thenReturn(true);
        boolean result = orderService.aggiungiOrdine(order);
        assertTrue(result);
        verify(orderDAO).save(order);
    }

    @Test
    void testTrovaOrdine() {
        Order order = new Order(1, "cliente A", List.of("prodotto1"), 50.0);
        when(orderDAO.findById(1)).thenReturn(Optional.of(order));
        Order result = orderService.trovaOrdine(1);
        assertNotNull(result);
        assertEquals(order, result);
        verify(orderDAO).findById(1);
    }

    @Test
    void testCalcolaTotaleOrdini() {
        Order order1 = new Order(1, "cliente A", List.of("prodotto1"), 50.0);
        Order order2 = new Order(2, "cliente B", List.of("prodotto2"), 150.0);
        when(orderDAO.findAll()).thenReturn(List.of(order1, order2));
        double total = orderService.calcolaTotaleOrdini();
        assertEquals(200.0, total, 0.01);
        verify(orderDAO).findAll();
    }
}
