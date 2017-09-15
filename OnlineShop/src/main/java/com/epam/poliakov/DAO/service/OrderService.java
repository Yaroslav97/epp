package com.epam.poliakov.DAO.service;

import com.epam.poliakov.DAO.entity.Order;
import com.epam.poliakov.DAO.order_dao.OrderDAO;
import com.epam.poliakov.DAO.order_dao.OrderDAOImpl;
import com.epam.poliakov.DAO.transactionManager.TransactionManager;

import javax.sql.DataSource;

public class OrderService {

    private OrderDAO orderDAO;
    private TransactionManager transactionManager;

    public OrderService(DataSource dataSource) {
        orderDAO = new OrderDAOImpl();
        transactionManager = new TransactionManager(dataSource);
    }

    public Boolean addOrder(Order order) {
        return transactionManager.doInTransaction(
                connection -> {
                    orderDAO.addOrder(order, connection);
                    orderDAO.addOrderProduct(order, connection);
                    return true;
                }
        );
    }
}
