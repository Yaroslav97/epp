package com.epam.poliakov.task2;

import com.epam.poliakov.task2.exception.UnmodifiableException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListWrapperTest {

    private static final int WRONG_ELEMENT = 54;
    private static final int EXPECTED_WRAPPER_SIZE = 10;
    private ListWrapper<Integer> wrapper;

    @Before
    public void initArrayList() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list1 = new ArrayList<>();

        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        wrapper = new ListWrapper<>(list, list1);
    }

    @Test
    public void testShouldReturnWrapperListSize() {
        assertEquals(wrapper.size(), EXPECTED_WRAPPER_SIZE);
    }

    @Test
    public void testShouldReturnFalseIfWrapperListIsNotEmpty() {
        assertFalse(wrapper.isEmpty());
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldReturnFalseIfWrapperListIsEmptyAfterClear() {
        wrapper.clear();
    }

    @Test
    public void testShouldReturnTrueIfWrapperListContainsNullItem() {
        wrapper.add(null);
        assertTrue(wrapper.contains(null));
    }

    @Test
    public void testShouldReturnFalseIfWrapperListNotContainsItem() {
        assertFalse(wrapper.contains(WRONG_ELEMENT));
    }

    @Test
    public void testShouldGetIndexOfItemInWrapperList() {
        assertEquals(wrapper.indexOf((Object) 5), 4);
    }

    @Test
    public void testShouldGetLastIndexOfItemInWrapperList() {
        wrapper.add(4);
        wrapper.add(5);

        assertEquals(wrapper.lastIndexOf((Object) 4), 10);
        assertEquals(wrapper.lastIndexOf((Object) 5), 11);
    }

    @Test
    public void testShouldSetItemInWrapperList() {
        int oldItem = wrapper.get(6);
        wrapper.set(6, 16);
        int newItem = wrapper.get(6);
        assertNotEquals(newItem, oldItem);
    }

    @Test
    public void testShouldAddByIndexInModifyPartOfWrapperList() {
        wrapper.add(EXPECTED_WRAPPER_SIZE, 12);
        assertEquals(EXPECTED_WRAPPER_SIZE + 1, 11);
    }

    @Test
    public void testShouldRemoveByIndexInWrapperList() {
        int expectedSize = wrapper.size() - 1;

        assertEquals((Object) wrapper.remove(6), 6);
        assertEquals(wrapper.size(), expectedSize);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldNotRemoveByIndexInWrapperList() {
        wrapper.remove(0);
    }

    @Test
    public void testShouldRemoveObjectInWrapperList() {
        int expectedSize = wrapper.size() - 1;

        assertTrue(wrapper.remove((Object) 6));
        assertEquals(wrapper.size(), expectedSize);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldNotRemoveObjectInWrapperList() {
        wrapper.remove((Object) 1);
    }

    @Test
    public void testShouldReturnWrapperListToArray() {
        assertEquals(wrapper.toArray().length, EXPECTED_WRAPPER_SIZE);
    }

    @Test
    public void testShouldReturnWrapperListToArrayWithParameter() {
        assertEquals(wrapper.toArray(wrapper.toArray()).length, EXPECTED_WRAPPER_SIZE);
    }

    @Test
    public void testShouldAddAllElementsOfCollectionInWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        int expectedSize = wrapper.size() + list1.size();
        wrapper.addAll(list1);
        assertEquals(wrapper.size(), expectedSize);
    }

    @Test
    public void testShouldAddAllByIndexInWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        int expectedSize = wrapper.size() + list1.size();
        wrapper.addAll(wrapper.size(), list1);
        assertEquals(wrapper.size(), expectedSize);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldNotAddAllByIndexInWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(51);

        wrapper.addAll(4, list1);
    }

    @Test
    public void testShouldCheckIsContainsAllElementsInWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        wrapper.addAll(wrapper.size(), list1);
        assertTrue(wrapper.containsAll(list1));
    }

    @Test
    public void testShouldIteratorWrapperList() {
        int sizeCount = 0;

        for (Object o : wrapper) {
            sizeCount++;
        }
        assertEquals(wrapper.size(), sizeCount);
    }

    @Test
    public void testShouldRemoveAllItemsFromWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(11);
        list1.add(21);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        wrapper.addAll(wrapper.size(), list1);
        assertEquals(wrapper.removeAll(list1), true);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldRemoveAllItemsByIndexFromWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(31);
        list1.add(41);
        list1.add(51);

        wrapper.removeAll(list1);
    }

    @Test
    public void testShouldRetainAllItemsFromWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        assertTrue(wrapper.retainAll(list1));
    }

    @Test(expected = UnmodifiableException.class)
    public void UnmodifiableException() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        wrapper.retainAll(list1);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldNotRemoveAllItemsByIndexFromWrapperList() {
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(41);
        list1.add(51);

        wrapper.removeAll(list1);
    }

    @Test
    public void testShouldGetItemFromWrapperList() {
        assertEquals(wrapper.get(0), (Object) 1);
        assertEquals(wrapper.get(9), (Object) 9);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testShouldNotGetItemFromWrapperList() {
        wrapper.get(100);
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldNotAddItemInWrapperList() {
        wrapper.add(5, 7);
    }

    @Test
    public void iteratorShouldIgnoreChangesInArrayList() {
        List<String> list = new ArrayList<>();

        list.add("CopyOnWrite");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        List<String> list1 = new ArrayList<>();

        list1.add("f");
        list1.add("g");
        list1.add("h");
        list1.add("i");
        list1.add("j");

        ListWrapper<String> wrapper = new ListWrapper<>(list, list1);

        int sizeBeforeLaunchIterator = wrapper.size();
        int countSize = 0;

        for (Object o : wrapper) {
            countSize++;
        }

        assertEquals(sizeBeforeLaunchIterator, countSize);
    }
}
