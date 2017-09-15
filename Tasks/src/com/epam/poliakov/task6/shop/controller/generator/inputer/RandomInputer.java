package com.epam.poliakov.task6.shop.controller.generator.inputer;

import java.util.Random;
import java.util.Scanner;

public class RandomInputer implements Inputer {


    public RandomInputer() {
    }

    @Override
    public String setString(String title) {
        System.out.println(title);
        String string = "product" + new Random().nextInt(9000) + 1000;
        System.out.println(string);
        return string;
    }

    @Override
    public int setInt(String title) {
        System.out.println(title);
        int i = new Random().nextInt(1000) + 100;
        System.out.println(i);
        return i;
    }
}
