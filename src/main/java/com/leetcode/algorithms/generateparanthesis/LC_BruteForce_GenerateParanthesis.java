package com.leetcode.algorithms.generateparanthesis;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/articles/generate-parentheses/

Approach 1: Brute Force
Intuition

We can generate all 2^{2n}2
2n
  sequences of '(' and ')' characters. Then, we will check if each one is valid.

Algorithm

To generate all sequences, we use a recursion. All sequences of length n is just '(' plus all sequences of length n-1, and then ')' plus all sequences of length n-1.

To check whether a sequence is valid, we keep track of balance, the net number of opening brackets minus closing brackets. If it falls below zero at any time, or doesn't end in zero, the sequence is invalid - otherwise it is valid.

Complexity Analysis

Time Complexity : O(2^{2n}n)O(2
2n
 n). For each of 2^{2n}2
2n
  sequences, we need to create and validate the sequence, which takes O(n)O(n) work.

Space Complexity : O(2^{2n}n)O(2
2n
 n). Naively, every sequence could be valid. See Approach 3 for development of a tighter asymptotic bound.

 */
public class LC_BruteForce_GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public static void main(String args[]) {
        LC_BruteForce_GenerateParanthesis gp = new LC_BruteForce_GenerateParanthesis();
        System.out.println( gp.generateParenthesis(3));
    }

}
