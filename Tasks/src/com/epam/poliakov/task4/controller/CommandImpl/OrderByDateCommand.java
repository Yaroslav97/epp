package com.epam.poliakov.task4.controller.CommandImpl;

import com.epam.poliakov.task4.controller.Command;
import com.epam.poliakov.task4.entity.DateUtil;
import com.epam.poliakov.task4.entity.Order;
import com.epam.poliakov.task4.entity.Product;
import com.epam.poliakov.task4.service.OrderService;

import java.util.Map;
import java.util.Scanner;

public class OrderByDateCommand implements Command {

    private OrderService orderService;
    private Scanner scanner;

    public OrderByDateCommand(OrderService orderService, Scanner scanner) {
        this.orderService = orderService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter date DD.MM.YY $");
        String date = scanner.nextLine();

        System.out.println("OrderRepository: " + date);

        if (orderService.getOrdersByDate(DateUtil.convertStringToDate(date)) != null) {
            for (Map.Entry<Product, Integer> entry : orderService.getOrdersByDate(DateUtil.convertStringToDate(date)).getOrder().entrySet()) {
                System.out.println(entry.getKey() + " countOfProducts = " + entry.getValue() + "}");
            }
        } else {
            System.err.println("date not found");
        }
    }
}
