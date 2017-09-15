package com.epam.poliakov.task4;

import com.epam.poliakov.task4.entity.DateUtil;
import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.repository.cart.LastProductsInCart;
import com.epam.poliakov.task4.service.CartService;
import com.epam.poliakov.task4.service.OrderService;
import com.epam.poliakov.task4.service.StoreService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderRepositoryServiceTest {

    private LastProductsInCart lastProductsInCart;
    private CartService cart;
    private StoreService store;
    private OrderService order;

    @Before
    public void init() {
        lastProductsInCart = new LastProductsInCart();
        cart = new CartService(lastProductsInCart);
        store = new StoreService();
        order = new OrderService();
    }

    @Test
    public void testShouldReturnGetOrderByNearestDate() {
        cart.addProductToCart(store.getProduct("coffee"), 3);
        cart.addProductToCart(store.getProduct("tea"), 1);
        cart.addProductToCart(store.getProduct("cookie"), 6);
        cart.addProductToCart(store.getProduct("candy"), 2);

        order.buyProducts(DateUtil.convertStringToDate("29.03.17"), new Order(cart.getCartMap()));

        assertEquals(4, order.getOrderByNearestDate(DateUtil.convertStringToDate("29.03.17")).size());
    }
}