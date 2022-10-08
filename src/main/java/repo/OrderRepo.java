package repo;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private List<Order> orderList;

    public OrderRepo() {
        orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order getOrder(String orderId) {
        for (Order o : orderList) {
            if (o.getOrderId() == orderId) {
                return o;
            }
        }
        throw new IllegalArgumentException("Keine Bestellung mit dieser Bestellnummer gefunden");
    }

    @Override
    public String toString() {
        return "repo.OrderRepo{" +
                "orderList=" + orderList +
                '}';
    }
}
