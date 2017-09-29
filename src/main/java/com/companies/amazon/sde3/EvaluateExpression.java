package com.companies.amazon.sde3;

import java.util.Stack;

/*

Input String:
x + 5 - 3 + x = 6 - 4 + x

Output
x = 2

Logic:
Put numbers in stack without the sign until one encounters =
for number beyond the =, change the sign and put it in the stack

x stack = 1, 1, -1
num stack =  5, -3, -6, 4

 */
public class EvaluateExpression {


    public static void evaluate(String expr) {

        char a[] = expr.toCharArray();
        Stack st = new Stack();



    }
}
