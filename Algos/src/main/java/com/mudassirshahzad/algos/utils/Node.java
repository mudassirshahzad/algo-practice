package com.mudassirshahzad.algos.utils;

public class Node<T extends Comparable<?>> {
    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public static void displaySinglyList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.right;
        }
        System.out.print("null");
    }

    public static void displayForward(Node head) {
        if(head == null) {
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.right;
        }
        System.out.println("null");
    }

    public static void displayBackward(Node tail) {
        if(tail == null) {
            return;
        }

        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.left;
        }
        System.out.println("null");
    }
}