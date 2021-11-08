package com.mudassirshahzad.algos.utils;

public class TreeNode<T extends Comparable<?>> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public static void displaySinglyList(TreeNode head) {
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.right;
        }
        System.out.print("null");
    }

    public static void displayForward(TreeNode head) {
        if(head == null) {
            return;
        }

        TreeNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.right;
        }
        System.out.println("null");
    }

    public static void displayBackward(TreeNode tail) {
        if(tail == null) {
            return;
        }

        TreeNode temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.left;
        }
        System.out.println("null");
    }
}