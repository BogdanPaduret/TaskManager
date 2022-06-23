package com.company.models;

public class Node<T> {

    //instance variables
    private T data;
    private Node<T> next;

    //constructors
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    //getter+setter
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }

    //override methods
    @Override
    public boolean equals(Object o) {
        Node<T> node = (Node<T>) o;

        return this.getData().equals(node.getData()) &&
                this.getNext().equals(node.getNext());
    }

    @Override
    public String toString() {
        String string = "";

        string += "Data: " + getData().toString() + "\n";
        string += "Next: ";
        if (getNext() != null) {
            string += getNext().getData().toString();
        } else {
            string += " NULL!";
        }

        return string;
    }
}
