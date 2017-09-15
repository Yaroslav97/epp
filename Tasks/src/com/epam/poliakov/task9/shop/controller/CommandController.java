package com.epam.poliakov.task9.shop.controller;

import com.epam.poliakov.task9.web.factory.launch.HTTPLauncher;
import com.epam.poliakov.task9.web.factory.launch.TCPLauncher;
import com.epam.poliakov.task9.web.abstractFactory.ServerAbstractFactory;
import com.epam.poliakov.task9.web.abstractFactory.ServerFactory;
import com.epam.poliakov.task9.web.command.WebCommandManager;
import com.epam.poliakov.task9.web.command.WebCommand;
import com.epam.poliakov.task9.shop.controller.CommandImpl.*;
import com.epam.poliakov.task9.shop.controller.generator.inputer.InputerContainer;
import com.epam.poliakov.task9.shop.reflection.reflectionGenerator.ReflectionInputerContainer;
import com.epam.poliakov.task9.shop.repository.cart.LastProductsInCart;
import com.epam.poliakov.task9.shop.service.CartService;
import com.epam.poliakov.task9.shop.service.OrderService;
import com.epam.poliakov.task9.shop.service.StoreService;
import com.epam.poliakov.task9.shop.util.LocaleUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.epam.poliakov.task9.shop.controller.constant.CommandConst.*;

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

        WebCommand webCommand = new WebCommandManager(storeService);

        ServerAbstractFactory factory = new ServerFactory(webCommand);

        TCPLauncher tcpLauncher = new TCPLauncher(factory);
        tcpLauncher.start();

        HTTPLauncher httpLauncher = new HTTPLauncher(factory);
        httpLauncher.start();

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
        commandMap.put(GET_COUNT, new GetCountCommand(storeService));
        commandMap.put(GET_ITEM, new GetItemCommand(storeService, scanner));
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
