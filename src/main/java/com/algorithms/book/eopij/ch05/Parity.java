package com.algorithms.book.eopij.ch05;

/**
 * Elements of Java Interview
 * Chapter 05, Page 46
 *
 */

public class Parity {


    public static short parity(long x) {
        short res = 0;
        while ( x != 0) {
            res ^= (x & 1);
            x >>>= 1; // x = x >>> 1
        }
        return res;
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
