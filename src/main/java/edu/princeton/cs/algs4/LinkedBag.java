package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements Iterable<Item>{
    private int N;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedBag(){
        N = 0;
        first = null;
    }

    public void addItem(Item item){
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        N++;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator(){
        return new LinkedBagIterator();
    }

    private class LinkedBagIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        LinkedBag<Integer> s;
        s = new LinkedBag<Integer>();
        while (!StdIn.isEmpty()) {
            Integer new_item = StdIn.readInt();
            s.addItem(new_item);
        }

        int sum = 0;
        for (Integer value : s) {
            sum = sum + value;
        }
        StdOut.println("AAAAAAAAAA " + sum);

    }
}
