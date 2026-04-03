package com.shopsphere.ui;

import com.shopsphere.model.Product;
import com.shopsphere.util.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddProductPage extends JFrame {

    public AddProductPage(ArrayList<Product> products) {

        setTitle("Add Product");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField imageField = new JTextField();

        JButton saveBtn = new JButton("Save");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Price:"));
        add(priceField);
        add(new JLabel("Image Path:"));
        add(imageField);
        add(new JLabel());
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String image = imageField.getText();

                products.add(new Product(name, price, image));
                FileHandler.saveProducts(products);

                JOptionPane.showMessageDialog(this, "Saved ✅");

                nameField.setText("");
                priceField.setText("");
                imageField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error ❌");
            }
        });

        setVisible(true);
    }
}