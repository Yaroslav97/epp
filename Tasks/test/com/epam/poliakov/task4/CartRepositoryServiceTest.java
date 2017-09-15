package com.epam.poliakov.task4;

import com.epam.poliakov.task4.repository.cart.LastProductsInCart;
import com.epam.poliakov.task4.service.CartService;
import com.epam.poliakov.task4.service.StoreService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartRepositoryServiceTest {

    private LastProductsInCart lastProductsInCart;
    private CartService cart;
    private StoreService store;

    @Before
    public void init() {
        lastProductsInCart = new LastProductsInCart();
        cart = new CartService(lastProductsInCart);
        store = new StoreService();
    }

    @Test
    public void testShouldReturnTrueIfCartIsEmpty() {
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testShouldReturnFalseIfCartIsNotEmpty() {
        cart.addProductToCart(store.getProduct("coffee"), 2);
        assertFalse(cart.isEmpty());
    }

    @Test
    public void testShouldAddProductToCart() {
        int sizeCartMapBefore = cart.getCartMap().size();

        cart.addProductToCart(store.getProduct("coffee"), 2);

        assertEquals(sizeCartMapBefore + 1, cart.getCartMap().size());
    }

    @Test
    public void testShouldGetTotalPriceInCart() {
        int price = (int) store.getProduct("coffee").getProductPrice();

        cart.addProductToCart(store.getProduct("coffee"), 2);

        assertEquals(price * 2, (int) cart.getPriceOfProductsInCart());
    }

}