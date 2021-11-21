package learn.array;

import java.util.Arrays;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] arr = {76, 105, 105, 75, 90, 90};
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }

    /*
    Write a function that takes in an array of positive integers and returns the maximum sum of non-adjacent elements in the array.
    If the input array is empty, the function should return 0.
    Example:
    arr = [75, 105, 120, 75, 90, 135]
    Output: 330 = 75 + 120 + 135
     */
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        for(int i=2; i<array.length; i++) {
            int current = Math.max(first, second+array[i]);
            second = first;
            first = current;
        }
        return first;
    }
}
