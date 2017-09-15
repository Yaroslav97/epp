package com.epam.poliakov.task9.shop.service;

import com.epam.poliakov.task9.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task9.shop.repository.cart.CartRepository;
import com.epam.poliakov.task9.shop.repository.cart.CartRepositoryImpl;
import com.epam.poliakov.task9.shop.repository.cart.LastProductsInCart;

import java.util.Map;

/**
 * Class contain methods to display some info in CartRepository.
 */
public class CartService {

    private LastProductsInCart lastProductsInCart;
    private CartRepository cartRepository = new CartRepositoryImpl();

    public CartService(LastProductsInCart lastProductsInCart) {
        this.lastProductsInCart = lastProductsInCart;
    }

    /**
     * Method add GetProduct to cartRepository and then add productEntity to lastProductsInCart.
     *
     * @param product
     * @param countOfProduct
     */
    public void addProductToCart(Vehicle product, int countOfProduct) {
        cartRepository.addToCart(product, countOfProduct);

        for (Vehicle p : cartRepository.getCartMap().keySet()) {
            lastProductsInCart.addToLastProduct(p);
        }
    }

    public Map<Vehicle, Integer> getCartMap() {
        return cartRepository.getCartMap();
    }

    /**
     * Method check state of cartRepository.
     *
     * @return true if cartRepository is empty.
     */
    public boolean isEmpty() {
        if (cartRepository.getCartMap().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Method define total cost in CartRepository.
     *
     * @return double value (total cost).
     */
    public double getPriceOfProductsInCart() {

        double totalPrice = 0;
        for (Map.Entry<Vehicle, Integer> entry : cartRepository.getCartMap().entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}
