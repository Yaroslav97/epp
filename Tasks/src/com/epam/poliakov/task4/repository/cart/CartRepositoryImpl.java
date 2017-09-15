package com.epam.poliakov.task4.repository.cart;

import com.epam.poliakov.task4.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryImpl implements CartRepository {

    private Map<Product, Integer> cartMap = new HashMap();

    @Override
    public void addToCart(Product product, int countOfProduct) {
        cartMap.put(product, countOfProduct);
    }

    @Override
    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    @Override
    public void clearCart() {
        cartMap.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
