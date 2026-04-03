package com.shopsphere.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;
    private String imagePath;

    public Product(String name, double price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}