package com.epam.poliakov.task6.shop.controller;

import com.epam.poliakov.task6.shop.controller.CommandImpl.*;
import com.epam.poliakov.task6.shop.controller.generator.GeneratorContainer;
import com.epam.poliakov.task6.shop.repository.cart.LastProductsInCart;
import com.epam.poliakov.task6.shop.service.CartService;
import com.epam.poliakov.task6.shop.service.OrderService;
import com.epam.poliakov.task6.shop.service.StoreService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.epam.poliakov.task6.shop.controller.constant.CommandConst.*;

/**
 * Class init ReflectionGeneratorContainer implementation to model map.
 */
public class CommandController {

    private Map<String, Command> commandMap = new HashMap<>();

    private Scanner scanner;

    public CommandController(Scanner scanner, String inputType) {

        StoreService storeService = new StoreService();
        LastProductsInCart lastProductsInCart = new LastProductsInCart();
        CartService cartService = new CartService(lastProductsInCart);
        OrderService orderService = new OrderService();
        GeneratorContainer generatorContainer = new GeneratorContainer(inputType);

        storeService.initDeserialization();

        this.scanner = scanner;

        commandMap.put(ADD_TO_CART, new AddProductToCartCommand(cartService, storeService, scanner));
        commandMap.put(SHOW_CART, new ShowCartCommand(cartService));
        commandMap.put(SHOW_TOTAL_PRICE, new TotalPriceCommand(cartService));
        commandMap.put(BUY_PRODUCTS, new BuyProductsCommand(orderService, cartService, scanner));
        commandMap.put(GET_ORDER_BY_DATE, new OrderByDateCommand(orderService, scanner));
        commandMap.put(GET_ORDER_BY_NEAREST_DATE, new OrderByNearestDateCommand(orderService, scanner));
        commandMap.put(GET_LAST_PRODUCTS, new TopLastProductsCommand(lastProductsInCart));
        commandMap.put(PRODUCT_LIST, new ProductListCommand(storeService));
        commandMap.put(ADD_TO_STORE, new AddProductToStoreCommand(generatorContainer, storeService , scanner));
        commandMap.put(HELP, new HelpCommand());
        commandMap.put(EMPTY_COMMAND, new HelpCommand());
        commandMap.put(EXIT, new ExitCommand(storeService));
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
