package com.coine.basic;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author lihailong
 * @version 2017/11/23
 * @since 4-0-
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] items = (T[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public void add(T t) {
        if (n == items.length) resize(2 * items.length);
        items[n++] = t;
    }

    public T pop() {
        T t = items[--n];
        items[n] = null;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return t;
    }

    private void resize(int newSize) {
        items = Arrays.copyOf(items, newSize);
    }
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
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
