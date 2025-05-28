package org.example.ProductReplenishmentStrategy;

import org.example.ProductFactory.Product;

public interface ReplenishmentStrategy {
    void replenish(Product product);
}
