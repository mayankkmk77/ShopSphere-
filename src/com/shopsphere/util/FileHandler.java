package com.shopsphere.util;

import com.shopsphere.model.Product;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveProducts(ArrayList<Product> products) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"));
            oos.writeObject(products);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> loadProducts() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.dat"));
            return (ArrayList<Product>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}