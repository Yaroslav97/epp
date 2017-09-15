package com.epam.poliakov.task4.entity;

import java.util.Map;

public class Store {

    private Map<String, Product> store;

    public Store(Map<String, Product> store) {
        this.store = store;
    }

    public Map<String, Product> getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store=" + store +
                '}';
    }
}
