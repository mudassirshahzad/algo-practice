package com.mudassirshahzad.algos.utils;

public class Node<T extends Comparable<?>> {
    public Node<T> left;
    public Node<T> right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}