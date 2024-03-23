package org.example.algorithm.recursion;

public class E03BinarySearch {
    public static int search(int[] a,int target){
        return reverse(a,target,0,a.length-1);

    }

    private static int reverse(int[] arr,int target,int i,int j){
        if(i>j){
            return -1;
        }
        int mid = (i+j)>>>1;
        if (target<arr[mid]) {
            return reverse(arr,target,i,mid-1);
        } else if (arr[mid]<target) {
            return reverse(arr,target,mid+1,j);
        }else{
            return mid;
        }
    }
}
