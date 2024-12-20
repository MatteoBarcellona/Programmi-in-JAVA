import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String name;
    private double currentPrice;
    private List<Double> priceHistory;

    public Stock(String name, double initialPrice) {
        this.name = name;
        this.currentPrice = initialPrice;
        this.priceHistory = new ArrayList<>();
        priceHistory.add(initialPrice);
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public List<Double> getPriceHistory() {
        return priceHistory;
    }

    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        priceHistory.add(newPrice);
    }
}
