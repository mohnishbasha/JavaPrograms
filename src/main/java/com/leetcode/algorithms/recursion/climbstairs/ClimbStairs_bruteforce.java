package com.leetcode.algorithms.recursion.climbstairs;

/*

https://leetcode.com/explore/featured/card/recursion-i/255/recursion-memoization/1662/

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

-------
Example 1:
Input: 2
Output: 2

Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

-------

Example 2:
Input: 3
Output: 3

Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


 */


public class ClimbStairs_bruteforce {

    /*
    Algorithm
    In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step.
    At every step we are calling the function climbStairsclimbStairs for step 11 and 22, and return the sum of returned
    values of both functions.

    climbStairs(i,n) = (i + 1, n) + climbStairs(i + 2, n)

    where i defines the current step
    n defines the destination step.
     */

    /*

    Time complexity : O(2^n).
    Space complexity : O(n).
    The depth of the recursion tree can go upto n.

    Size of recursion tree will be 2^n
     */

    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public static void main(String[] args)
    {
        ClimbStairs_bruteforce pt = new ClimbStairs_bruteforce();
        System.out.println(pt.climbStairs(3));
        System.out.println(pt.climbStairs(4));
    }
}
