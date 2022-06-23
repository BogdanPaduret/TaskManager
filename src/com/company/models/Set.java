package com.company.models;

import com.company.exceptions.ElementExistsException;

import java.util.Comparator;

public class Set<T extends Comparable<T>> {

    //instance variables
    private Node<T> head = null;
    private Comparator<T> comparator = null;

    //constructor
    public Set() {}
    public Set(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    //create
    public void add(T data) throws ElementExistsException {
        if (!exists(data)) {
            if (head == null) {
                createFirstNode(data);
            } else {
                createNewNode(data);
            }
        } else {
            throw new ElementExistsException();
        }
    }

    //read
    public boolean exists(T data) {
        Node<T> loop = head;
        while (loop != null) {
            if (loop.getData().equals(data)) {
                return true;
            }
            loop = loop.getNext();
        }
        return false;
    }
    public int size() {
        int c = 0;

        Node<T> loop = head;

        while (loop != null) {
            loop = loop.getNext();
            c++;
        }

        return c;
    }
    public String showAll() {
        String string = "";

        Node<T> loop = head;

        while (loop != null) {
            string += loop.getData().toString() + "\n";
            loop = loop.getNext();
        }

        return string;
    }
    public int getIndex(T data) {
        int c = 0;

        Node<T> loop = head;

        while (loop != null) {
            if (loop.getData().equals(data)) {
                return c;
            }
            loop = loop.getNext();
            c++;
        }

        return -1;
    }
    public T getData(int index) throws IndexOutOfBoundsException {
        int c = 0;

        Node<T> loop = head;

        while (loop != null) {
            if (c == index) {
                return loop.getData();
            }
            loop = loop.getNext();
            c++;
        }

        throw new IndexOutOfBoundsException();
    }

    //update
    public void set(int index, T data) throws ElementExistsException {
        if (!exists(data)) {
            remove(index);
            add(data);
        } else {
            throw new ElementExistsException();
        }
    }
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
        Set<T> set = new Set<>(comparator);
        Node<T> loop = head;

    }

    //delete
    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
        } else {
            int c = 0;
            Node<T> loop = head;
            Node<T> previous = head;
            while (loop != null) {
                if (c == index) {
                    previous.setNext(loop.getNext());
                    break;
                }
                loop = loop.getNext();
                c++;
            }
        }
    }

    //helpers
    private void createFirstNode(T data) {
        head = createNode(data);
    }
    private Node<T> createNode(T data) {
        return createNode(data, null);
    }
    private Node<T> createNode(T data, Node<T> next) {
        return new Node<>(data, next);
    }
    private void createNewNode(T data) {
        Node<T> node = createNode(data);
        Node<T> loop = head;
        Node<T> previous = null;
        while (loop != null) {

            int compare = compareDataNode(data, loop);

            if (compare > 0) {
                if (previous == null) {
                    head = node;
                } else {
                    previous.setNext(node);
                }
                node.setNext(loop);
                break;
            }

            previous = loop;
            loop = loop.getNext();
        }
        if (loop == null) {
            previous.setNext(node);
        }
    }
    private int compareDataNode(T data, Node<T> node) {
        if (comparator != null) {
            return comparator.compare(node.getData(), data);
        } else {
            return node.getData().compareTo(data);
        }
    }


}
