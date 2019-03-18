package com.company;

 interface IntMap<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public boolean containsKey(K key);
    public int size();
    public boolean containsValue(Object value);
    public boolean isEmpty();
    public boolean remove(K key);
    public void clear();


}
