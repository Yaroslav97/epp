package com.epam.poliakov.task4.service;

import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.entity.Product;
import com.epam.poliakov.task4.repository.cart.CartRepository;
import com.epam.poliakov.task4.repository.cart.CartRepositoryImpl;
import com.epam.poliakov.task4.repository.cart.LastProductsInCart;

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
     * Method add Product to cartRepository and then add product to lastProductsInCart.
     *
     * @param product
     * @param countOfProduct
     */
    public void addProductToCart(Product product, int countOfProduct) {
        cartRepository.addToCart(product, countOfProduct);

        for (Product p : cartRepository.getCartMap().keySet()) {
            lastProductsInCart.addToLastProduct(p);
        }
    }

    public Map<Product, Integer> getCartMap() {
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
        for (Map.Entry<Product, Integer> entry : cartRepository.getCartMap().entrySet()) {
            totalPrice += entry.getKey().getProductPrice() * entry.getValue();
        }
        return totalPrice;
    }
}
