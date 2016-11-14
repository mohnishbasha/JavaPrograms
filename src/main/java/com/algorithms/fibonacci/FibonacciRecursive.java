package com.algorithms.fibonacci;

import javax.swing.JOptionPane;
 
 /*
    This program computes Fibonacci numbers using a recursive
    method.
  */ 
 public class FibonacciRecursive
{  
    public static void main(String[] args)
    {  
       String input = JOptionPane.showInputDialog("Enter n: ");
       int n = Integer.parseInt(input);
 
       for (int i = 0; i < n; i++)
       {
          int f = fib(i);
          System.out.println("fib(" + i + ") = " + f);
       }
       System.exit(0);
       
    }
 
    /**
       Computes a Fibonacci number.
       @param n an integer
       @return the nth Fibonacci number
    */
    public static int fib(int n)
    {  
       if (n <= 1)
            return n;
       else 
            return fib(n - 1) + fib(n - 2);
    } 
 }
