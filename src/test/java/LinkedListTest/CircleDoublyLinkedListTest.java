package LinkedListTest;
import org.example.LinkedList.CircleDoublyLinkedListSentinel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CircleDoublyLinkedListTest {
    @Test
    @DisplayName("addFirst")
    public void addFirst(){
        CircleDoublyLinkedListSentinel list = new CircleDoublyLinkedListSentinel();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        for (int value :
                list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("addLast")
    public void addLast(){
        CircleDoublyLinkedListSentinel list = new CircleDoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (int value :
                list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("removeFirst")
    public void removeFirst(){
        CircleDoublyLinkedListSentinel list = new CircleDoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (int value :
                list) {
            System.out.println(value);
        }
    }
}
