package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.shop.controller.constant.TitleConst;
import com.epam.poliakov.task7_1.shop.util.DateUtil;
import com.epam.poliakov.task7_1.shop.entity.Order;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task7_1.shop.service.CartService;
import com.epam.poliakov.task7_1.shop.service.OrderService;

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
            for (Map.Entry<Vehicle, Integer> m : cartService.getCartMap().entrySet()) {
                System.out.println(m.getKey() + " countOfProducts = " + m.getValue() + "}");
                totalCost += m.getKey().getPrice() * m.getValue();
            }
            System.out.println(TitleConst.TOTAL_PRICE + totalCost);

            cartService.getCartMap().clear();
        } else {
            System.err.println("cart is empty\nadd some productEntity to cart before buy productEntity");
        }
    }
}
