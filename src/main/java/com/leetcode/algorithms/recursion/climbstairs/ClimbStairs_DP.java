package com.leetcode.algorithms.recursion.climbstairs;

public class ClimbStairs_DP {

    /*
    Complexity Analysis
    Time complexity : O(n). Single loop upto n.
    Space complexity : O(n). dpdp array of size n is used.
     */

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        ClimbStairs_DP pt = new ClimbStairs_DP();
        System.out.println(pt.climbStairs(3));
        System.out.println(pt.climbStairs(4));
    }

}
