package com.coine.basic;

import java.util.Iterator;

/**
 * @author lihailong
 * @version 2017/11/23
 * @since 1.0
 */
public class FixedCapacityStack<T> implements Iterable<T> {

    private T[] items;
    private int n;

    public FixedCapacityStack(int cap) {
        items = (T[]) new Object[cap];
    }

    public int capacity() {
        return items.length;
    }

    public void push(T t) {
        items[n++] = t;
    }

    public T pop() {
        T t = items[--n];
        items[n] = null;
        return t;
    }

    public int size() {
        return n;
    }

    public boolean isFull() {
        return n == items.length;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
