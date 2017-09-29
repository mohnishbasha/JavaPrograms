package com.algorithms.book.eopij.ch05;


/**
 * Elements of Java Interview
 * Chapter 05, Page 51
 *
 */

/*

- Compute X * Y without arithmatic operation
- Multiply 2 non-negative numbers

 */

public class Multiplication {


    public static int mul(int a, int b) {
        return a == 0 ? 0 : (mul(a-1, b) + b);
    }

    // If shifts and mods are allowed, here's a fun one.
    public static int mul1(int a, int b) {
        return a == 0 ? 0 : mul1(a >> 1, b << 1) + (a % 2 == 1 ? b : 0);
    }

    /*
    Given two numbers represented as strings, return multiplication of the numbers as a string.
    https://www.programcreek.com/2014/05/leetcode-multiply-strings-java/

     */

    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length()+num2.length()];

        // multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
