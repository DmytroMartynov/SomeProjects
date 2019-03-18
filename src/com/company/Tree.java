package com.company;

public class Tree {

    public static void main(String[] args) {

        Node root = new Node(3);

        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node1;

        node2.right = node5;
    System.out.println(isSame(root));

        printTree(root);
    }

    public static boolean isSame(Node root) {
            if (root.value ==root.left.value && root.value == root.right.value && root.left.value == root.left.right.value){
                return true;
            }

        return false;
    }


    public static void printTree(Node node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.print(node.value + " ");
        printTree(node.right);
    }


}
