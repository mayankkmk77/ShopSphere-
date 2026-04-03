package com.shopsphere.ui;

import com.shopsphere.model.Cart;
import com.shopsphere.model.Product;
import com.shopsphere.util.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BrowseProductsPage extends JFrame {

    private JPanel panel;
    private ArrayList<Product> products;
    private Cart cart;

    public BrowseProductsPage(Cart cart) {

        this.cart = cart;
        this.products = FileHandler.loadProducts();

        setTitle("Browse Products");
        setSize(500, 550);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(28, 28, 28));

        JTextField search = new JTextField();
        search.setBackground(new Color(50, 50, 50));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        search.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel = new JPanel(new GridLayout(0, 1, 12, 12));
        panel.setBackground(new Color(28, 28, 28));

        add(search, BorderLayout.NORTH);
        add(new JScrollPane(panel), BorderLayout.CENTER);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                loadProducts(search.getText());
            }
        });

        loadProducts("");

        setVisible(true);
    }

    private void loadProducts(String keyword) {
        panel.removeAll();

        for (Product p : products) {

            if (!p.getName().toLowerCase().contains(keyword.toLowerCase()))
                continue;

            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(new Color(45, 45, 45));
            card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel name = new JLabel(p.getName());
            name.setForeground(Color.WHITE);

            JLabel price = new JLabel("₹ " + p.getPrice());
            price.setForeground(new Color(180, 180, 180));

            JButton addBtn = new JButton("Add to Cart");

            addBtn.setBackground(new Color(41, 128, 185));
            addBtn.setForeground(Color.WHITE);

            addBtn.addActionListener(e -> {
                cart.addProduct(p);
                JOptionPane.showMessageDialog(this, "Nice choice! Added to cart 🛒");
            });

            JPanel info = new JPanel(new GridLayout(2, 1));
            info.setBackground(new Color(45, 45, 45));
            info.add(name);
            info.add(price);

            card.add(info, BorderLayout.CENTER);
            card.add(addBtn, BorderLayout.EAST);

            panel.add(card);
        }

        panel.revalidate();
        panel.repaint();
    }
}