package com.epam.poliakov.task4;

import com.epam.poliakov.task4.repository.cart.LastProductsInCart;
import com.epam.poliakov.task4.service.CartService;
import com.epam.poliakov.task4.service.OrderService;
import com.epam.poliakov.task4.service.StoreService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreServiceTest {

    private LastProductsInCart lastProductsInCart;
    private CartService cart;
    private OrderService order;
    private StoreService store;

    @Before
    public void init() {
        lastProductsInCart = new LastProductsInCart();
        cart = new CartService(lastProductsInCart);
        order = new OrderService();
        store = new StoreService();
    }

    @Test
    public void testShouldReturnTrueIfProductExistInStore() {
        assertTrue(store.isExist("coffee"));
    }

    @Test
    public void testShouldReturnProductByNameInStore() {
        String product = "coffee" ;
        assertEquals(product, store.getProduct("coffee").getProductName());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldNotReturnProductByNameInStore() {
       store.getProduct("ughu").getProductName();
    }
}