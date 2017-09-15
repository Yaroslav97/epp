package com.epam.poliakov.DAO.cart_dao;

import com.epam.poliakov.DAO.entity.Product;

import java.util.Map;

public interface Cart {

    void add(Product product);

    Product getProductItem(String productName);

    Integer getCartPrice();

    void remove(Product product);

    Map<Product, Integer> getMap();

    void clear();
}
