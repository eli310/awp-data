package com.coine.client;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lihailong
 * @version 2017/11/23
 * @since 1.0
 */
public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        T element;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(T element) {
        Node oldLast = last;
        last = new Node();
        last.element = element;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T element = first.element;
        first = first.next;
        n--;
        if (isEmpty()) last = null; // to avoid loitering
        return element;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.element;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<T> {

        private Node current;

        public QueueIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T element = current.element;
            current = current.next;
            return element;
        }
    }
}
