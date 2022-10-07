public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1,"Banane",0.99);
        Product product2 = new Product(2,"Apfel", 0.39 );
        Product product3 = new Product(3,"Chips", 1.99);
        Product product4 = new Product(4,"Kartoffeln",2.99);

        ShopService myShop = new ShopService();

        myShop.addProduct(product1);
        myShop.addProduct(product2);
        myShop.addProduct(product3);
        myShop.addProduct(product4);

        System.out.println(myShop.listProducts());
        System.out.println(myShop.getProductBySerialID(2));


//
//        Map<UUID,Product> productList = new HashMap<>(Map.of(
//                UUID.randomUUID(), product1,
//                UUID.randomUUID(), product2,
//                UUID.randomUUID(), product3,
//                UUID.randomUUID(), product4
//        ));
//
//        System.out.println(productList);
//        ProductRepo productRepo = new ProductRepo(productList);
//
//        System.out.println(productRepo);

    }
}