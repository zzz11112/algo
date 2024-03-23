package org.example.algorithm.recursion;
//反向打印字符串
public class ReversePrintString {

    public static void reverse(int index,String str){
        if(index == str.length()){
            return;
        }
        reverse(index+1,str);
        System.out.println(str.charAt(index));
    }

    public static void reverse2(int index,String str){
        if(index == -1){
            return;
        }
        System.out.println(str.charAt(index));
        reverse2(index-1,str);
    }


    public static void main(String args[]){
        reverse(0,"abcde");
        reverse2(4,"fghij");
    }
}
