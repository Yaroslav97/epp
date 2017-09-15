package com.epam.poliakov.task1;

import java.util.*;

public class ArrayList<E> implements List<E> {

    public static final int INITIAL_CAPACITY = 10;

    private E[] arr;
    private int index;
    private int size;

    public ArrayList() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayList(int capacity) {
        arr = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {

        if (object == null) {
            if (arr[indexOf(object)] == null)
                return true;
        } else {
            if (indexOf(object) >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(arr, size, a.getClass());
        }
        System.arraycopy(arr, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E element) {
        int oldSize = size;
        checkCapacity(size);
        arr[index++] = element;
        size++;
        return oldSize != size;
    }

    @Override
    public boolean remove(Object object) {
        int oldSize = size;
        E[] localArr = (E[]) new Object[length() - 1];

        for (int i = 0, j = 0; i < size; i++) {
            if (!arr[i].equals(object)) {
                localArr[j++] = arr[i];
            }
        }
        arr = localArr;
        size = size - 1;
        return oldSize != size();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        int oldSize = size;
        //if (collection.size() >= length()) {
        Object[] a = collection.toArray();
        checkCapacity(size + a.length);
        //} //else {
        System.arraycopy(a, 0, arr, size, a.length);
        size += a.length;
        //}

        return oldSize != size;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        int oldSize = size;
        if (collection.size() >= length()) {
            checkCapacity(size);
        } else {
            Object[] a = collection.toArray();
            System.arraycopy(a, 0, arr, index, a.length);
            size += a.length;
        }
        return oldSize != size;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int oldSize = size;

        for (Object o : collection) {
            remove(o);
        }

        return oldSize != size;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int oldSize = size;

        for (int i = 0; i < size; i++) {
            if (!collection.contains(arr[i])) {
                remove(i);
                i--;
            }
        }
        return oldSize != size;
    }

    @Override
    public void clear() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
        index = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldItem = get(index);
        arr[index] = element;
        return oldItem;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        checkCapacity(size);
        arr[index++] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E oldElement = get(index);
        remove(oldElement);
        return oldElement;
    }

    @Override
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (object.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (arr[i].equals(object)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class IteratorImpl implements Iterator<E> {
        int index = 0;
        boolean flag = false;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            flag = false;
            return arr[index++];
        }

        @Override
        public void remove() {
            if (flag) {
                ArrayList.this.remove(index);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    public class FilterIterator<E> implements Iterator<E> {
        private Predicate<E> predicate;
        private int localIndex = 0;
        private boolean isCanRemove = false;

        public FilterIterator(Predicate predicate) {
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            for (int i = localIndex; i < size; i++) {
                if (predicate.test((E) arr[i])) {
                    localIndex = i;
                    return localIndex < size;
                }
            }
            return false;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            isCanRemove = true;
            return (E) arr[localIndex++];
        }

        @Override
        public void remove() {
            if (!isCanRemove) {
                throw new IllegalStateException();
            }
            isCanRemove = false;
            ArrayList.this.remove(localIndex);
        }
    }

    private void checkCapacity(int size) {
        if (size >= length()) {
            E[] localArr = (E[]) new Object[arr.length + size * 2];
            for (int i = 0; i < arr.length; i++) {
                localArr[i] = arr[i];
            }
            arr = (E[]) new Object[arr.length * 2];
            arr = localArr;
        }
    }

    private int length() {
        return arr.length;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                list.append(arr[i] + ", ");
            } else {
                list.append(arr[i]);
            }
        }
        return "[" + list.toString() + "]";
    }
}
