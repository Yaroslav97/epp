package com.epam.poliakov.controller.listener;

import com.epam.poliakov.DAO.pool.PoolConnection;
import com.epam.poliakov.DAO.service.OrderService;
import com.epam.poliakov.DAO.service.ProductService;
import com.epam.poliakov.DAO.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("/contextListener")
public class ContextListner implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ComboPooledDataSource comboPooledDataSource = PoolConnection.getPool();

        UserService userService = new UserService(comboPooledDataSource);
        OrderService orderService = new OrderService(comboPooledDataSource);
        ProductService productService = new ProductService(comboPooledDataSource);

        event.getServletContext().setAttribute("userService", userService);
        event.getServletContext().setAttribute("orderService", orderService);
        event.getServletContext().setAttribute("productService", productService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
