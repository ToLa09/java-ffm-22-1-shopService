import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void addAndGetProduct() {
        //given
        Product testProduct = new Product(1234,"tester",99.99);
        ProductRepo testRepo = new ProductRepo();
        String uuid = "test";
        testRepo.addProduct(uuid, testProduct);
        //when
        Product actual = testRepo.getProduct(uuid);
        //then
        Product expected = testProduct;
        assertEquals(expected,actual);
    }

    @Test
    void getProductBySerialID() {
        //given
        Product testProduct = new Product(1234,"tester",99.99);
        ProductRepo testRepo = new ProductRepo();
        String uuid = "test";
        testRepo.addProduct(uuid, testProduct);
        //when
        Product actual = testRepo.getProductBySerialID(1234);
        //then
        Product expected = testProduct;
        assertEquals(expected,actual);
    }
}