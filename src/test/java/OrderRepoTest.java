import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void addOrder() {
        //GIVEN
        Product newProduct = new Product(1, "testprodukt", 0.99);
        Order newOrder = new Order(List.of(newProduct));
        OrderRepo newOrderRepo = new OrderRepo();
        //WHEN
        newOrderRepo.addOrder(newOrder);
        Order actual = newOrderRepo.getAllOrders().get(0);
        //THEN
        Order expected = newOrder;
        assertEquals(expected,actual);
    }

    @Test
    void getOrder() {
        //GIVEN
        Product product1 = new Product(1,"Banane",0.99);
        Product product2 = new Product(2,"Apfel", 0.39 );
        OrderRepo testOrderRepo = new OrderRepo();
        Order testOrder = new Order(new ArrayList<Product>(List.of(product1,product2)));
        testOrderRepo.addOrder(testOrder);
        //WHEN
        Order actual = testOrderRepo.getOrder(testOrder.getOrderId());
        //THEN
        assertEquals(testOrder, actual);
    }
}