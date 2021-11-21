package learn.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    //https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        int i=0;

        for(int val: nums) {
            int rem = target - val;
            if(map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(val, i);
            i++;
        }
        return new int[]{};

    }
}
