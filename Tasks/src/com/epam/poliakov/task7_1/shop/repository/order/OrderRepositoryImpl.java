package com.epam.poliakov.task7_1.shop.repository.order;

import com.epam.poliakov.task7_1.shop.entity.Order;

import java.util.Date;
import java.util.TreeMap;

public class OrderRepositoryImpl implements OrderRepository {

    private TreeMap<Date, Order> orderMap = new TreeMap();

    @Override
    public void buyAllProducts(Date date, Order cart) {
        orderMap.put(date, cart);
    }

    @Override
    public Order getOrderByDate(Date date) {
        return orderMap.get(date);
    }

    public TreeMap<Date, Order> getOrderMap() {
        return orderMap;
    }
}
