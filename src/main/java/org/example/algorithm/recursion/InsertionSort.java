package org.example.algorithm.recursion;

//插入排序
public class InsertionSort {
    //low  未排序区的最左值
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        //a[0]作为已排序区
        int temp = a[low];
        int i = low - 1;//已排序区指针

        while (i>=0&&a[i] > temp) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = temp;
        insertion(a, low + 1);
    }

    //对于数组某段区间[low,high]排序
    public static void newInsertion(int[] a,int low,int high){
        if(low>=high){
            return;
        }
        int left = low+1;
        int temp=a[left];
        int i = left-1;
        while(a[i]>temp){
            a[i+1]=a[i];
            i--;
        }
        a[i+1]=temp;
        newInsertion(a,low+2,high);
    }

    public static void sort(int[] a){
        insertion(a,1);
    }


}
