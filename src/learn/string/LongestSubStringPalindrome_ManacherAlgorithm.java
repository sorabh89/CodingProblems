package learn.string;

public class LongestSubStringPalindrome_ManacherAlgorithm {

    public static void main(String[] args) {
        String str = "abaczcabadef";
        System.out.println(longestPalindromicSubstring(str));
    }

    public static String longestPalindromicSubstring(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        // arr represents input string in a way that will act the same for strings of even and uneven length
        // i.e. '#' is placed between each letter from input
        char[] arr = new char[2 * str.length() + 1];
        for (int i = str.length() - 1; i >= 0; i--) {
            arr[2 * i + 1] = str.charAt(i);
            arr[2 * i] = '#';
        }
        arr[2 * str.length()] = '#';

        // LPS[i] - palindrome span(radius) with center at arr[i]
        int[] longestPalindromeArr = new int[arr.length];
        int p = 0;
        for (int i = 1; i <= arr.length-1; i++) {
            longestPalindromeArr[i] = 0;
            if (longestPalindromeArr[p] + p >= i) {
                longestPalindromeArr[i] = Math.min(longestPalindromeArr[2 * p - i], p + longestPalindromeArr[p] - i);
            }
            while (i + longestPalindromeArr[i] + 1 <= arr.length-1 && i - longestPalindromeArr[i] - 1 >= 0
                    && arr[i + longestPalindromeArr[i] + 1] == arr[i - longestPalindromeArr[i] - 1]) {
                longestPalindromeArr[i]++;
            }
            if (p + longestPalindromeArr[p] < i + longestPalindromeArr[i]) {
                p = i;
            }
        }

        // find the palindrome with the biggest span
        int valueMax = 0;
        int indexMax = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (valueMax < longestPalindromeArr[i]) {
                valueMax = longestPalindromeArr[i];
                indexMax = i;
            }
        }

        // reconstruct the palindrome given its index in LPS and span
        final int palindromeSpan = valueMax / 2;
        if (indexMax % 2 == 0) {
            return str.substring(indexMax/2  - palindromeSpan, indexMax/2 + palindromeSpan);
        } else {
            return str.substring(indexMax/2  - palindromeSpan, indexMax/2 + palindromeSpan + 1);
        }
    }
}
