package com.epam.poliakov.task4.controller;

import com.epam.poliakov.task4.controller.CommandImpl.*;
import com.epam.poliakov.task4.repository.cart.LastProductsInCart;
import com.epam.poliakov.task4.service.CartService;
import com.epam.poliakov.task4.service.OrderService;
import com.epam.poliakov.task4.service.StoreService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.epam.poliakov.task4.controller.constant.CommandConst.*;

/**
 * Class init Command implementation to model map.
 */
public class CommandController {

    private Map<String, Command> commandMap = new HashMap<>();

    private LastProductsInCart lastProductsInCart = new LastProductsInCart();
    private CartService cartService = new CartService(lastProductsInCart);
    private OrderService orderService = new OrderService();
    private StoreService storeService = new StoreService();
    private Scanner scanner;

    public CommandController(Scanner scanner) {
        this.scanner = scanner;

        commandMap.put(ADD_TO_CART, new AddProductToCartCommand(cartService, storeService, scanner));
        commandMap.put(SHOW_CART, new ShowCartCommand(cartService));
        commandMap.put(SHOW_TOTAL_PRICE, new TotalPriceCommand(cartService));
        commandMap.put(BUY_PRODUCTS, new BuyProductsCommand(orderService, cartService, scanner));
        commandMap.put(GET_ORDER_BY_DATE, new OrderByDateCommand(orderService, scanner));
        commandMap.put(GET_ORDER_BY_NEAREST_DATE, new OrderByNearestDateCommand(orderService, scanner));
        commandMap.put(GET_LAST_PRODUCTS, new TopLastProductsCommand(lastProductsInCart));
        commandMap.put(PRODUCT_LIST, new ProductListCommand(storeService));
        commandMap.put(HELP, new HelpCommand());
        commandMap.put(EMPTY_COMMAND, new HelpCommand());
        commandMap.put(EXIT, new ExitCommand());
    }

    /**
     * Method fetch controller from commandMap by commandName.
     *
     * @param commandName
     */
    public void handleCommand(String commandName) {
        if (isExist(commandName)) {
            Command command = commandMap.get(commandName);
            command.execute();
        } else {
            Command command = commandMap.get(HELP);
            command.execute();
        }
    }

    private boolean isExist(String commandName) {
        if (commandMap.containsKey(commandName)) {
            return true;
        }
        return false;
    }
}
