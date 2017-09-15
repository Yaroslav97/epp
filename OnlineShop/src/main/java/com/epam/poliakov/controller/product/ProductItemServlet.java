package com.epam.poliakov.controller.product;

import com.epam.poliakov.DAO.entity.Product;
import com.epam.poliakov.DAO.service.ProductService;
import com.epam.poliakov.util.query_builder.QueryDTO;
import com.epam.poliakov.util.query_builder.builder.QueryBuilder;
import com.epam.poliakov.util.query_builder.builder.QueryBuilderImpl;

import static com.epam.poliakov.controller.product.ProductCons.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productItem")
public class ProductItemServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QueryDTO dto = new QueryDTO(req);

        QueryBuilder builder = new QueryBuilderImpl();
        builder.setOrigin(dto.getOrigin())
                .setSubject(dto.getSubject())
                .setPrice(dto.getPriceFrom(), dto.getPriceTo())
                .setSearch(dto.getSearch())
                .setSortBy(dto.getSortBy())
                .setLimitProducts(dto.getItemSize(), (dto.getNextPage()) * dto.getItemSize());

        List<Product> productList = productService.getProductsByQuery(builder.getGenerateQuery(), builder.getQueryObject());

        int countPage = productService.getProductCount() % dto.getItemSize() == 0 ?
                productService.getProductCount() / dto.getItemSize() :
                productService.getProductCount() / dto.getItemSize();

        if (productList.isEmpty()) {
            req.setAttribute(EMPTY_CONTAINER, "Container is empty");
        }

        req.setAttribute(PRODUCTS, productList);
        req.setAttribute(FILTER_PARAMETER, dto);
        req.setAttribute(START_PAGE, dto.getNextPage());
        req.setAttribute(SIZE_ITEMS_PAGE, dto.getItemSize());
        req.setAttribute(PAGE_COUNT, countPage);

        req.getRequestDispatcher(PRODUCTS_JSP).forward(req, resp);
    }
}
