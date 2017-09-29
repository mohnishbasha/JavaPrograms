package com.algorithms.book.eopij.ch05;


/**
 * Elements of Java Interview
 * Chapter 05, Page 55, 5.8
 *
 */

public class ReverseDigits {

    public static long reverse(int x) {
        long res = 0;
        long n = Math.abs(x);

        while( n != 0) {
            long remainder = n % 10;
            res = res * 10 +  remainder;
            n /= 10;
        }
        return  x < 0? -res: res;
    }

    public static void main (String args[]) {

        System.out.println("1230: " + reverse(1230));
        System.out.println("3451: " + reverse(3451));
        System.out.println("-1230: " + reverse(-1230));
        System.out.println("-3451: " + reverse(-3451));
    }
}
