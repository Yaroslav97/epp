package com.epam.poliakov.DAO.product_dao;

import com.epam.poliakov.DAO.entity.Product;
import com.epam.poliakov.util.query_builder.Query;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final String PRODUCTS_ID = "products.id";
    private static final String PRODUCTS_NAME = "name";
    private static final String SUBJECTS_SUBJECT = "subjects.subject";
    private static final String PRODUCTS_PRICE = "price";
    private static final String ORIGINS_ORIGIN = "origins.origin";
    private static final String PRODUCTS_IMAGE = "image";
    private static final String SUBJECT = "subject";
    private static final String ORIGIN = "origin";

    private String SELECT_ALL_PRODUCTS = "SELECT * FROM products JOIN subjects ON products.subject = subjects.id JOIN origins ON products.origin = origins.id";
    private String SELECT_LIMIT_PRODUCTS = "SELECT * FROM products JOIN subjects ON products.subject = subjects.id JOIN origins ON products.origin = origins.id ORDER BY name LIMIT ? OFFSET ?";
    private String SELECT_PRODUCTS_BY_ID = "SELECT * FROM products JOIN subjects ON products.subject = subjects.id JOIN origins ON products.origin = origins.id WHERE products.id=?";
    private String SELECT_PRODUCTS_BY_NAME = "SELECT * FROM products JOIN subjects ON products.subject = subjects.id JOIN origins ON products.origin = origins.id WHERE products.name=?";
    private String SELECT_SUBJECT_BY_ID = "SELECT * FROM subjects WHERE id=?";
    private String SELECT_ORIGIN_BY_ID = "SELECT * FROM origins WHERE id=?";
    private String SELECT_PRODUCT_COUNT = "SELECT COUNT(name) AS 'count' FROM products";

    @Override
    public List<Product> getAllProducts(Connection connection) {
        List<Product> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                list.add(new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getLimitProducts(Connection connection, int limit, int position) {
        List<Product> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIMIT_PRODUCTS)) {

            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, position);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getProductByID(int id, Connection connection) {
        Product product = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product getProductByName(String productName, Connection connection) {
        Product product = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_NAME)) {

            preparedStatement.setString(1, productName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public String getSubjectById(int id, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUBJECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(SUBJECT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getOriginById(int id, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORIGIN_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(ORIGIN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProductByFilters(String query, Connection connection) {
        List<Product> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                list.add(new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductByFilters(String sqlQuery, Query query, Connection connection) {
        List<Product> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            int parameterIndex = 1;
            String[] methodNames = {"getOrigin", "getSubject", "getPriceFrom", "getPriceTo", "getSearch", "getLimit", "getPosition"};

            for (String string : methodNames) {
                if (query.getClass().getDeclaredMethod(string).invoke(query) != null) {
                    preparedStatement.setObject(parameterIndex++, query.getClass().getDeclaredMethod(string).invoke(query));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Product(
                        resultSet.getInt(PRODUCTS_ID),
                        resultSet.getString(PRODUCTS_NAME),
                        resultSet.getString(SUBJECTS_SUBJECT),
                        resultSet.getDouble(PRODUCTS_PRICE),
                        resultSet.getString(ORIGINS_ORIGIN),
                        resultSet.getString(PRODUCTS_IMAGE)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer getProductCount(Connection connection) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_COUNT);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
