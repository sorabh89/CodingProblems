package learn.array;

import java.util.Arrays;

public class SquareSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] out = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int outIndex = nums.length-1;

        while(outIndex>=0) {
            if(nums[start] < 0) {
                int sqrStart = nums[start] * nums[start];
                int sqrEnd = nums[end] * nums[end];
                if(sqrStart>=sqrEnd) {
                    out[outIndex] = sqrStart;
                    start++;
                } else {
                    out[outIndex] = sqrEnd;
                    end--;
                }
            } else {
                out[outIndex] = nums[end] * nums[end];
                end--;
            }
            outIndex--;
        }

        return out;
    }
}
