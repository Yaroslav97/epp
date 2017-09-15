package com.epam.poliakov.task4.repository.order;

import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.entity.Product;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Interface consist basic methods for OrderRepository map.
 */
public interface OrderRepository {

    void buyAllProducts(Date date, Order cart);

    Order getOrderByDate(Date date);

    TreeMap<Date, Order> getOrderMap();
}
