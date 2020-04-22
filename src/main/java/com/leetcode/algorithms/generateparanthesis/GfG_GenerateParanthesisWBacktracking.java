package com.leetcode.algorithms.generateparanthesis;


/*
Deep Dive:
https://sahandsaba.com/interview-question-generating-all-balanced-parentheses.html



https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
Print all combinations of balanced parentheses
Write a function to generate all possible n pairs of balanced parentheses.
Examples:

Input : n=1
Output: {}

Input : n=2
Output:
{}{}
{{}}
Algorithm:
Keep track of counts of open and close brackets.

Initialize these counts as 0.
Recursively call the _printParenthesis() function until open bracket count is less than the given n.
If open bracket count becomes more than the close bracket count, then put a closing bracket and recursively call for the remaining brackets.
If open bracket count is less than n, then put an opening bracket and call _printParenthesis() for the remaining brackets.

https://leetcode.com/articles/generate-parentheses/

 */

public class GfG_GenerateParanthesisWBacktracking {

    // Function that print all combinations of
    // balanced parentheses
    // open store the count of opening parenthesis
    // close store the count of closing parenthesis
    static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n)
    {
        if(n > 0)
            _printParenthesis(str, 0, n, 0, 0);
        return;
    }

    // driver program
    public static void main (String[] args)
    {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}
