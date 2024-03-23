package algorithm.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.algorithm.recursion.BubbleSort.newBubble;
import static org.example.algorithm.recursion.BubbleSort.sort;

public class BubbleSortTest {
    @Test
    public void test(){
        int[] a={4,7,6,2,3,1,5};
        int[] b={1,2,3,4,5,6,7};
        //sort(a);
        newBubble(a,a.length-1);
        Assertions.assertEquals(Arrays.toString(a),Arrays.toString(b));
        System.out.println(Arrays.toString(a));
    }
}
