import org.example.DynamicArray.DynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class DynamicArrayTest {
    @Test
    @DisplayName("动态数组遍历方法")
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(2, 5);

        //TODO lambda?
        /*dynamicArray.for_each((element)->{
            System.out.println(element);
        });*/

        //增强for循环，自动调用hasNext()和Next()方法
        /*for (Integer element : dynamicArray) {
            System.out.println(element);
        }*/

        //TODO 流式输出?
        dynamicArray.stream().forEach(element -> {
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("动态数组删除元素")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(3);
        assertEquals(4, removed);

        assertIterableEquals(List.of(1, 2, 3, 5), dynamicArray);
        dynamicArray.stream().forEach(element -> {
            System.out.println(element);
        });

    }

    @Test
    @DisplayName("动态数组容量扩容")
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 11; i++) {
            dynamicArray.addLast(i);
        }
        dynamicArray.for_each(element -> {
            System.out.println(element);
        });
    }
}
