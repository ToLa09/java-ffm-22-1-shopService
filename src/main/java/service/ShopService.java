package service;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    private String generateUUID() {
        UUID randomID = UUID.randomUUID();
        return randomID.toString();
    }

    public ShopService() {
        productRepo = new ProductRepo();
        orderRepo = new OrderRepo();
    }

    public void addProduct(Product product) {
        String uuid = generateUUID();
        productRepo.addProduct(uuid, product);
    }

    public String orderProducts(List<Product> productList) {
        Order newOrder = new Order(generateUUID(),productList);
        orderRepo.addOrder(newOrder);
        return newOrder.getOrderId();
    }

    public String listProducts() {
        return productRepo.toString();
    }

    public Map<String, Product> getProductList(){
        return productRepo.listProducts();
    }

    public Product getProduct(String uuid){
        return productRepo.getProduct(uuid);
    }

    public Product getProductBySerialID(int serialID) {
        return productRepo.getProductBySerialID(serialID);
    }

    public Order getOrder(String orderId){
        return orderRepo.getOrder(orderId);
    }

    public String listOrders(){
        return orderRepo.toString();
    }

}
