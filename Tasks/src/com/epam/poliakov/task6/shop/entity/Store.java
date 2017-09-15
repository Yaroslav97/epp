package com.epam.poliakov.task6.shop.entity;

import com.epam.poliakov.task6.shop.entity.product.Vehicle;

import java.io.Serializable;
import java.util.Map;

public class Store implements Serializable {

    private Map<String, Vehicle> store;

    public Store(Map<String, Vehicle> store) {
        this.store = store;
    }

    public Map<String, Vehicle> getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store=" + store +
                '}';
    }
}
