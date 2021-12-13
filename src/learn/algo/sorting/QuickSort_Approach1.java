package learn.algo.sorting;

import com.util.ArraysUtil;

import java.util.Arrays;

public class QuickSort_Approach1 {
    public static void main(String[] args) {
        int[] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    //Best & Average: O(nlog(n)) time | O(nlog(n)) space
    //Worst: O(n^2) time | O(nlog(n)) space
    private static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private static void quickSort(int[] array, int startIdx, int endIdx) {
        if(startIdx >= endIdx) {
            return;
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx+1;
        int rightIdx = endIdx;

        while(leftIdx <= rightIdx) {
            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                ArraysUtil.swap(array, leftIdx, rightIdx);
            }
            if(array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            if(array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        ArraysUtil.swap(array, pivotIdx, rightIdx);

        quickSort(array, startIdx, rightIdx-1);
        quickSort(array, rightIdx+1, endIdx);
    }

}
