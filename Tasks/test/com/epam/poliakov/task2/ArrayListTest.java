package com.epam.poliakov.task2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void iteratorShouldIgnoreChangesInArrayList() {
        List<String> list = new ArrayList<>();

        list.add("CopyOnWrite");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        int sizeBeforeLaunchIterator = list.size();
        int countSize = 0;

        for (Object o : list) {
            list.add("f");
            countSize++;
        }
        assertEquals(sizeBeforeLaunchIterator, countSize);
        assertEquals(list.size(), 10);
    }
}
