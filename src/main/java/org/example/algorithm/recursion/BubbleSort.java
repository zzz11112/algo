package org.example.algorithm.recursion;

import java.util.Arrays;

public class BubbleSort {
    //right为未排序区域右边界
    private static void bubble(int[] a, int right) {
        if(right==0){
            return;
        }
        for (int i = 0; i < right; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        bubble(a,right-1);
    }

    /**
     * 添加x作为未排序区右边界，若遇到未排序区有部分数据已有序，right-1会导致增加复杂度
     * @param a
     * @param right
     */
    public static void newBubble(int[] a,int right){
        if(right==0){
            return;
        }
        int x=0;
        for (int i = 0; i < right; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                x = i;//实际右边界
            }
        }
        bubble(a,x);
    }
    public static void sort(int[] a){
        bubble(a,a.length-1);
    }


}
