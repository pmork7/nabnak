package com.revature.nabnak.util.CustomCollections;

import java.util.Arrays;

public class ArrayList implements List<Object> {
    private int size = 0;
    private Object[] elements;

    @Override
    public boolean add(Object element) {
        System.out.println(element);
        if (size == 0) {
            elements = new Object[1];
            elements[0] = element;
            size++;
        } else {
            elements = Arrays.copyOf(elements, ++size);
            elements[size - 1] = element;
        }
        return true;
    }

    @Override
    public boolean contains(Object element) {
        int i;
        for (i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object element) {
        int i;
        for (i = 0; i < elements.length; i++) {

        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int index) {
        if (index < size) {
            return elements[index];
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
