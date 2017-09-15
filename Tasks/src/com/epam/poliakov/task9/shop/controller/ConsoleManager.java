package com.epam.poliakov.task9.shop.controller;

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
