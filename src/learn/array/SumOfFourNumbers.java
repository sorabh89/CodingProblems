package learn.array;

import java.util.*;

public class SumOfFourNumbers {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        List<Integer[]> output = fourNumberSum(arr, targetSum);
        for(Integer[] out: output) {
            System.out.println(Arrays.toString(out));
        }
    }

    /*
    Write a function that takes in a non-empty array of distinct integers and an
    integer representing a target sum. The function should find all quadruplets in
    the array that sum up to the target sum and return a two-dimensional array of
    all these quadruplets in no particular order.
    If no four numbers sum up to the target sum, the function should return an
    empty array.

    Example:
    arr = [7, 6, 4, -1, 1, 2]
    targetSum = 16

    Output : [[7, 6, 4, -1], [7, 6, 1, 2]]
    */
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> list = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for(int i = 1; i<array.length-1; i++) {
            for(int j = i+1; j<array.length; j++) {
                if(map.containsKey(targetSum-(array[i]+array[j]))) {
                    List<Integer[]> remainingSumPair = map.get(targetSum-(array[i]+array[j]));
                    for(Integer[] pair: remainingSumPair) {
                        list.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }

            for(int k = 0; k<i; k++) {
                int currentSum = array[i]+array[k];
                List<Integer[]> toAdd;
                if(map.containsKey(currentSum)) {
                    toAdd = map.get(currentSum);
                } else {
                    toAdd = new ArrayList<>();
                }
                toAdd.add(new Integer[]{array[i], array[k]});
                map.put(currentSum, toAdd);
            }
        }
        return list;
    }
}
