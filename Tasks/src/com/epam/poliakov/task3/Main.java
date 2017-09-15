package com.epam.poliakov.task3;

import com.epam.poliakov.task3.entity.Articul;
import com.epam.poliakov.task3.entity.Articul2;
import com.epam.poliakov.task3.entity.Car;
import com.epam.poliakov.task3.entity.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        System.out.println("----------------------------------------------------------------");
        System.out.println("HASH_MAP");
        System.out.println("----------------------------------------------------------------");

        Map<Articul, Vehicle> map = new HashMap<>();

        map.put(new Articul("aaaa"), new Car("Tesla 1", "Red", 80_000, "USA", "auto", "electrical"));
        map.put(new Articul("asdfg"), new Car("TeslaS 2", "Blue", 85_000, "USA", "auto", "electrical"));
        map.put(new Articul("zxxcvb"), new Car("BMW 3", "Blue", 85_000, "GE", "auto", "gas"));
        map.put(new Articul("sds"), new Car("BMW 4", "Blue", 85_000, "GE", "auto", "gas"));
        map.put(new Articul("zxxcvb"), new Car("BMW A 5", "Blue", 85_000, "GE", "auto", "gas"));

        for (Map.Entry<Articul, Vehicle> o : map.entrySet()) {
            System.out.println(o);
        }

        System.out.println(System.lineSeparator());

        Map<Articul2, Vehicle> map1 = new HashMap<>();

        map1.put(new Articul2("ff"), new Car("Tesla 1", "Red", 80_000, "USA", "auto", "electrical"));
        map1.put(new Articul2("asdfgdftjdfyj"), new Car("TeslaS 2", "Blue", 85_000, "USA", "auto", "electrical"));
        map1.put(new Articul2("zxxddfthjufjcvb"), new Car("BMW 3", "Blue", 85_000, "GE", "auto", "gas"));
        map1.put(new Articul2("sfdtdfthdrfhjjdftjds"), new Car("BMW 4", "Blue", 85_000, "GE", "auto", "gas"));
        map1.put(new Articul2("tdfjdftjdft"), new Car("BMW A 5", "Blue", 85_000, "GE", "auto", "gas"));

        for (Map.Entry<Articul2, Vehicle> o : map1.entrySet()) {
            System.out.println(o);
        }

        System.out.println(System.lineSeparator());


        System.out.println("----------------------------------------------------------------");
        System.out.println("LINKED_HASH_MAP");
        System.out.println("----------------------------------------------------------------");

        Map<Articul, Vehicle> liked = new LinkedHashMap<>();

        liked.put(new Articul("aaaa"), new Car("Tesla 1", "Red", 80_000, "USA", "auto", "electrical"));
        liked.put(new Articul("asdfg"), new Car("TeslaS 2", "Blue", 85_000, "USA", "auto", "electrical"));
        liked.put(new Articul("zxxcvb"), new Car("BMW 3", "Blue", 85_000, "GE", "auto", "gas"));
        liked.put(new Articul("sds"), new Car("BMW 4", "Blue", 85_000, "GE", "auto", "gas"));
        liked.put(new Articul("zxxcvb"), new Car("BMW A 5", "Blue", 85_000, "GE", "auto", "gas"));

        for (Map.Entry<Articul, Vehicle> o : liked.entrySet()) {
            System.out.println(o);
        }

        System.out.println(System.lineSeparator());

        Map<Articul2, Vehicle> liked1 = new LinkedHashMap<>();

        liked1.put(new Articul2("aaaadtsyhestjuty7jauaa"), new Car("Tesla 1", "Red", 80_000, "USA", "auto", "electrical"));
        liked1.put(new Articul2("asdfgdftjdfyj"), new Car("TeslaS 2", "Blue", 85_000, "USA", "auto", "electrical"));
        liked1.put(new Articul2("zxxddfthjufjcvb"), new Car("BMW 3", "Blue", 85_000, "GE", "auto", "gas"));
        liked1.put(new Articul2("sfdtdfthdrfhjjdftjds"), new Car("BMW 4", "Blue", 85_000, "GE", "auto", "gas"));
        liked1.put(new Articul2("tdfjdftjdft"), new Car("BMW A 5", "Blue", 85_000, "GE", "auto", "gas"));

        for (Map.Entry<Articul2, Vehicle> o : liked1.entrySet()) {
            System.out.println(o);
        }
    }
}
