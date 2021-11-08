package com.mudassirshahzad.algos;

import com.mudassirshahzad.algos.utils.BinaryTreePrinter;
import com.mudassirshahzad.algos.utils.TreeNode;

class InvertBinaryTree {

    public static void main(String... strings) {

        BinaryTreePrinter.printNode(test1());

        TreeNode<Integer> rootInverted = invertTree(test1());

        BinaryTreePrinter.printNode(rootInverted);

    }

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root) {

        if (root == null) {
            return root;
        }

        TreeNode<Integer> left = invertTree(root.left);
        TreeNode<Integer> right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    private static TreeNode<Integer> test1() {
        TreeNode<Integer> root = new TreeNode<Integer>(4);

        TreeNode<Integer> n11 = new TreeNode<Integer>(2);
        TreeNode<Integer> n12 = new TreeNode<Integer>(7);

        TreeNode<Integer> n21 = new TreeNode<Integer>(1);
        TreeNode<Integer> n22 = new TreeNode<Integer>(3);

        TreeNode<Integer> n23 = new TreeNode<Integer>(6);
        TreeNode<Integer> n24 = new TreeNode<Integer>(9);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.left = n23;
        n12.right = n24;

        return root;
    }

    private static TreeNode<Integer> test2() {
        TreeNode<Integer> root = new TreeNode<Integer>(2);
        TreeNode<Integer> n11 = new TreeNode<Integer>(7);
        TreeNode<Integer> n12 = new TreeNode<Integer>(5);
        TreeNode<Integer> n21 = new TreeNode<Integer>(2);
        TreeNode<Integer> n22 = new TreeNode<Integer>(6);
        TreeNode<Integer> n23 = new TreeNode<Integer>(9);
        TreeNode<Integer> n31 = new TreeNode<Integer>(5);
        TreeNode<Integer> n32 = new TreeNode<Integer>(8);
        TreeNode<Integer> n33 = new TreeNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

}