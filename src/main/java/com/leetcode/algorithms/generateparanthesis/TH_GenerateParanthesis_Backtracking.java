package com.leetcode.algorithms.generateparanthesis;

/*
https://algorithms.tutorialhorizon.com/generate-all-valid-parenthesis-strings-of-length-2n-of-given-n/



 */
public class TH_GenerateParanthesis_Backtracking {

    public static void Validparentheses(int openP, int closeP, String string) {
        if (openP == 0 && closeP == 0) // mean all opening and closing in
            // string,
            // print it
            System.out.println(string);
        if (openP > closeP) // means closing parentheses is more than open ones
            return;
        if (openP > 0)
            Validparentheses(openP - 1, closeP, string + "("); // put ( and
        // reduce
        // the count by
        // 1
        if (closeP > 0)
            Validparentheses(openP, closeP - 1, string + ")"); // put ) and
        // reduce
        // the count by
        // 1
    }

    public static void printParentheses(int n) {
        Validparentheses(n / 2, n / 2, "");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 6;
        printParentheses(n);
    }

}
