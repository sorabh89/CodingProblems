package learn.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String str = "abcdeafbdgcbb";
        System.out.println(lengthOfLongestSubstringSol(str));
        System.out.println(lengthOfLongestSubstring(str));
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstringSol(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {   // i,j are for the start and end index of substring
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);    // starting index to be the max of current max or new max after the duplicate character
            }
            ans = Math.max(ans, j - i + 1);         // max od previous max (ans) or (end-start+1)
            map.put(s.charAt(j), j + 1);            // index +1, +1 is the index from where the start needs to be taken after the duplicate character
        }
        return ans;
    }

}
