package com.epam.poliakov.task1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArrayListTest {

    private List<Integer> list;

    @Before
    public void initArrayList() {
        list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void testShouldReturnArrayListSize() {
        int expectedSize = 5;
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldReturnFalseIfArrayListIsNotEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void testShouldReturnTrueIfArrayListIsEmpty() {
        List<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testShouldGetItemFromArrayList() {
        assertEquals((Object) list.get(0), 1);
    }

    @Test
    public void testShouldReturnTrueIfArrayListContainsItem() {
        assertTrue(list.contains(5));
    }

    @Test
    public void testShouldReturnTrueIfArrayListContainsNull() {
        list.add(null);

        assertTrue(list.contains(null));
    }

    @Test
    public void testShouldReturnFalseIfArrayListNotContainsItem() {
        assertFalse(list.contains(6));
    }

    @Test
    public void testShouldGetIndexOfItemInArrayList() {
        assertEquals(list.indexOf(4), 3);
        assertEquals(list.indexOf(5), 4);
    }

    @Test
    public void testShouldGetLastIndexOfItemInArrayList() {
        list.add(4);
        list.add(5);

        assertEquals(list.lastIndexOf(4), 5);
        assertEquals(list.lastIndexOf(5), 6);
    }

    @Test
    public void testShouldSetItemInArrayList() {
        int actualSize = list.size();
        int oldItem = list.get(list.size() - 1);
        list.set(list.size() - 1, 6);
        int newItem = list.get(list.size() - 1);
        assertNotEquals(newItem, oldItem);
        assertEquals(actualSize, list.size());
    }

    @Test
    public void testShouldAddByIndexInArrayList() {
        int expectedSize = list.size() + 1;
        list.add(list.size(), 6);
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldRemoveByIndexInArrayList() {
        int expectedObject = list.get(2);
        int expectedSize = list.size() - 1;

        assertEquals((Object) list.remove(2), expectedObject);
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldRemoveObjectInArrayList() {
        int expectedSize = list.size() - 1;
        assertTrue(list.remove((Object) 1));
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldClearArrayList() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testShouldAddAllElementsOfCollectionInArrayList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        int expectedSize = list.size() + list1.size();
        list.addAll(list1);
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldAddAllByIndexInArrayList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        int expectedSize = list.size() + list1.size();
        list.addAll(list.size(), list1);
        assertEquals(list.size(), expectedSize);
    }

    @Test
    public void testShouldCheckIsContainsAllElementsInArrayList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        list.addAll(list.size(), list1);
        assertTrue(list.containsAll(list1));
    }

    @Test
    public void testShouldRemoveAllItemsFromArrayList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        list.addAll(list.size(), list1);
        assertEquals(list.removeAll(list1), true);
    }

    @Test
    public void testShouldRetainAllInArrayList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(2);
        list1.add(3);

        list.retainAll(list1);
        assertEquals(list.size(), 2);
    }

    @Test
    public void testShouldAddAllInArrayListWhereSecondListGreatThenFirst() {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        List<Integer> list1 = new ArrayList();

        for (int i = 0; i < 100000; i++) {
            list1.add(i);
        }

        int expected = list.size() + list1.size();

        list.addAll(list1);

        assertEquals(list.size(), expected);
    }
}
