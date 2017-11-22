package com.coine.basic;

import com.coine.util.StdIn;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author lihailong
 * @version 2017/11/22
 * @since 1.0
 */
public class Bag<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int n;

    public Bag() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        if (n == items.length) resize(2 * items.length);
        items[n++] = item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int newSize) {
        items = Arrays.copyOf(items, newSize);
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }
    }
}
