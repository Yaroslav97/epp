package com.epam.poliakov.task6.shop.repository.cart;

import com.epam.poliakov.task6.shop.entity.product.Vehicle;

import java.util.Map;

/**
 * Interface consist basic methods for CartRepository map.
 */
public interface CartRepository {

    void addToCart(Vehicle product, int countOfProduct);

   Map<Vehicle, Integer> getCartMap();

    void clearCart();
}
