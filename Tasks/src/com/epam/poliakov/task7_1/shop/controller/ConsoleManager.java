package com.epam.poliakov.task7_1.shop.controller;

import com.epam.poliakov.task7_1.shop.util.LocaleUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManager {

    /**
     * Method create console interface.
     */
    public void command() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("CONSOLE SHOP");

        CommandController commandController = new CommandController(scanner);

        while (true) {
            System.out.println("$ ");
            String command = scanner.nextLine().trim();
            commandController.handleCommand(command);
            System.out.println();
        }
    }
}
