package org.example.InventoryStockManager;

import org.example.ProductFactory.Product;
import org.example.ProductFactory.ProductFactory;
import org.example.ProductReplenishmentStrategy.ReplenishmentStrategy;
import org.example.UtilityClasses.Warehouse;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager(ReplenishmentStrategy replenishmentStrategy){
        warehouses = new ArrayList<>();
        productFactory = new ProductFactory();
        this.replenishmentStrategy = replenishmentStrategy;
    }
    //SingleTon design pattern;
    public static synchronized InventoryManager getInstance(ReplenishmentStrategy replenishmentStrategy){
        if(instance == null)
            instance = new InventoryManager(replenishmentStrategy);

        return instance;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    // Warehouse management
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }
    public Product getProductBySKU(String sku){
        for(Warehouse warehouse : warehouses){
            Product product = warehouse.getProductBySku(sku);
            if(product != null)
                return product;
        }
        return null;
    }

    public void checkAndReplenish(String sku)
    {
        Product product= getProductBySKU(sku);
        if(product != null){
            if(product.getQuantity() < product.getThreshold()){
                if(replenishmentStrategy != null){
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    if (replenishmentStrategy != null)  replenishmentStrategy.replenish(product);
                }
            }
        }
    }






}
