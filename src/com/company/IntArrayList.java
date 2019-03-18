package com.company;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] elements = new int[DEFAULT_CAPACITY];

    //переменная, которая показывает в какой индекс добавить елемент
    private int index;

    public static void main(String[] args) {
        IntList list = new IntArrayList();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list.toString());
        System.out.println( list.indexOf(13));
        System.out.println(list.size());
        System.out.println(list.remove(2));
        System.out.println(list.toString());
    }
    @Override
    public void add(int value) {
        if (index == elements.length) {
            growArray();
        }
        elements[index] = value;
        index++;

    }

    @Override
    public void add(int index, int element) {
        checkIndex(index);
        if (index == elements.length) {
            growArray();
        }
        System.arraycopy(elements, index, elements, index + 1, this.index - index);
        elements[index] = element;
        this.index++;

    }

    @Override
    public void clear() {
        index = 0;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    private void growArray() {
        int[] newArray = new int[elements.length * 3 / 2 + 1];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    public void set(int index, int value) {
        checkIndex(index);
        elements[index] = value;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }

    public int size() {
        return index;
    }

    public int remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, this.index - index);
        this.index--;
        return index;
    }

    public int indexOf(int value) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (elements[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return "IntArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", index=" + index +
                '}';
    }
}
