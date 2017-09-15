package com.epam.poliakov.task4.repository.cart;

import com.epam.poliakov.task4.entity.Product;

import java.util.Map;

/**
 * Interface consist basic methods for CartRepository map.
 */
public interface CartRepository {

    void addToCart(Product product, int countOfProduct);

    Map<Product, Integer> getCartMap();

    void clearCart();
}
