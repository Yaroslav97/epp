package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.shop.util.DateUtil;
import com.epam.poliakov.task7_1.shop.service.OrderService;

import java.util.Map;
import java.util.Scanner;

public class OrderByNearestDateCommand implements Command {

    private OrderService orderService;
    private Scanner scanner;

    public OrderByNearestDateCommand(OrderService orderService, Scanner scanner) {
        this.orderService = orderService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter date dd.MM.yyyy $");
        String date = scanner.nextLine();

        System.out.println("OrderRepository by nearest date:  " + date);

        if ((orderService.getOrderByNearestDate(DateUtil.convertStringToDate(date)) != null)) {
            for (Map.Entry entry : orderService.getOrderByNearestDate(DateUtil.convertStringToDate(date)).entrySet()) {
                System.out.println(entry.getKey() + " countOfProducts = " + entry.getValue() + "}");
            }
        } else {
            System.err.println("date not found");
        }
    }
}
