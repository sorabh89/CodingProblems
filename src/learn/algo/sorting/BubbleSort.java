package learn.algo.sorting;

import com.util.ArraysUtil;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    //Best: O(n) time | O(1) space
    //Average & Worst: O(n^2) time | O(1) space
    public static int[] bubbleSort(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for(int i=0; i< array.length -1 -counter; i++) {
                if(array[i]>array[i+1]) {
                    ArraysUtil.swap(array, i, i+1);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

}
