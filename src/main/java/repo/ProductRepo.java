package repo;

import model.Product;

import java.util.*;


public class ProductRepo {

    private Map<String,Product> products = new HashMap<>();

    public ProductRepo() {
    }

    public ProductRepo(Map<String, Product> products) {
        this.products = products;
    }
    public void addProduct(String uuid, Product product){
        products.put(uuid,product);
    }

    public Product getProduct(String id) throws IllegalArgumentException {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        else {
            throw new IllegalArgumentException("No product found with given ID");
        }
    }

    public Map<String, Product> listProducts() {
        return products;
    }

    @Override
    public String toString() {
        String output = "Folgende Produkte sind verfügbar:\n";
        for (Product entry: products.values()) {
            output = output.concat(entry.toString()).concat("\n");
        }
        return output;
    }

    public Product getProductBySerialID(int serialID) {
        for (Product entry: products.values()) {
            if (entry.getSerialnumber() == serialID) {
                return entry;
            }
        }
        throw new RuntimeException("Kein Produkt mit dieser ID vorhanden");
    }
}
