package learn.array;

public class IsArrayMonotonic {

    public static void main(String[] args) {
        int[] arr = {2,2,3};
        System.out.println(isMonotonic(arr));
    }

    /*
    An array is monotonic if it is either monotone increasing or monotone decreasing.
    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    Given an integer array nums, return true if the given array is monotonic, or false otherwise.
     */
    public static boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i+1])
                inc = false;
            if (nums[i] < nums[i+1])
                dec = false;
        }

        return inc || dec;
    }
}
