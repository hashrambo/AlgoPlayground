package DP;

import java.util.HashMap;

/**
 * Created by hashrambo on 3/27/17.
 *
 * There are n types of coins, each with a value of v_(1...n).
 * Given an amount sum S. Find the total number of possible ways
 * that the coins could sum up to amount S.
 *
 * Suppose an array of size n represents the coins.
 * The value of each element is equivalent to the coin's value.
 */
public class CoinChange {

    /**
     * A recursive solution to find the number of ways for coin change.
     * @param coins
     * @param index
     * @param sum
     * @return
     */
    private static long findWays (long [] coins, int index, long sum) {

        if (index >= coins.length)
            return 0;
        if (sum == 0)
            return 1;

        long ways = 0;
        long coinsAmount = 0;

        while (coinsAmount <= sum) {

            long remain = sum - coinsAmount;
            ways += findWays(coins, index+1, remain);
            coinsAmount += coins[index];
        }

        return ways;
    }


    /**
     * Applied the technique of using memoization to store the found number of ways.
     * @param coins
     * @param index
     * @param sum
     * @param memo
     * @return
     */
    private static long dpFindWays (long [] coins, int index, long sum, HashMap<String, Long> memo) {

        if (index >= coins.length)
            return 0;
        if (sum == 0)
            return 1;

        long ways = 0;
        long coinsAmount = 0;
        String key = sum + "-" + index;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        while (coinsAmount <= sum) {
            long remain = sum - coinsAmount;
            ways += dpFindWays(coins, index + 1, remain, memo);
            coinsAmount += coins[index];
            memo.put(key, ways);
        }

        return ways;
    }


    public static void main (String[] args) {
        long [] coins = new long[]{25, 10, 5, 1};
        long ways = findWays(coins, 0, 25);
        System.out.println(ways); //4


        HashMap<String, Long> memo = new HashMap<String, Long>();
        long dpWays = dpFindWays(coins, 0, 25, memo);
        System.out.println(dpWays); //4

        // TODO: This program might not have taken care of the edge cases.
        // e.g. if sum is 1, it returns 0. But it supposed to be 1 way.

    }
}
