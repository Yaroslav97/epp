package com.epam.poliakov.task4.entity;

import java.util.Map;

public class Order {

    private Map<Product, Integer> order;

    public Order(Map<Product, Integer> order) {
        this.order = order;
    }

    public Map<Product, Integer> getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return this.order != null ? this.order.equals(order.order) : order.order == null;
    }

    @Override
    public int hashCode() {
        return order != null ? order.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order=" + order +
                '}';
    }
}
