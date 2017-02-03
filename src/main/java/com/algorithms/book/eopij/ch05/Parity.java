package com.algorithms.book.eopij.ch05;

/**
 * Elements of Java Interview
 * Chapter 05, Page 46
 *
 */

public class Parity {


    public static short parity(long x) {
        short result = 0;
        while ( x != 0) {
            result ^= (x & 1);
            x >>>= 1; // x = x >>> 1
        }
        return result;
    }

    // another implementation
    public static short parity1(long x) {
        short result = 0;
        while ( x != 0) {
            result ^= 1;
            x &= (x - 1); // drops the lowest set bit of x.
        }
        return result;
    }
}
