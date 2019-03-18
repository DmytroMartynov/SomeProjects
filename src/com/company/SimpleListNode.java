package com.company;

public class SimpleListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(deleteDuplicates(node1));
    }
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.val==head.next.val) {
            ListNode next_next = head.next.next;
            head.next = next_next;
            deleteDuplicates(head);
        } else {
            deleteDuplicates(head.next);
        }
        return head;
    }
    }

