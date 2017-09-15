package com.epam.poliakov.task4.repository.order;

import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.entity.Product;

import java.util.Date;
import java.util.Map;
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
