package learn.string;

import java.util.Arrays;

public class LongestSubStringPalindrome {

    public static void main(String[] args) {
//        String str = "abacabadef";
//        System.out.println(longestPalindromeSlow(str));

        String text = "abacabadef";
        findLongestPalindromicString(text);

        text = "babcbabcbaccba";
        findLongestPalindromicString(text);

        text = "abaaba";
        findLongestPalindromicString(text);

        text = "abababa";
        findLongestPalindromicString(text);

        text = "abcbabcbabcba";
        findLongestPalindromicString(text);

        text = "forgeeksskeegfor";
        findLongestPalindromicString(text);

        text = "caba";
        findLongestPalindromicString(text);

        text = "abacdfgdcaba";
        findLongestPalindromicString(text);

        text = "abacdfgdcabba";
        findLongestPalindromicString(text);

        text = "abacdedcaba";
        findLongestPalindromicString(text);
    }

    static void findLongestPalindromicString(String text)
    {
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++)
        {

            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if match then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2))))
            {
                L[i]++;
            }

            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R)
            {
                C = i;
                R = i + L[i];
            }

            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        System.out.printf("LPS of string is %s : ", text);
        for (i = start; i <= end; i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }

    public static int longestPalindromeSlow(String s) {
        String newStr = "|";
        for (char c : s.toCharArray()) {
            newStr += c + "|";
        }
        System.out.println(newStr);
        System.out.println(Arrays.toString(newStr.toCharArray()));
        int[] palindromeRadii = new int[newStr.length()];
        System.out.println(Arrays.toString(palindromeRadii));

        int center = 0;
        while (center < newStr.length()) {
        // Determine the longest palindrome starting at Center-Radius and going to Center+Radius
        int radius = 0;
        while (center-(radius+1) >= 0 && center+(radius+1) < newStr.length() && newStr.charAt(center-radius+1) == newStr.charAt(center+radius+1)) {
            radius = radius+1;
        }

            // Save the radius of the longest palindrome in the array
            palindromeRadii[center] = radius;
            center = center+1;
        }

        System.out.println(Arrays.toString(palindromeRadii));

        int max = 1;
        for(int i: palindromeRadii) {
            if(i>max) {
                max = i;
            }
        }

        int longestPalindromeInStr = (2*max)+1;
        int longestPalindromeInStrOrg = (longestPalindromeInStr-1)/2;
        return longestPalindromeInStrOrg;
    }
}
