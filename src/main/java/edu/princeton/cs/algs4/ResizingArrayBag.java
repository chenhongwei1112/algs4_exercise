package edu.princeton.cs.algs4;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayBag<Item> implements Iterable<Item>{
    private Item [] a;
    private int N;

    public ResizingArrayBag(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public void addItem(Item item){
        if (isFull()) {
            resize(2*a.length);
        }
        a[N++] = item;
    }
    
    public boolean isEmpty(){
        return N == 0;
    }

    public boolean isFull(){
        return N == a.length;
    }

    public void resize(int capacity){
        assert capacity >= N;
        Item[] new_arr = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            new_arr[i] = a[i];
        }
        a = new_arr;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){
        return new ResizingArrayBagIterator();
    }

    private class ResizingArrayBagIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {
            return i < N;
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return a[i++];
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayBag<Integer> s;
        s = new ResizingArrayBag<Integer>(2);
        while (!StdIn.isEmpty()) {
            Integer new_item = StdIn.readInt();
            s.addItem(new_item);
        }

        int sum = 0;
        for (int value : s) {
            sum = sum + value;
        }
        StdOut.println("AAAAAAAAAAA " + sum);
    }
}
