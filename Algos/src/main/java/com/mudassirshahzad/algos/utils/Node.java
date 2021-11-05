package com.mudassirshahzad.algos.utils;

public class Node<T extends Comparable<?>> {
    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public static void display(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.right;
        }
        System.out.print("null");
    }
}