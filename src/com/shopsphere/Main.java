package com.shopsphere;

import com.shopsphere.ui.HomePage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            UIManager.put("control", new java.awt.Color(40, 40, 40));
            UIManager.put("nimbusLightBackground", new java.awt.Color(30, 30, 30));
            UIManager.put("text", new java.awt.Color(230, 230, 230));

        } catch (Exception e) {
            e.printStackTrace();
        }

        new HomePage();
    }
}