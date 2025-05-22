package org.example.InventoryStockManager;

import org.example.UtilityClasses.Warehouse;

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
}
