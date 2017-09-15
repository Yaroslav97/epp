package com.epam.poliakov.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SetListTest {

    private List<String> list;

    @Before
    public void initList(){
        list = new SetList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
    }
    @Test
    public void testShouldNotChangeItemIfSetListContainsIt() throws Exception {
        String itemBefore = list.get(2);
        list.set(2, "a");
        String itemAfter = list.get(2);
        assertEquals(itemBefore, itemAfter);
    }

    @Test
    public void testShouldChangeItemIfSetListNotContainsIt() throws Exception {
        String itemBefore = list.get(2);
        list.set(2, "p");
        String itemAfter = list.get(2);
        assertNotEquals(itemBefore, itemAfter);
    }

    @Test
    public void testShouldAddItemInSetList() throws Exception {
        int sizeBefore = list.size();
        list.add("s");
        assertNotEquals(sizeBefore + 1, sizeBefore);
    }

    @Test
    public void testShouldNotAddItemInSetList() throws Exception {
        int sizeBefore = list.size();
        list.add("a");
        assertEquals(list.size(), sizeBefore);
    }

    @Test
    public void testShouldAddByIndexInSetList() throws Exception {
        int sizeBefore = list.size();
        list.add(list.size(), "z");
        assertEquals(list.size(), sizeBefore + 1);
    }

    @Test
    public void testShouldNotAddByIndexInSetList() throws Exception {
        int sizeBefore = list.size();
        list.add(list.size(), "a");
        assertEquals(list.size(), sizeBefore);
    }

    @Test
    public void testShouldAddAllInSetList() throws Exception {
        List<String> list1 = new SetList<>();
        list1.add("z");
        list1.add("x");
        list1.add("v");

        int sizeListBefore = list.size();
        int sizeList1Before = list1.size();

        list.addAll(list1);

        assertEquals(sizeListBefore + sizeList1Before, list.size());
    }

    @Test
    public void testShouldNotAddAllInSetList() throws Exception {
        List<String> list1 = new SetList<>();
        list1.add("c");
        list1.add("x");
        list1.add("v");
        list1.add("v");

        int sizeListBefore = list.size();

        list.addAll(list1);

        assertEquals(sizeListBefore + 2, list.size());
    }

    @Test
    public void testShouldAddAllByIndex() throws Exception {
        List<String> list1 = new SetList<>();
        list1.add("z");
        list1.add("x");
        list1.add("v");

        int sizeListBefore = list.size();
        int sizeList1Before = list1.size();

        list.addAll(sizeListBefore, list1);

        assertEquals(sizeListBefore + sizeList1Before, list.size());
    }

    @Test
    public void testShouldNotAddAllByIndex() throws Exception {
        List<String> list1 = new SetList<>();
        list1.add("c");
        list1.add("x");
        list1.add("v");
        list1.add("v");

        int sizeListBefore = list.size();

        list.addAll(sizeListBefore-1, list1);

        assertEquals(sizeListBefore + 2, list.size());
    }

}