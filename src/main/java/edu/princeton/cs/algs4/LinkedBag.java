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

    public LinkedBag(int cap){
        N = 0;
        first = null;
    }

    public void push(Item item){
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
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
        LinkedBag<String> s;
        s = new LinkedBag<String>(2);
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
