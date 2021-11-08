package com.mudassirshahzad.algos.utils;

public class ListNode<T extends Comparable<?>> {
    public ListNode<T> next;
    public ListNode<T> previous;
    public T data;

    public ListNode(T data) {
        this.data = data;
    }

    public static void displaySinglyList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void displayForward(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void displayBackward(ListNode tail) {
        if(tail == null) {
            return;
        }

        ListNode temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }
}