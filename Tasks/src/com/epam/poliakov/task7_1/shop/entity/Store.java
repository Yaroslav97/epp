package com.epam.poliakov.task7_1.shop.entity;

import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

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
