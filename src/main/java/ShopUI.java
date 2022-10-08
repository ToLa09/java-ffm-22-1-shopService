import model.Product;
import service.ShopService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ShopUI extends JFrame implements ActionListener {
    private JButton showProductsButton;
    private JButton orderProductsButton;
    private JButton showOrdersButton;

    private JLabel productList;
    private JTextArea productArea;
    private JList productSelection;

    private ShopService myShop;
    private Map<String, Product> products;

    public ShopUI() throws HeadlessException {
        Product product1 = new Product(1412,"Banane",0.49);
        Product product2 = new Product(2151,"Apfel", 0.39 );
        Product product3 = new Product(3643,"Chips", 0.99);
        Product product4 = new Product(5234,"Kartoffeln",3.99);
        Product product5 = new Product(9624,"Nudeln",1.19);
        Product product6 = new Product(8644,"Pesto",3.69);
        Product product7 = new Product(7754,"Eis",2.99);

        myShop = new ShopService();

        myShop.addProduct(product1);
        myShop.addProduct(product2);
        myShop.addProduct(product3);
        myShop.addProduct(product4);
        myShop.addProduct(product5);
        myShop.addProduct(product6);
        myShop.addProduct(product7);


        JFrame orderFrame = new JFrame();
        JPanel Panel = new JPanel();
        JLabel headTextLabel = new JLabel();
        showProductsButton = new JButton("Produkte anzeigen");
        orderProductsButton = new JButton("Produkt bestellen");
        showOrdersButton = new JButton("Bestellungen anzeigen");
        productList = new JLabel();
        productArea = new JTextArea();
        productArea.setSize(200,400);


        Panel.setLayout( new javax.swing.BoxLayout(Panel, javax.swing.BoxLayout.Y_AXIS) );

        products = myShop.getProductList();
        productSelection = new JList<>(products.keySet().toArray());

        showProductsButton.addActionListener(this);
        orderProductsButton.addActionListener(this);
        showOrdersButton.addActionListener(this);

        orderFrame.setSize(1000,500);
        orderFrame.setTitle("Order Products");
        headTextLabel.setText("Willkommen im Shop");

        Panel.add(headTextLabel);
        Panel.add(showProductsButton);
        Panel.add(showOrdersButton);
        Panel.add(productArea);
        Panel.add(productSelection);
        Panel.add(orderProductsButton);
        orderFrame.add(Panel);
        //orderFrame.pack();
        orderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.showProductsButton){
            productArea.setText("");
            String products = myShop.listProducts();
            productArea.setText(products);
        }
        if(e.getSource() == this.orderProductsButton){
            String selectedProduct = productSelection.getSelectedValue().toString();
            List<Product> productList = new ArrayList<>(List.of(
                myShop.getProduct(selectedProduct)
            ));
            String orderId = myShop.orderProducts(productList);
            productArea.setText("Ihre Bestellnummer lautet:\n" + orderId);
        }
        if(e.getSource() == this.showOrdersButton){
            productArea.setText("");
            String orders = myShop.listOrders();
            productArea.setText(orders);
        }
    }
}
