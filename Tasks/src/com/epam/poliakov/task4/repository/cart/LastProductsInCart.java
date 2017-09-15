package com.epam.poliakov.task4.repository.cart;

import com.epam.poliakov.task4.entity.Product;

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
    private Map<Product, Product> topLastCart = new LinkedHashMap() {
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
     * Method add Product in map.
     * @param product
     */
    public void addToLastProduct(Product product) {
        topLastCart.put(product, product);
    }

    public Map<Product, Product> getTopLastCart(){
        return topLastCart;
    }
}
