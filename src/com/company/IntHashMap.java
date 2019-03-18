package com.company;

import java.util.Arrays;

public class IntHashMap<K, V> implements IntMap<K, V> {
    private static int DEFAULT_CAPACITY = 16;
    int size;
    private Entry[] entry;

    public IntHashMap() {
        entry = new Entry[DEFAULT_CAPACITY];
    }

    public IntHashMap(int capacity) {
        DEFAULT_CAPACITY = capacity;
        entry = new Entry[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        Entry[] tab = entry;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new RuntimeException("we dont use null key");
        }
        int hashValue = hashVal(key);
        Entry<K, V> entry = new Entry<K, V>(key, value, null);

        if (this.entry[hashValue] == null) {
            this.entry[hashValue] = entry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = this.entry[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        entry.next = current.next;
                        this.entry[hashValue] = entry;
                    } else {
                        entry.next = current.next;
                        previous.next = entry;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = entry;
        }
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hashValue = hashVal(key);
        if (entry[hashValue] == null) {
            return null;
        } else {
            Entry<K, V> temp = entry[hashValue];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) {
            return false;
        }
        int hashValue = hashVal(key);
        if (entry[hashValue] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = entry[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        entry[hashValue] = entry[hashValue].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    @Override
    public boolean containsKey(K key) {
        int hashValue = hashVal(key);
        if (entry[hashValue] == null) {
            return false;
        } else {
            Entry<K, V> current = entry[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i] != null) {
                int nodeCount = 0;
                for (Entry e = entry[i]; e.next != null; e = e.next) {
                    nodeCount++;
                }
                count += nodeCount;
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null)
            return containsNullValue();

        Entry[] tab = entry;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private boolean containsNullValue() {
        Entry[] tab = entry;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                if (e.value == null)
                    return true;
        return false;
    }

    private int hashVal(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    @Override
    public String toString() {
        return "IntHashMap{" +
                "entry=" + Arrays.toString(entry) +
                ", startCAPACITY=" + DEFAULT_CAPACITY +
                ", size=" + size +
                '}';
    }

    static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

}
