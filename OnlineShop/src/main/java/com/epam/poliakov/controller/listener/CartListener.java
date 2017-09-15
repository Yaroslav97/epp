package com.epam.poliakov.controller.listener;

import com.epam.poliakov.DAO.cart_dao.Cart;
import com.epam.poliakov.DAO.cart_dao.CartImpl;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("/cartListener")
public class CartListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Cart cart = new CartImpl();
        se.getSession().setAttribute("initCart", cart);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
