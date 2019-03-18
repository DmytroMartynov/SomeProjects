package com.company;

public class IntLinkedList implements IntList2 {

    private Element last;
    private Element first;
    private int count = 0;

    private class Element {

        public int value;
        private Element next;
        private Element previous;

        public Element(int value) {
            this.value = value;
        }
    }

    @Override
    public void add(int value) {
        Element newElement = new Element(value);
        if (first  == null) {
            newElement.next = null;
            newElement.previous = null;
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }
        count++;
    }
    public void add(int index, int element) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Element newElement = new Element(element);
        if (index == 0) {
            add(element);
        }
        if (index == count) {
            last.next = newElement;
            last = newElement;
        }
        Element oldElement = first;
        for (int i = 0; i < index; i++) {
            oldElement = oldElement.next;
        }
        Element oldPrevious = oldElement.previous;
        oldPrevious.next = newElement;
        oldElement.previous = newElement;

        newElement.previous = oldPrevious;
        newElement.next = oldElement;
        count++;
    }


    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }
    @Override
    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Element result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.value;
    }


    @Override
    public void set(int index, int element) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Element result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        result.value = element;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {

        return count == 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < count; i++) {
            if (get(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Element elem = findElementBeforeByIndex(index);
            Element tmp = findByIndex(index);
            elem.next = tmp.next;
        }
        count--;
        return index;
    }

    private Element findByIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }
        Element elem = first;
        while (elem.next != null) {
            elem = elem.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return elem;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Element findElementBeforeByIndex(int index) {
        if (index <= 0 || index > count - 1) {
            return null;
        }
        int counter = 0;
        Element elem = first;
        while (elem.next != null) {
            if (counter == index - 1) {
                return elem;
            }
            counter++;
            elem = elem.next;
        }
        return null;
    }
}
