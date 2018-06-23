package edu.princeton.cs.algs4;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private Item [] a;
    private int N;
    int first;
    int last;

    public ResizingArrayQueue(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
        first = 0;
        last = 0;
    }

    public void enqueu(Item item){
        if (isFull()) {
            resize(2*a.length);
        }
        a[last] = item;
        last++;
        if (last == a.length) {
            last = 0;
        }
        N++;
    }
    
    public Item dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        }
        Item item = a[first];
        a[first] = null;
        first++;
        if (first == a.length) {
            first = 0;
        }
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
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
            new_arr[i] = a[(first + i) % a.length];
        }
        a = new_arr;
        first = 0;
        last = N;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){
        return new ReverseQueueIterator();
    }

    private class ReverseQueueIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {
            return i < N;
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = a[ (first + i) % a.length ];
            i++;
            return item;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> s;
        s = new ResizingArrayQueue<String>(2);
        while (!StdIn.isEmpty()) {
            String new_item = StdIn.readString();
            if (!new_item.equals("-")) {
                s.enqueu(new_item);
            }else if (!s.isEmpty()) {
                StdOut.println("aaaa " + s.dequeue());
            }
        }

        StdOut.println("(" + s.size() + " left on stack)");

        for (String value : s) {
            StdOut.println(value);
        }

    }
}
