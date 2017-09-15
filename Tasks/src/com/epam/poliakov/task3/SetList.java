package com.epam.poliakov.task3;

import java.util.ArrayList;
import java.util.Collection;

public class SetList<E> extends ArrayList<E> {

    @Override
    public E set(int index, E element) {
        E oldItem = get(index);

        if (!contains(element)) {
            return super.set(index, element);
        }
        return oldItem;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            super.set(indexOf(element), element);
            return false;
        }
        return super.add(element);
    }

    @Override
    public void add(int index, E element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        E[] a = (E[]) collection.toArray();
        int oldSize = size();

        for (int i = 0; i < a.length; i++) {
            if (!contains(a[i])) {
                super.add(a[i]);
            }
        }
        return oldSize != size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        E[] a = (E[]) collection.toArray();
        int oldSize = size();

        for (int i = 0; i < a.length; i++) {
            if (!contains(a[i])) {
                super.add(a[i]);
            }
        }
        return oldSize != size();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
