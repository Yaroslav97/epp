package com.epam.poliakov.controller.order;

import com.epam.poliakov.DAO.cart_dao.Cart;
import com.epam.poliakov.DAO.entity.Order;
import com.epam.poliakov.DAO.entity.OrderProduct;
import com.epam.poliakov.DAO.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static com.epam.poliakov.controller.JSPCons.INDEX_JSP;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = (OrderService) getServletContext().getAttribute("orderService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final int orderID = new Random().nextInt(1000000) + 100000;
        String payType = req.getParameter("pay_type");
        String delivery = req.getParameter("delivery");
        String login = (String) req.getSession().getAttribute("login");
        Map map = (Map) req.getSession().getAttribute("cartItems");

        Order order = new Order(
                orderID,
                OrderStatus.ACTIVE.getStatus(),
                payType + ", " + delivery,
                new Date(),
                login,
                new OrderProduct(map)
        );

        orderService.addOrder(order);

        Cart cart = (Cart) req.getSession().getAttribute("initCart");
        cart.clear();

        req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
    }
}
