package learn.algo.sorting;

import com.util.ArraysUtil;

import java.util.Arrays;

public class QuickSort_Approach2 {
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

    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int array[], int low, int high) {
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= array[high]) {
                i++;
                ArraysUtil.swap(array, i, j);
            }
        }

        ArraysUtil.swap(array, i+1, high);
        return i+1;
    }
}
