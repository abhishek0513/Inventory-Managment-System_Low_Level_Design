package org.example.UtilityClasses;

import org.example.ProductFactory.Product;

import javax.sound.sampled.Port;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product>products;

    public Warehouse(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        //TODO
    }
    public boolean deleteProduct(String sku, int quantity){
        //TODO
        return true;
    }

    public int getAvailableQuantity(String sku) {
        if (products.containsKey(sku)) {
            return products.get(sku).getQuantity();
        }
        return 0; // Product not found
    }

    // Get a product by SKU
    public Product getProductBySku(String sku) {
        return products.get(sku);
    }

    // Get all products in this warehouse
    public Collection<Product> getAllProducts() {
        return products.values();
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
