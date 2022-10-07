import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private List<Product> products;

    public Order(List<Product> products) {
        this.orderId = UUID.randomUUID();
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public UUID getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                '}';
    }
}

