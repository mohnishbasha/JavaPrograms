package com.algorithms.book.eopij.ch05;


/**
 * Elements of Java Interview
 * Chapter 05, Page 55, 5.8
 *
 */

public class ReverseDigits {

    public static long reverse(int x) {
        long result = 0;
        long xx = Math.abs(x);

        while( xx != 0) {
            result = result * 10 +  xx %10;
            xx /= 10;
        }
        return  x < 0? -result: result;
    }

    public static void main (String args[]) {

        System.out.println("1230: " + reverse(1230));
        System.out.println("3451: " + reverse(3451));
        System.out.println("-1230: " + reverse(-1230));
        System.out.println("-3451: " + reverse(-3451));
    }
}
