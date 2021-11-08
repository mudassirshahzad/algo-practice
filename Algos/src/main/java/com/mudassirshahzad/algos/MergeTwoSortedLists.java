package com.mudassirshahzad.algos;

import com.mudassirshahzad.algos.utils.ListNode;

class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode<Integer> headList1 = getList1();
        ListNode<Integer> headList2 = getList2();

        ListNode<Integer> merged = mergeLists(headList1, headList2);
        ListNode.displayForward(merged);

    }

    public static ListNode<Integer> getList1() {

        ListNode<Integer> root = new ListNode<>(0);

        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);

        addToTheLast(root, node1);
        addToTheLast(root, node2);
        addToTheLast(root, node3);

        return root;

    }

    public static ListNode<Integer> getList2() {

        ListNode<Integer> root = new ListNode<>(4);

        ListNode<Integer> node1 = new ListNode<>(5);
        ListNode<Integer> node2 = new ListNode<>(6);
        ListNode<Integer> node3 = new ListNode<>(7);

        addToTheLast(root, node1);
        addToTheLast(root, node2);
        addToTheLast(root, node3);

        return root;

    }

    public static void addToTheLast(ListNode<Integer> head, ListNode<Integer> node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static ListNode<Integer> mergeLists(ListNode<Integer> root1, ListNode<Integer> root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        if (root1.data < root2.data) {
            root1.next = mergeLists(root1.next, root2);
            return root1;
        } else {
            root2.next = mergeLists(root1, root2.next);
            return root2;
        }

    }
}