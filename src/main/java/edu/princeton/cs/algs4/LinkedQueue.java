package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedQueue(){
        N = 0;
        first = null;
        last = null;
    }

    public void enqueue(Item item){
        Node new_node = new Node();
        new_node.item = item;
        if (last != null) {
            last.next = new_node;
        }else{
            first = new_node;
        }
        last = new_node;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
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
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {
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
        LinkedQueue<String> s;
        s = new LinkedQueue<String>();
        while (!StdIn.isEmpty()) {
            String new_item = StdIn.readString();
            if (!new_item.equals("-")) {
                s.enqueue(new_item);
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
