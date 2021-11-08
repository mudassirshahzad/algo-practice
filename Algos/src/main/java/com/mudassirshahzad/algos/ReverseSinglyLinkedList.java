package com.mudassirshahzad.algos;

import com.mudassirshahzad.algos.utils.TreeNode;

public class ReverseSinglyLinkedList {

    public static void main(String[] args) {

        TreeNode<Integer> linkedList = getSinglyLinkedList();
        TreeNode.displaySinglyList(linkedList);
        System.out.println("\n");
        TreeNode<Integer> reversed = reverseLinkedList(linkedList);
        TreeNode.displayForward(reversed);

    }

    private static TreeNode<Integer> reverseLinkedList(TreeNode<Integer> head){

        if(head == null) {
            return null;
        }

        TreeNode<Integer> current = head;
        TreeNode<Integer> previous = null;
        TreeNode<Integer> next = null;

        while(current != null){

            next = current.right;
            current.right = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private static TreeNode<Integer> getSinglyLinkedList() {
        TreeNode<Integer> head = new TreeNode<Integer>(4);

        TreeNode<Integer> n1 = new TreeNode<Integer>(2);
        TreeNode<Integer> n2 = new TreeNode<Integer>(7);
        TreeNode<Integer> n3 = new TreeNode<Integer>(1);
        TreeNode<Integer> n4 = new TreeNode<Integer>(3);

        head.right = n1;
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        return head;
    }
}




