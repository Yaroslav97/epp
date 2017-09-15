package com.epam.poliakov.task7_1.shop.controller;

import com.epam.poliakov.task7_1.reflection.reflectionGenerator.ReflectionInputerContainer;
import com.epam.poliakov.task7_1.shop.util.LocaleUtil;
import com.epam.poliakov.task7_1.shop.controller.CommandImpl.*;
import com.epam.poliakov.task7_1.shop.controller.generator.inputer.InputerContainer;
import com.epam.poliakov.task7_1.shop.repository.cart.LastProductsInCart;
import com.epam.poliakov.task7_1.shop.service.CartService;
import com.epam.poliakov.task7_1.shop.service.OrderService;
import com.epam.poliakov.task7_1.shop.service.StoreService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.epam.poliakov.task7_1.shop.controller.constant.CommandConst.*;

/**
 * Class init ReflectionGeneratorContainer implementation to model map.
 */
public class CommandController {

    private Map<String, Command> commandMap = new HashMap<>();

    public CommandController(Scanner scanner) {

        StoreService storeService = new StoreService();
        LastProductsInCart lastProductsInCart = new LastProductsInCart();
        CartService cartService = new CartService(lastProductsInCart);
        OrderService orderService = new OrderService();
        InputerContainer inputerContainer = new InputerContainer();
        ReflectionInputerContainer reflectionInputerContainer = new ReflectionInputerContainer();

        storeService.initDeserialization();

        setLocal(scanner);

        inputerContainer.setTemplate();
        reflectionInputerContainer.setTemplate(inputerContainer.getInputType());

        commandMap.put(ADD_TO_CART, new AddProductToCartCommand(cartService, storeService, scanner));
        commandMap.put(SHOW_CART, new ShowCartCommand(cartService));
        commandMap.put(SHOW_TOTAL_PRICE, new TotalPriceCommand(cartService));
        commandMap.put(BUY_PRODUCTS, new BuyProductsCommand(orderService, cartService, scanner));
        commandMap.put(GET_ORDER_BY_DATE, new OrderByDateCommand(orderService, scanner));
        commandMap.put(GET_ORDER_BY_NEAREST_DATE, new OrderByNearestDateCommand(orderService, scanner));
        commandMap.put(GET_LAST_PRODUCTS, new TopLastProductsCommand(lastProductsInCart));
        commandMap.put(PRODUCT_LIST, new ProductListCommand(storeService));
        commandMap.put(ADD_TO_STORE, new AddProductToStoreCommand(inputerContainer, storeService));
        commandMap.put(ADD_TO_STORE_REFLECTION, new AddProductToStoreReflectionCommand(reflectionInputerContainer, storeService));
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
        if (commandMap.containsKey(commandName)) {
            Command command = commandMap.get(commandName);
            command.execute();
        } else {
            Command command = commandMap.get(HELP);
            command.execute();
        }
    }

    public static void setLocal(Scanner scanner) {
        System.out.println("en - 0\nru - 1");
        String language = scanner.nextLine();

        LocaleUtil.setLocal(language);
    }
}
