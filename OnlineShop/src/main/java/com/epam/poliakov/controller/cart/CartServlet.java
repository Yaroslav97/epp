package com.epam.poliakov.controller.cart;

import com.epam.poliakov.DAO.cart_dao.Cart;
import com.epam.poliakov.DAO.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCart")
public class CartServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("initCart");
        cart.add(productService.getProductByName(req.getParameter("name")));

        req.getSession().setAttribute("totalPrice", cart.getCartPrice());
        req.getSession().setAttribute("cartItems", cart.getMap());
    }
}
