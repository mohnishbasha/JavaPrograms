package com.algorithms.fibonacci;

/*
http://www.geeksforgeeks.org/dynamic-programming-set-1/

 There are following two different ways to store the values so that these values can be reused:
a) Memoization (Top Down)
b) Tabulation (Bottom Up)

a) Memoization (Top Down): The memoized program for a problem is similar to the recursive version with a small
modification that it looks into a lookup table before computing solutions. We initialize a lookup array with all
initial values as NIL. Whenever we need solution to a subproblem, we first look into the lookup table. If the
precomputed value is there then we return that value, otherwise we calculate the value and put the result in lookup
table so that it can be reused later.

Following is the memoized version for nth Fibonacci Number.


 */
public class FibonacciMemoized {

    final int MAX = 100;
    final int NIL = -1;

    int lookup[] = new int[MAX];

    /* Function to initialize NIL values in lookup table */
    void _initialize()
    {
        for (int i = 0; i < MAX; i++)
            lookup[i] = NIL;
    }

    /* function for nth Fibonacci number */
    int fib(int n)
    {
        if (lookup[n] == NIL)
        {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n-1) + fib(n-2);
        }
        return lookup[n];
    }

    public static void main(String[] args)
    {
        FibonacciMemoized f = new FibonacciMemoized();
        int n = 40;
        f._initialize();
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}
