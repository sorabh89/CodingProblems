package learn.algo.sorting;

import com.util.ArraysUtil;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    //Best: O(n) time | O(1) space
    //Average & Worst: O(n^2) time | O(1) space
    public static int[] insertionSort(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        for (int i=1; i< array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                ArraysUtil.swap(array, j, j-1);
                j -= 1;
            }
        }
        return array;
    }
}
