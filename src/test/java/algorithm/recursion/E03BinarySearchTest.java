package algorithm.recursion;

import org.example.algorithm.recursion.E03BinarySearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class E03BinarySearchTest {
    @Test
    @DisplayName("测试binarySearchBasic")
    public void test1(){
        int[] a = {7,13,21,33,45,65,77,89};
        int result = E03BinarySearch.search(a, 13);
        System.out.println("索引为:"+result);
    }
}
