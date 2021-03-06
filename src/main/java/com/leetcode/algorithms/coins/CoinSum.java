package com.leetcode.algorithms.coins;

/*
https://leetcode.com/problems/coin-change-2/?tab=Solutions

You are given coins of different denominations and a total amount of money. Write a function to compute the number of
combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1


Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.


Example 3:
Input: amount = 10, coins = [10]
Output: 1

 */

public class CoinSum {


    /*

        Knapsack problem - Java solution with thinking process O(nm) Time and O(m) Space
    This is a classic knapsack problem. Honestly, I'm not good at knapsack problem, it's really tough for me.

    dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
    State transition:

    not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
    using the ith coin, since we can use unlimited same coin, we need to know how many way to make up amount
    j - coins[i] by using first i coins(including ith), which is dp[i][j-coins[i]]

    Initialization: dp[i][0] = 1

    Once you figure out all these, it's easy to write out the code:

    Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], then we can optimize the space by only
    using one-dimension array.


     */

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String args[]) {

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));

        amount = 3;
        int[] coin1 = {2};
        System.out.println(change(amount, coin1));

        amount = 10;
        int[] coin2 = {10};
        System.out.println(change(amount, coin2));


    }
}
