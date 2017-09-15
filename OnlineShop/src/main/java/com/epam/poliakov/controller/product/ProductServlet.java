package com.epam.poliakov.controller.product;

import com.epam.poliakov.DAO.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.poliakov.controller.product.ProductCons.*;
import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_PRODUCT_IMAGE_PATH;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    private static final int INITIAL_PAGE_ITEM_SIZE = 12;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextImagePath = getServletContext().getInitParameter(CONTEXT_PRODUCT_IMAGE_PATH);

        req.setAttribute(PRODUCTS, productService.getLimitedProducts(INITIAL_PAGE_ITEM_SIZE, 0));

        req.setAttribute(START_PAGE, 0);
        req.setAttribute(SIZE_ITEMS_PAGE, INITIAL_PAGE_ITEM_SIZE);

        int countPage = productService.getProductCount() % INITIAL_PAGE_ITEM_SIZE == 0 ?
                productService.getProductCount() / INITIAL_PAGE_ITEM_SIZE :
                productService.getProductCount() / INITIAL_PAGE_ITEM_SIZE;

        req.setAttribute(PAGE_COUNT, countPage);

        req.getSession().setAttribute(PATH, contextImagePath);

        req.getRequestDispatcher(PRODUCTS_JSP).forward(req, resp);
    }
}
