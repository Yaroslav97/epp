package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.shop.util.DateUtil;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task7_1.shop.service.OrderService;

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
            for (Map.Entry<Vehicle, Integer> entry : orderService.getOrdersByDate(DateUtil.convertStringToDate(date)).getOrder().entrySet()) {
                System.out.println(entry.getKey() + " countOfProducts = " + entry.getValue() + "}");
            }
        } else {
            System.err.println("date not found");
        }
    }
}
