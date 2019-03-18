package com.company;

public interface IntList {

    public void add(int value);

    public void add(int index, int element);

    public void clear();

    public boolean contains(int value);

    public int get(int index);

    public boolean isEmpty();

    public int remove(int index);

    public void set(int index, int element);

    public int size();
    public String toString();

    int indexOf(int i);
}

