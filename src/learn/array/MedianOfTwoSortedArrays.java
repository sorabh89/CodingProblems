package learn.array;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args)
    {
        int arr1[] = { 1,2,3,4,5,6 };
        int arr2[] = { 6,7,8,9,10 };

        System.out.println(findMedianOfTwoSortedArrays(arr1, arr2));
    }

    static double findMedianOfTwoSortedArrays(int arr1[], int arr2[]) {
        if (arr1.length > arr2.length) {
            return findMedianOfTwoSortedArrays(arr2, arr1);
        }

        int low = 0;
        int high = arr1.length;

        while (low <= high) {
            int arr1Part = (low + high)/2;
            int arr2Part = (arr1.length + arr2.length + 1)/2 - arr1Part;

            int maxLeftArr1 = (arr1Part == 0)? Integer.MIN_VALUE : arr1[arr1Part-1];
            int minRightArr1 = (arr1Part == arr1.length)? Integer.MAX_VALUE : arr1[arr1Part];

            int maxLeftArr2 = (arr2Part == 0)? Integer.MIN_VALUE : arr2[arr2Part-1];
            int minRightArr2 = (arr2Part == arr2.length)? Integer.MAX_VALUE : arr2[arr2Part];

            if(maxLeftArr1 <= minRightArr2 && maxLeftArr2 <= minRightArr1) {
                if((arr1.length+arr2.length)%2 == 0) {
                    return ((double)Math.max(maxLeftArr1, maxLeftArr2) + Math.min(minRightArr1, minRightArr2))/2;
                } else {
                    return (double)Math.max(maxLeftArr1, maxLeftArr2);
                }
            } else if(maxLeftArr1 > minRightArr2) {
                high = arr1Part - 1;
            } else {
                low = arr1Part +1;
            }
        }
        throw new RuntimeException("Arrays are not Sorted");
    }

}
