package com.epam.poliakov.task9.shop.controller.generator.inputer;

import java.util.Random;

public class RandomInputer implements Inputer {


    public RandomInputer() {
    }

    @Override
    public String generateString(String title) {
        System.out.println(title + ": ");
        int code = new Random().nextInt(9000) + 1000;
        String string = "product" + code;
        System.out.println(string);
        return string;
    }

    @Override
    public int generateInt(String title) {
        System.out.println(title  + ": ");
        int i = new Random().nextInt(1000) + 100;
        System.out.println(i);
        return i;
    }
}
