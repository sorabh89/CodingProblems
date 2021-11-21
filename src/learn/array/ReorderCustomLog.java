package learn.array;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderCustomLog {

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        System.out.println(Arrays.toString(logs));
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    //https://leetcode.com/problems/reorder-data-in-log-files/
    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String[] str1Arr = str1.split(" ", 2);
                String[] str2Arr = str2.split(" ", 2);

                boolean isStr1Digit = Character.isDigit(str1Arr[1].charAt(0));
                boolean isStr2Digit = Character.isDigit(str2Arr[1].charAt(0));

                if(isStr1Digit && isStr2Digit) {
                    return 0;
                }
                if(isStr2Digit) {
                    return -1;
                }
                if(isStr1Digit) {
                    return 1;
                }

                int strComp = str1Arr[1].compareTo(str2Arr[1]);
                if(strComp == 0) {
                    return str1.compareTo(str2);
                }
                return strComp;
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}
