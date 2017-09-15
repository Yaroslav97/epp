package com.epam.poliakov.task9.shop.repository.order;

import com.epam.poliakov.task9.shop.entity.Order;

import java.util.Date;
import java.util.TreeMap;

/**
 * Interface consist basic methods for OrderRepository map.
 */
public interface OrderRepository {

    void buyAllProducts(Date date, Order cart);

    Order getOrderByDate(Date date);

    TreeMap<Date, Order> getOrderMap();
}
