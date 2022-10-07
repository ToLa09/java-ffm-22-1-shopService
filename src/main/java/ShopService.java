import java.util.List;
import java.util.UUID;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService() {
        productRepo = new ProductRepo();
        orderRepo = new OrderRepo();
    }

    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    public String orderProducts(List<Product> productList) {
        Order newOrder = new Order(productList);
        orderRepo.addOrder(newOrder);
        return newOrder.getOrderId();
    }

    public String listProducts() {
        return productRepo.toString();
    }

    public Product getProduct(UUID uuid){
        return productRepo.getProduct(uuid);
    }

    public Product getProductBySerialID(int serialID) {
        return productRepo.getProductBySerialID(serialID);
    }
}
