package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;

import static com.epam.poliakov.task9.shop.controller.constant.CommandConst.*;


public class HelpCommand implements Command {

    private void help() {
        System.out.println("-- " + PRODUCT_LIST);
        System.out.println("-- " + ADD_TO_CART);
        System.out.println("-- " + SHOW_CART);
        System.out.println("-- " + SHOW_TOTAL_PRICE);
        System.out.println("-- " + BUY_PRODUCTS);
        System.out.println("-- " + GET_ORDER_BY_DATE);
        System.out.println("-- " + GET_ORDER_BY_NEAREST_DATE);
        System.out.println("-- " + GET_LAST_PRODUCTS);
        System.out.println("-- " + ADD_TO_STORE);
        System.out.println("-- " + ADD_TO_STORE_REFLECTION);
        System.out.println("-- " + GET_COUNT);
        System.out.println("-- " + GET_ITEM);
        System.out.println("-- " + HELP);
        System.out.println("-- " + EXIT);
    }

    @Override
    public void execute() {
        help();
    }
}
