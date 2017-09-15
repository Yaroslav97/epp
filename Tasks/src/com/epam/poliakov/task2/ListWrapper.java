package com.epam.poliakov.task2;

import com.epam.poliakov.task2.exception.UnmodifiableException;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListWrapper<E> implements List<E> {

    private List<E> unmodifiable;
    private List<E> modifiable;

    public ListWrapper(List<E> unmodifiable, List<E> modifiable) {
        this.unmodifiable = unmodifiable;
        this.modifiable = modifiable;
    }

    @Override
    public int size() {
        return unmodifiable.size() + modifiable.size();
    }

    @Override
    public boolean isEmpty() {
        return modifiable.isEmpty() && unmodifiable.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return modifiable.contains(o) || unmodifiable.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {
        boolean isCanRemove = false;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public E next() {
            isCanRemove = true;

            if (index < unmodifiable.size()) {
                return unmodifiable.get(index++);
            }
            return modifiable.get((index++) - unmodifiable.size());

        }

        @Override
        public void remove() {
            if (isCanRemove && index > unmodifiable.size()) {
                isCanRemove = false;
                ListWrapper.this.remove(index);
            } else {
                throw new UnmodifiableException();
            }

        }
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[]{});

    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] array = a;
        if (array.length < size()) {
            array = (T[]) Array.newInstance(a.getClass().getComponentType(), size());
        }
        System.arraycopy(unmodifiable.toArray(), 0, array, 0, unmodifiable.size());
        System.arraycopy(modifiable.toArray(), 0, array, unmodifiable.size(), modifiable.size());
        return (T[]) array;
    }

    @Override
    public boolean add(E e) {
        return modifiable.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (unmodifiable.contains(o)) {
            throw new UnmodifiableException("You try remove element in Unmodifiable collection");
        }
        return modifiable.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        E[] arr = (E[]) c.toArray();

        for (int i = 0; i < arr.length; i++) {
            if (!unmodifiable.contains(arr[i]) && !modifiable.contains(arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return modifiable.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < unmodifiable.size()) {
            throw new UnmodifiableException("You try addAll element in Unmodifiable collection");
        }



        return modifiable.addAll(index - unmodifiable.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        E[] collection = (E[]) c.toArray();

        for (int i = 0; i < collection.length; i++) {
            if (unmodifiable.contains(collection[i])) {
                throw new UnmodifiableException("You try remove element in Unmodifiable collection");
            }
        }
        return modifiable.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        E[] collection = (E[]) c.toArray();

        for (int i = 0; i < collection.length; i++) {
            if (!unmodifiable.contains(collection[i])) {
                throw new UnmodifiableException("You try retain element in Unmodifiable collection");
            }
        }
        return modifiable.retainAll(c);
    }

    @Override
    public void clear() {
        if (unmodifiable.size() > 0) {
            throw new UnmodifiableException("You try clear element in Unmodifiable collection");
        }
        modifiable.clear();
    }

    @Override
    public E get(int index) {
        if (unmodifiable.size() > index) {
            return unmodifiable.get(index);
        }
        return modifiable.get(index - modifiable.size());
    }

    @Override
    public E set(int index, E element) {
        return modifiable.set(index - unmodifiable.size(), element);
    }

    @Override
    public void add(int index, E element) {
        if (index <= unmodifiable.size()) {
            throw new UnmodifiableException("You try set element in Unmodifiable collection");
        }
        modifiable.add(index - unmodifiable.size(), element);
    }

    @Override
    public E remove(int index) {
        if (index <= unmodifiable.size()) {
            throw new UnmodifiableException("You try remove element in Unmodifiable collection");
        }
        return modifiable.remove(index - unmodifiable.size());
    }

    @Override
    public int indexOf(Object o) {
        if (unmodifiable.indexOf(o) != -1) {
            return unmodifiable.indexOf(o);
        }
        return modifiable.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        if (modifiable.lastIndexOf(o) != -1) {
            return modifiable.lastIndexOf(o) + unmodifiable.size();
        }
        return unmodifiable.lastIndexOf(o);
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

    @Override
    public String toString() {
        return "ListWrapper{" +
                "unmodifiable=" + unmodifiable +
                ", modifiable=" + modifiable +
                '}';
    }
}
