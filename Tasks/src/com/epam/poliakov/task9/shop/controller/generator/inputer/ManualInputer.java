package com.epam.poliakov.task9.shop.controller.generator.inputer;

import java.util.Scanner;

public class ManualInputer implements Inputer {

    private Scanner scanner;

    public ManualInputer() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String generateString(String title) {
        System.out.println(title + ": ");
        return scanner.nextLine();
    }

    @Override
    public int generateInt(String title) {
        System.out.println(title + ": ");
        return Integer.parseInt(scanner.nextLine());
    }
}
