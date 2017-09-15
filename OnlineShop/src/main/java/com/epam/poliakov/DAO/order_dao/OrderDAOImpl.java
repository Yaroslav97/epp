package com.epam.poliakov.DAO.order_dao;

import com.epam.poliakov.DAO.entity.Order;
import com.epam.poliakov.DAO.entity.Product;
import com.epam.poliakov.util.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {

    private static final String INSERT_INTO_ORDERS = "INSERT INTO orders (id, status, orders.describe, date, login) VALUES(?,?,?,?,?)";
    private static final String INSERT_INTO_ORDER_PRODUCTS = "INSERT INTO order_products (id_order, id_product, count) VALUES(?,?,?)";

    @Override
    public void addOrder(Order order, Connection connection) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ORDERS)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setString(3, order.getDescribe());
            preparedStatement.setObject(4, order.getDate());
            preparedStatement.setString(5, order.getLogin());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Cannot create order");
        }
    }

    @Override
    public void addOrderProduct(Order order, Connection connection) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ORDER_PRODUCTS)) {
            connection.setAutoCommit(false);
            for (Map.Entry<Product, Integer> entry : order.getOrderProduct().getProductMap().entrySet()) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, entry.getKey().getId());
            preparedStatement.setInt(3, entry.getValue());

            preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            throw new DAOException("Cannot create order");
        }
    }

    @Override
    public Order getOrderById(int id, Connection connection) {
        return null;
    }

    @Override
    public void changeOrderStatus(String status, Connection connection) {

    }
}
