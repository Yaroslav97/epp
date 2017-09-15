package com.epam.poliakov.task6.shop.repository.cart;

import com.epam.poliakov.task6.shop.entity.product.Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class display top five last items in carts.
 */
public class LastProductsInCart {

    public static final int LAST_PRODUCTS_SIZE = 5;
    /**
     * Map stores 5 last Products.
     */
    private Map<Vehicle, Vehicle> topLastCart = new LinkedHashMap() {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > LAST_PRODUCTS_SIZE;
        }
    };

    /**
     * @return true if map is empty.
     */
    public boolean isEmpty() {
        return topLastCart.isEmpty();
    }

    /**
     * Method add GetProduct in map.
     * @param product
     */
    public void addToLastProduct(Vehicle product) {
        topLastCart.put(product, product);
    }

    public Map<Vehicle, Vehicle> getTopLastCart(){
        return topLastCart;
    }
}
