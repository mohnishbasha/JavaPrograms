package com.leetcode.algorithms.recursion.pascalstriangle;

import java.util.ArrayList;
import java.util.List;


/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]


Follow up:
Could you optimize your algorithm to use only O(k) extra space?


f(i,j) = f(i-1, j-1) + f(i-1, j)

f(i,j) = 1 where j=i or j=1

 */


/*

Time Complexity: O(2^k)
Space complexity : O(k) + O(k)

 */

public class PascalsTriangleRecursion {


    private int getNum(int i, int j) {
        if (i == 0 || j == 0 || i == j) {
            return 1;
        }

        return getNum(i - 1, j - 1) + getNum(i - 1, j);
    }

    private List<Integer> getPascalsRow(int rowIndex) {

        // results array
        List<Integer> results = new ArrayList<>();

        // iterate from 0 to rowIndex
        for (int i = 0; i <= rowIndex; i++) {
            results.add(getNum(rowIndex, i));
        }

        return results;
    }

    public static void main(String[] args) {

        PascalsTriangleRecursion pt = new PascalsTriangleRecursion();
        System.out.println(pt.getPascalsRow(3));
        System.out.println(pt.getPascalsRow(4));

    }

}
