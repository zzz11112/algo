package org.example.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;//逻辑大小
    private int capacity = 8;//容量
    private int[] array = {};//懒惰初始化思想


    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 向对应index插入元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        //容量检查
        checkAndGrow();
        //TODO 实现index合规检查
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 容量检查，当容量不足时扩容1.5倍
     */
    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //进行扩容 java中扩容1.5倍
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 获取index处array值
     *
     * @param index
     * @return array[index]
     */
    public int get(int index) {
        return array[index];
    }

     /**
     * 移除指定index元素
     * @param index
     * @return array[index]
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }


    /**
     * 遍历方法1
     *
     * @param consumer-遍历要执行的操作，入参：每个元素
     */
    public void for_each(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * Iterator实现迭代
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        //TODO 匿名内部类？
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {//有无下一个元素
                return i < size;
            }

            @Override
            public Integer next() {//返回当前元素并移动到那个元素
                return array[i++];
            }
        };
    }

    /**
     * 流式输出
     *
     * @return IntStream.of()
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}

//插入或删除性能
//头部位置 O(n)
//中间位置 O(n)
//尾部位置 O(1)
