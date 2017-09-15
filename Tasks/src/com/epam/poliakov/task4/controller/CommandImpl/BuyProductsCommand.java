package com.epam.poliakov.task4.controller.CommandImpl;

import com.epam.poliakov.task4.controller.constant.TitleConst;
import com.epam.poliakov.task4.controller.Command;
import com.epam.poliakov.task4.entity.DateUtil;
import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.entity.Product;
import com.epam.poliakov.task4.service.CartService;
import com.epam.poliakov.task4.service.OrderService;

import java.util.Map;
import java.util.Scanner;

public class BuyProductsCommand implements Command {

    private OrderService orderService;
    private CartService cartService;
    private Scanner scanner;

    public BuyProductsCommand(OrderService orderService, CartService cartService, Scanner scanner) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if (!cartService.isEmpty()) {

            System.out.println("Enter date of order (dd.MM.yyyy)");
            String date = scanner.nextLine();

            orderService.buyProducts(DateUtil.convertStringToDate(date), new Order(cartService.getCartMap()));

            double totalCost = 0;

            System.out.println(TitleConst.ORDER_LIST);
            for (Map.Entry<Product, Integer> m : cartService.getCartMap().entrySet()) {
                System.out.println(m.getKey() + " countOfProducts = " + m.getValue() + "}");
                totalCost += m.getKey().getProductPrice() * m.getValue();
            }
            System.out.println(TitleConst.TOTAL_PRICE + totalCost);

            cartService.getCartMap().clear();
        } else {
            System.err.println("cart is empty\nadd some product to cart before buy product");
        }
    }
}
