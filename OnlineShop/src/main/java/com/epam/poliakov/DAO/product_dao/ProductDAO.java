package com.epam.poliakov.DAO.product_dao;

import com.epam.poliakov.DAO.entity.Product;
import com.epam.poliakov.util.query_builder.Query;

import java.sql.Connection;
import java.util.List;

public interface ProductDAO {

    List<Product> getAllProducts(Connection connection);

    List<Product> getLimitProducts(Connection connection, int limit, int position);

    Product getProductByID(int id, Connection connection);

    Product getProductByName(String productName, Connection connection);

    String getSubjectById(int id, Connection connection);

    String getOriginById(int id, Connection connection);

    List<Product> getProductByFilters(String query, Connection connection);

    List<Product> getProductByFilters(String sqlQuery, Query query, Connection connection);

    Integer getProductCount(Connection connection);
}
