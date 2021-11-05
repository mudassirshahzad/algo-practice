package com.mudassirshahzad.algos;

import com.mudassirshahzad.algos.utils.Node;

public class ReverseSinglyLinkedList {

    public static void main(String[] args) {

        Node<Integer> linkedList = getSinglyLinkedList();
        Node.display(linkedList);
        System.out.println("\n");
        Node<Integer> reversed = reverseLinkedList(linkedList);
        Node.display(reversed);

    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head){

        if(head == null) {
            return null;
        }

        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> next = null;

        while(current != null){

            next = current.right;
            current.right = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private static Node<Integer> getSinglyLinkedList() {
        Node<Integer> head = new Node<Integer>(4);

        Node<Integer> n1 = new Node<Integer>(2);
        Node<Integer> n2 = new Node<Integer>(7);
        Node<Integer> n3 = new Node<Integer>(1);
        Node<Integer> n4 = new Node<Integer>(3);

        head.right = n1;
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        return head;
    }
}




