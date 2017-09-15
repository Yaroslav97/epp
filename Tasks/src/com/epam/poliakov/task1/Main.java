package com.epam.poliakov.task1;

import com.epam.poliakov.task1.entity.Car;
import com.epam.poliakov.task1.entity.Vehicle;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<? super Vehicle> list = new ArrayList<>();

        list.add(new Car("Tesla", "Grey", 80_000, "USA", "5", "elect"));
        list.add(new Vehicle("Winner", "Blue", 1000, "USA"));

        System.out.println(list);

        System.out.println();
        System.out.println();
        System.out.println();

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
