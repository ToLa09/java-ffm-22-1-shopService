package model;

public class Product {

    private final int productNumber;
    private final String name;
    private double price;

    public Product(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public int getSerialnumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}";
    }

}
