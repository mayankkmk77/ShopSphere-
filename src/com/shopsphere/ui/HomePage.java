package com.shopsphere.ui;

import com.shopsphere.model.Cart;
import com.shopsphere.model.Product;
import com.shopsphere.util.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class HomePage extends JFrame {

    private ArrayList<Product> products;
    private Cart cart;

    public HomePage() {

        products = FileHandler.loadProducts();
        cart = new Cart();

        setTitle("SmartCart Dashboard");
        setSize(500, 400);
        setLayout(new GridBagLayout()); // center layout

        getContentPane().setBackground(new Color(24, 24, 24));

        // 📦 Card Panel (center box)
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(350, 300));
        card.setBackground(new Color(38, 38, 38));
        card.setLayout(new GridLayout(4, 1, 15, 15));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 🏷 Title
        JLabel title = new JLabel("🛍 SmartCart", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        // 🔘 Buttons
        JButton addBtn = new JButton("Add Product");
        JButton browseBtn = new JButton("Browse Products");
        JButton cartBtn = new JButton("Open Cart");

        // 🎨 Colors
        Color normal = new Color(41, 128, 185);
        Color hover = new Color(31, 97, 141);

        JButton[] buttons = {addBtn, browseBtn, cartBtn};

        for (JButton btn : buttons) {

            btn.setBackground(normal);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            btn.setOpaque(true);

            // 🔥 Hover effect
            btn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(hover);
                }

                public void mouseExited(MouseEvent e) {
                    btn.setBackground(normal);
                }
            });
        }

        // 📦 Add components to card
        card.add(title);
        card.add(addBtn);
        card.add(browseBtn);
        card.add(cartBtn);

        add(card); // center card

        // 🔗 Navigation
        addBtn.addActionListener(e -> new AddProductPage(products));
        browseBtn.addActionListener(e -> new BrowseProductsPage(cart));
        cartBtn.addActionListener(e -> new MyCartPage(cart));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}