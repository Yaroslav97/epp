package com.epam.poliakov.task4.controller;

import java.util.Scanner;

public class ConsoleManager {

    /**
     * Method create console interface.
     */
    public void command() {

        Scanner scanner = new Scanner(System.in);

        CommandController commandController = new CommandController(scanner);

        System.out.println("CONSOLE SHOP");

        while (true) {
            System.out.println("$ ");
            String command = scanner.nextLine().trim();
            commandController.handleCommand(command);
            System.out.println();
        }
    }
}
