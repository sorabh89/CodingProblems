package learn.array;

import java.util.Arrays;

public class WarmerTemperature {

    //https://leetcode.com/problems/daily-temperatures/
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(temperatures));
        System.out.println(Arrays.toString(dailyTemperatures1(temperatures)));
    }

    //With Time Complexity O(n2) and space complexity O(n)
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int day = 0; day < n; day++) {
            for (int futureDay = day + 1; futureDay < n; futureDay++) {
                if (temperatures[futureDay] > temperatures[day]) {
                    answer[day] = futureDay - day;
                    break;
                }
            }
        }

        return answer;
    }

    //With Time Complexity O(n) and space complexity O(1)
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }

        return answer;
    }

}
