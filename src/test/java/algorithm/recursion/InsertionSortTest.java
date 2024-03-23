package algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.algorithm.recursion.InsertionSort.newInsertion;
import static org.example.algorithm.recursion.InsertionSort.sort;

public class InsertionSortTest {
    @Test
    public void test(){
        int[] a={2,3,5,4,6,1,7};
        sort(a);
        System.out.println(Arrays.toString(a));
        int[] b={1,2,4,3,5,6,8,7,9};
        newInsertion(b,2,7);
        System.out.println(Arrays.toString(b));
    }
}
