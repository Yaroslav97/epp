package com.epam.poliakov.controller.cart;

import com.epam.poliakov.DAO.cart_dao.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeItem")
public class RemoveCartItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("initCart");
        cart.remove(cart.getProductItem(req.getParameter("productName")));

        req.getSession().setAttribute("totalPrice", cart.getCartPrice());
        req.getSession().setAttribute("cartItems", cart.getMap());
        resp.sendRedirect("cart.jsp");
    }
}
