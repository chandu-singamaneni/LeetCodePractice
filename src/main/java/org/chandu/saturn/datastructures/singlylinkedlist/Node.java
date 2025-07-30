package org.chandu.saturn.datastructures.singlylinkedlist;

public class Node<T> {

    T value;
    Node<T> next;

    Node() {
        next = null;
    }

    Node(T value) {
        this.value = value;
        next = null;
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
