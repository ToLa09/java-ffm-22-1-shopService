import java.util.*;


public class ProductRepo {

    private Map<String,Product> products = new HashMap<>();

    public ProductRepo() {
    }

    public ProductRepo(Map<String, Product> products) {
        this.products = products;
    }
    public void addProduct(Product product){
        UUID randomID = UUID.randomUUID();
        products.put(randomID.toString(),product);

    }

    public Product getProduct(UUID id) throws IllegalArgumentException {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        else {
            throw new IllegalArgumentException("No product found with given ID");
        }
    }

    public Map<String,Product> listProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

    public Product getProductBySerialID(int serialID) {
        for (Product entry: products.values()) {
            if (entry.getId() == serialID) {
                return entry;
            }
        }
        throw new RuntimeException("Kein Produkt mit dieser ID vorhanden");
    }


}
