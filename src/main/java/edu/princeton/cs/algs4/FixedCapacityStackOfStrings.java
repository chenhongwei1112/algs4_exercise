package edu.princeton.cs.algs4;

import java.util.Iterator;

public class FixedCapacityStackOfStrings<Item> implements Iterable<Item>{
    private Item [] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public void push(Item item){
        if (isFull()) {
            reSize(2*a.length);
        }
        a[N++] = item; 
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            reSize(a.length/2);
        }
        return item;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean isFull(){
        return N == a.length;
    }

    public void reSize(int max){
        Item[] new_arr = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            new_arr[i] = a[i];
        }
        a = new_arr;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){
        return new FixedCapacityStackOfStringsIterator();
    }

    private class FixedCapacityStackOfStringsIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> s;
        s = new FixedCapacityStackOfStrings<String>(2);
        while (!StdIn.isEmpty()) {
            String new_item = StdIn.readString();
            if (!new_item.equals("-")) {
                s.push(new_item);
            }else if (!s.isEmpty()) {
                StdOut.println("aaaa " + s.pop());
            }
        }

        StdOut.println("(" + s.size() + " left on stack)");

        for (String value : s) {
            StdOut.println(value);
        }

    }
}
