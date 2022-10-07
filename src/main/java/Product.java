public class Product {

    private final int serialNumber;
    private final String name;
    private double price;

    public Product(int serialNumber, String name,double price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return serialNumber;
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
        return "\nProduct{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
