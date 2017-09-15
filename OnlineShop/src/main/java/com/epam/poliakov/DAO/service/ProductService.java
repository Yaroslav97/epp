package com.epam.poliakov.DAO.service;

import com.epam.poliakov.DAO.entity.Product;
import com.epam.poliakov.DAO.product_dao.ProductDAO;
import com.epam.poliakov.DAO.product_dao.ProductDAOImpl;
import com.epam.poliakov.DAO.transactionManager.TransactionManager;
import com.epam.poliakov.util.query_builder.Query;

import javax.sql.DataSource;
import java.util.List;

public class ProductService {

    private TransactionManager transactionManager;

    private ProductDAO productDAO;

    public ProductService(DataSource dataSource) {
        productDAO = new ProductDAOImpl();
        transactionManager = new TransactionManager(dataSource);
    }

    public List<Product> getAllProducts() {
        return transactionManager.doInTransaction(
                connection -> productDAO.getAllProducts(connection)
        );
    }

    public List<Product> getLimitedProducts(int limit, int position) {
        return transactionManager.doInTransaction(
                connection -> productDAO.getLimitProducts(connection, limit, position)
        );
    }

    public List<Product> getProductsByQuery(String query) {
        return transactionManager.doInTransaction(
                connection -> productDAO.getProductByFilters(query, connection)
        );
    }

    public List<Product> getProductsByQuery(String sqlQuery, Query query) {
        return transactionManager.doInTransaction(
                connection -> productDAO.getProductByFilters(sqlQuery, query, connection)
        );
    }

    public Integer getProductCount() {
        return transactionManager.doInTransaction(
                connection -> productDAO.getProductCount(connection)
        );
    }

    public Product getProductByName(String productName) {
        return transactionManager.doInTransaction(
                connection -> productDAO.getProductByName(productName, connection)
        );
    }
}
