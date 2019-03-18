package com.company;

public class MyTreeMap<K extends Comparable<K>, V> implements IntTreeMap<K, V> {
    Node<K, V> root;
    private StringBuffer sb;

    public MyTreeMap() {
        root = null;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    public V get(Node<K, V> node, K key) {
        while (node != null) {
            int compared = key.compareTo(node.key);
            if (compared < 0) {
                node = node.left;
            } else if (compared > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private Node put(Node<K, V> tempRoot, K key, V value) {
        if (tempRoot == null) {
            return new Node<K, V>(key, value, 1);
        }
        int cmp = key.compareTo(tempRoot.key);
        // recursive search
        if (cmp < 0) {
            tempRoot.left = put(tempRoot.left, key, value);
            tempRoot.left.parent = tempRoot;
        } else if (cmp > 0) {
            tempRoot.right = put(tempRoot.right, key, value);
            tempRoot.right.parent = tempRoot;
        } else {
            tempRoot.value = value;
        }
        tempRoot.size = size(tempRoot.left) + size(tempRoot.right) + 1;

        return tempRoot;
    }

    private int size(Node<K, V> x) {
        if (x == null)
            return 0;
        return x.size;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> e = getFirstNode(); e != null; e = successor(e))
            if (valEquals(value, e.value))
                return true;
        return false;

    }

    private Node<K, V> successor(Node<K, V> e) {
        if (e == null)
            return null;
        else if (e.right != null) {
            Node<K, V> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Node<K, V> p = e.parent;
            Node<K, V> ch = e;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    public boolean valEquals(Object o1, Object o2) {

        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    public Node<K, V> getFirstNode() {
        Node<K, V> p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void remove(K key) {
        if (!containsKey(key))
            return;
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K, V> node, K key) {
        int compared = key.compareTo(node.key);
        if (compared < 0) {
            node.left = remove(node.left, key);
        } else if (compared > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            node.key = minValue(root.right);
            node.right = remove(node.right, node.key);
        }
        return node;

    }

    private K minValue(MyTreeMap<K, V>.Node<K, V> root) {
        K minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    @Override
    public void clear() {
        root = null;
    }

    public String toString() {
        sb = new StringBuffer();
        toString(root);
        return "{" + sb.toString().subSequence(0, sb.toString().length() - 2) + "}";
    }

    private void toString(MyTreeMap<K, V>.Node<K, V> tempRoot) {
        if (tempRoot != null) {
            toString(tempRoot.left);
            sb.append(tempRoot.key + "=" + tempRoot.value);
            sb.append(", ");
            toString(tempRoot.right);
        }
    }

    class Node<K extends Comparable<K>, V> {
        private int size;
        private K key;
        private V value;
        private Node<K, V> left = null;
        private Node<K, V> right = null;
        private Node<K, V> parent = null;

        Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
}