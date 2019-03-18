package com.company;

public interface IntTreeMap<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public boolean containsKey(K key);
    public int size();
    public boolean containsValue(Object value);
    public void remove(K key);
    public void clear();
    public boolean isEmpty();
}
