package com.epam.poliakov.DAO.entity;

import java.util.Map;

public class OrderProduct {

    private Map<Product, Integer> productMap;

    public OrderProduct(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "productMap=" + productMap +
                '}';
    }
}
