package learn.array;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int tot = 20;
        int[] denoms = {1, 2, 5, 10};
        System.out.println(numberOfWaysToMakeChange(tot, denoms));
    }

    /*
    Given an array of distinct positive integers representing coin denominations and a single non-negative integer n representing a target amount of
    money, write a function that returns the number of ways to make change for that target amount using the given coin denominations.
    Note that an unlimited amount of coins is at your disposal.
    Example:
    n = 6
    denoms = [1, 5]
    Output: 2  1x1 + 1x5 and 6x1
     */
    public static int numberOfWaysToMakeChange(int tot, int[] denoms) {
        int[] ways = new int[tot+1];
        ways[0]=1;
        for(int denom: denoms) {
            for(int amt = 1; amt < tot+1; amt++) {
                if(denom<=amt) {
                    ways[amt] += ways[amt-denom];
                }
            }
        }
        return ways[tot];
    }
}
