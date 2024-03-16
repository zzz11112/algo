package org.example.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;
            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer=pointer.next;
                return value;
            }
        };
    }

    static class Node {
        Node prev;//上一个结点指针
        int value;//值
        Node next;//下一个结点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头烧饼
    private Node tail;//尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node pointer = head; pointer != tail; pointer = pointer.next, i++) {
            if(i==index){
                return pointer;
            }
        }
        return null;
    }

    public void insert(int index,int value){
        Node prev = findNode(index-1);
        if(prev==null){
            throw IllegalIndexException(index);
        }
        Node next=prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next=inserted;
        next.prev=inserted;
    }

    public void addFirst(int value){
        insert(0,value);
    }

    public void remove(int index){
        Node prev = findNode(index-1);
        if(prev==null){
            throw IllegalIndexException(index);
        }
        Node removed = prev.next;
        //findNode方法找不到tail节点，但prev.next可以
        if(removed==tail){
            throw IllegalIndexException(index);
        }
        Node next = removed.next;
        prev.next=next;
        next.prev=prev;
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next=added;
        tail.prev=added;
    }

    public void removeLast(){
        Node removed = tail.prev;
        if(removed==head){
            throw IllegalIndexException(0);
        }
        Node prev = removed.prev;
        prev.next=tail;
        tail.prev=prev;
    }

    private IllegalArgumentException IllegalIndexException(int index) {
        return new IllegalArgumentException(String.format("index[%d] is illegal",index));
    }

    /**
     * for循环实现
     *
     * @param consumer
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != tail; p = p.next) {
            consumer.accept(p.value);
        }
    }
}
