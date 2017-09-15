package com.epam.poliakov.task6.shop.service;

import com.epam.poliakov.task6.shop.entity.Order;
import com.epam.poliakov.task6.shop.entity.product.Vehicle;
import com.epam.poliakov.task6.shop.repository.order.OrderRepository;
import com.epam.poliakov.task6.shop.repository.order.OrderRepositoryImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class contain methods to display some info in OrderRepository.
 */
public class OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    /**
     * Method add CartRepository in OrderRepository by date and then clear CartRepository with bought Products.
     *
     * @param date
     * @param cart
     */
    public void buyProducts(Date date, Order cart) {

        Map<Vehicle, Integer> copyCart = new HashMap<>(cart.getOrder());

        orderRepository.buyAllProducts(date, new Order(copyCart));
    }

    /**
     * Method gets OrderRepository by date.
     *
     * @param date
     */
    public Order getOrdersByDate(Date date) {
        return orderRepository.getOrderByDate(date);
    }

    /**
     * Method gets OrderRepository by nearest date.
     *
     * @param date
     */
    public Map<Vehicle, Integer> getOrderByNearestDate(Date date) {

        Date low = orderRepository.getOrderMap().floorKey(date);
        Date high = orderRepository.getOrderMap().ceilingKey(date);

        if (low == null && high != null) {
            return orderRepository.getOrderMap().get(high).getOrder();
        }
        if (low != null && high == null) {
            return orderRepository.getOrderMap().get(low).getOrder();
        }
        if (low != null && high != null) {
            long lowTime = low.getTime();
            long highTime = high.getTime();

            long currentTime = date.getTime();

            long lDiff = Math.abs(currentTime - lowTime);
            long hDiff = Math.abs(currentTime - highTime);

            if (lDiff < hDiff) {
                return orderRepository.getOrderMap().get(low).getOrder();
            } else {
                return orderRepository.getOrderMap().get(high).getOrder();
            }
        }
        return null;
    }

    public TreeMap<Date, Order> getMap() {
        return orderRepository.getOrderMap();
    }
}
