package com.epam.poliakov.task6.shop.controller.generator.inputer;

import java.util.Scanner;

public class ManualInputer implements Inputer {

    private Scanner scanner;

    public ManualInputer() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String setString(String title) {
        System.out.println(title);
        return scanner.nextLine();
    }

    @Override
    public int setInt(String title) {
        System.out.println(title);
        return Integer.parseInt(scanner.nextLine());
    }
}
