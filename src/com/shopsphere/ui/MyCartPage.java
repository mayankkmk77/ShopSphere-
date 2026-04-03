package com.shopsphere.ui;

import com.shopsphere.model.Cart;
import com.shopsphere.model.Product;

import javax.swing.*;
import java.awt.*;

public class MyCartPage extends JFrame {

    private JPanel panel;
    private JLabel totalLabel;

    public MyCartPage(Cart cart) {

        setTitle("My Cart");
        setSize(450, 500);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(28, 28, 28));

        panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBackground(new Color(28, 28, 28));

        totalLabel = new JLabel();
        totalLabel.setForeground(Color.WHITE);

        JButton checkout = new JButton("Checkout");

        checkout.setBackground(new Color(39, 174, 96));
        checkout.setForeground(Color.WHITE);

        checkout.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Order placed successfully!\nTotal: ₹" + cart.getTotal());

            cart.getItems().clear();
            refresh(cart);
        });

        add(totalLabel, BorderLayout.NORTH);
        add(new JScrollPane(panel), BorderLayout.CENTER);
        add(checkout, BorderLayout.SOUTH);

        refresh(cart);

        setVisible(true);
    }

    private void refresh(Cart cart) {
        panel.removeAll();

        int i = 0;

        for (Product p : cart.getItems()) {

            int index = i;

            JPanel row = new JPanel();
            row.setBackground(new Color(45, 45, 45));

            JLabel label = new JLabel(p.toString());
            label.setForeground(Color.WHITE);

            JButton remove = new JButton("Remove");
            remove.setBackground(new Color(192, 57, 43));
            remove.setForeground(Color.WHITE);

            remove.addActionListener(e -> {
                cart.removeProduct(index);
                refresh(cart);
            });

            row.add(label);
            row.add(remove);

            panel.add(row);
            i++;
        }

        // custom total + count
        totalLabel.setText("Items: " + cart.getItems().size() +
                " | Total: ₹" + cart.getTotal());

        panel.revalidate();
        panel.repaint();
    }
}