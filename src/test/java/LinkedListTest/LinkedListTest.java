package LinkedListTest;

import org.example.LinkedList.SingleLinkedList;
import org.example.LinkedList.SingleLinkedListSentinel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkedListTest {

    @Test
    @DisplayName("addFirst && loop")
    public void test1(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);

        //语句lambda
        singleLinkedList.loop1(value->{
            System.out.println(value);
        });

        //表达式lambda
        singleLinkedList.loop2(System.out::println);
    }

    @Test
    @DisplayName("迭代器遍历")
    public void test2(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);

        for(Integer value:singleLinkedList){
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("尾部插入")
    public void test3(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);

        Assertions.assertIterableEquals(List.of(1,2,3,4),singleLinkedList);
    }

    @Test
    @DisplayName("返回对应节点索引的值")
    public void test4(){
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.addFirst(5);

        System.out.println(singleLinkedList.get(4));
    }

    @Test
    @DisplayName("测试insert")
    public void test5(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);

        singleLinkedList.insert(2,5);
        for(Integer integer:singleLinkedList){
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("remove方法")
    public void test6(){
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.removeFirst();
        singleLinkedList.remove(2);
        for(Integer value:singleLinkedList){
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("带哨兵的链表")
    public void test7(){
        SingleLinkedListSentinel singleLinkedListSentinel=new SingleLinkedListSentinel();
        singleLinkedListSentinel.addLast(1);
        singleLinkedListSentinel.addLast(2);
        singleLinkedListSentinel.addLast(3);
        singleLinkedListSentinel.addLast(4);
        Assertions.assertIterableEquals(List.of(1,2,3,4),singleLinkedListSentinel);

        Assertions.assertEquals(3,singleLinkedListSentinel.get(2));
        Assertions.assertThrows(IllegalArgumentException.class,()-> singleLinkedListSentinel.get(10));
    }
}
