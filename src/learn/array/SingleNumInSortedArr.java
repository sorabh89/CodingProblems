package learn.array;

import java.util.Arrays;

public class SingleNumInSortedArr {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(arr));
        System.out.println(singleNonDuplicate(arr));
    }

    /*
    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
    Return the single element that appears only once.
    Your solution must run in O(log n) time and O(1) space.
    */
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
