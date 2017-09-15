package com.epam.poliakov.task2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        System.out.println();
        System.out.println();

        for (Object o : list) {
            list.add(10110);
            System.out.println(o);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(list);
        list.add(223);
        System.out.println(list);

        /*List<Integer> list1 = new ArrayList<>();

        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        System.out.println(list1);

        ListWrapper<Integer> wrapper = new ListWrapper<>(list, list1);

        System.out.println(wrapper);

        wrapper.remove(1);

        for (Object o : wrapper) {
            System.out.print(o + ", ");
        }*/
    }
}
