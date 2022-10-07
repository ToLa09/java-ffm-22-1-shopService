import java.util.UUID;

public class ShopService {

    private ProductRepo productRepo;

    public ShopService() {
        productRepo = new ProductRepo();
    }

    public void addProduct(Product product) {
        productRepo.addProduct(product);
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
