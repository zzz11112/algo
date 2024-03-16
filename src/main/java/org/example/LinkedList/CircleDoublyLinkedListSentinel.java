package org.example.LinkedList;

import java.util.Iterator;

public class CircleDoublyLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = sentinel.next;
            @Override
            public boolean hasNext() {
                return pointer != sentinel;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null,-1,null);

    public CircleDoublyLinkedListSentinel(){
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    public void addFirst(int value){
        Node a = sentinel;
        Node b =sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void addLast(int value){
        Node a = sentinel;
        Node b = sentinel.prev;
        Node added = new Node(b, value, a);
        a.prev = added;
        b.next = added;
    }

    public void removeFirst(){
        Node a = sentinel;
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("哨兵节点不可删除");
        }
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast(){
        Node removed = sentinel.prev;
        if(removed == sentinel){
            throw new IllegalArgumentException("哨兵节点不可删除");
        }
        Node a = sentinel;
        Node b = removed.prev;
        a.prev = b;
        b.next = a;

    }

    private Node findByValue(int value){
        Node pointer = sentinel.next;
        while(pointer != sentinel){
            if(pointer.value == value){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
    public void removeByValue(int value){
        Node removed = findByValue(value);
        if(removed == null){
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    private IllegalArgumentException IllegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d] is illegal",index));
    }

}
