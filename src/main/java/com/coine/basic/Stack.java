package com.coine.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lihailong
 * @version 2017/11/23
 * @since 1.0
 */
public class Stack<T> implements Iterable<T> {
    private Node first;
    private int N;

    private class Node {
        T e;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * Adds the item to this stack;
     * @param t
     */
    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.e = t;
        first.next = oldFirst;
        N++;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T t = first.e;
        first = first.next;
        N--;
        return t;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t);
            sb.append(' ');
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator(first);
    }

    private class StackIterator implements Iterator<T> {
        private Node current = first;

        public StackIterator(Node first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T t = current.e;
            current = current.next;
            return t;
        }
    }
}
