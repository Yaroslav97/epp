package com.epam.poliakov.DAO.order_dao;

import com.epam.poliakov.DAO.entity.Order;

import java.sql.Connection;

public interface OrderDAO {

    void addOrder(Order order, Connection connection);

    void addOrderProduct(Order order, Connection connection);

    Order getOrderById(int id, Connection connection);

    void changeOrderStatus(String status, Connection connection);
}
