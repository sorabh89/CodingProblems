package learn.algo.sorting;

import com.util.ArraysUtil;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    //All Cases: O(n^2) time | O(1) space
    public static int[] selectionSort(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        int startIdx = 0;
        while(startIdx<array.length-1) {
            int smallIdx = startIdx;
            for(int i = startIdx+1; i<array.length; i++) {
                if(array[smallIdx] > array[i]) {
                    smallIdx = i;
                }
            }
            ArraysUtil.swap(array, startIdx, smallIdx);
            startIdx++;
        }
        return array;
    }
}
