package com.epam.poliakov.DAO.cart_dao;

import com.epam.poliakov.DAO.entity.Product;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CartImpl implements Cart {

    private Map<Product, Integer> map;

    public CartImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(Product product) {
        int count = 1;

        if (map.containsKey(product)){
         count += map.get(product);
        }
        map.put(product, count);
    }

    @Override
    public Product getProductItem(String productName) {

        for (Product product : map.keySet()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Integer getCartPrice() {
        int totalSum = 0;

        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            totalSum += entry.getKey().getPrice() * entry.getValue();
        }
        return totalSum;
    }

    @Override
    public void remove(Product product) {
        map.remove(product);
    }

    @Override
    public Map<Product, Integer> getMap() {
        return Collections.unmodifiableMap(map);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return "CartImpl{" +
                "map=" + map +
                '}';
    }
}
