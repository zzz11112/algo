package LinkedListTest;

import org.example.LinkedList.DoublyLinkedListSentinel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
public class DoublyLinkedListTest {
    @Test
    @DisplayName("insert")
    public void test1(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,3);
        list.insert(3,4);
        list.loop2(System.out::println);
    }

    @Test
    @DisplayName("remove")
    public void test2(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,3);
        list.insert(3,4);

//        list.remove(4);
        list.remove(0);
        list.loop2(System.out::println);
    }

    @Test
    @DisplayName("remove")
    public void test3(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,3);
        list.insert(3,4);

        list.addLast(5);

        list.addLast(6);
        list.removeLast();
        for(int value:list){
            System.out.println(value);
        }
    }
}
