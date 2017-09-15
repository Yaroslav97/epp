package com.epam.poliakov.task9.shop.repository.cart;

import com.epam.poliakov.task9.shop.entity.productEntity.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryImpl implements CartRepository {

    private Map<Vehicle, Integer> cartMap = new HashMap();

    @Override
    public void addToCart(Vehicle product, int countOfProduct) {
        cartMap.put(product, countOfProduct);
    }

    @Override
    public Map<Vehicle, Integer> getCartMap() {
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
