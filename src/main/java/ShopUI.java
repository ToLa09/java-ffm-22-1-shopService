import model.Product;
import service.ShopService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopUI extends JFrame implements ActionListener {
    private JButton showProductsButton;
    private JButton orderProductsButton;

    private JPanel orderPanel;
    private JLabel productList;
    private JTextArea productArea;

    private ShopService myShop;

    public ShopUI() throws HeadlessException {
        Product product1 = new Product(1,"Banane",0.99);
        Product product2 = new Product(2,"Apfel", 0.39 );
        Product product3 = new Product(3,"Chips", 1.99);
        Product product4 = new Product(4,"Kartoffeln",2.99);

        myShop = new ShopService();

        myShop.addProduct(product1);
        myShop.addProduct(product2);
        myShop.addProduct(product3);
        myShop.addProduct(product4);

        JFrame orderFrame = new JFrame();
        orderPanel = new JPanel();
        showProductsButton = new JButton("Produkte anzeigen");
        orderProductsButton = new JButton("Produkte bestellen");

        showProductsButton.addActionListener(this);
        orderProductsButton.addActionListener(this);

        orderFrame.setSize(1000,500);
        orderFrame.setTitle("Order Products");
        JLabel headTextLabel = new JLabel();
        headTextLabel.setText("Willkommen im Shop");
        productList = new JLabel();
        productArea = new JTextArea();

        orderPanel.add(headTextLabel);
        orderPanel.add(showProductsButton);
        orderPanel.add(productArea);
        orderFrame.add(orderPanel);
        //orderFrame.pack();
        //orderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.showProductsButton){
            String products = myShop.listProducts();
            productArea.setText(products);
        }
    }
}
