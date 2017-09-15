package com.epam.poliakov.task6.shop.controller;

import com.epam.poliakov.task6.shop.controller.generator.InputTypeCons;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManager {

    /**
     * Method create console interface.
     */
    public void command() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("CONSOLE SHOP");

        String input = setTemplate(scanner);

        CommandController commandController = new CommandController(scanner, input);

        while (true) {
            System.out.println("$ ");
            String command = scanner.nextLine().trim();
            commandController.handleCommand(command);
            System.out.println();
        }
    }

    public String setTemplate(Scanner scanner) {
        System.out.println("choice input type\n" +
                "0 - manual\n" +
                "1 - random");
        String type = scanner.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("0", InputTypeCons.MANUAL);
        map.put("1", InputTypeCons.RANDOM);

        return map.get(type);
    }
}
