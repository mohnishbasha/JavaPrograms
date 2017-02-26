package com.algorithms.book.eopij.ch05;


/**
 * Elements of Java Interview
 * Chapter 05, Page 45
 *
 * Complexity O(n)
 */

/*

7 = 0111

numbits = 0
111 & 001 = 1, numbits = 1
x>>>1
011 & 001 = 1, numbits = 2

 */

/**
 * Count Number of bits in a binary representation of a number.
  */

public class CountBits {

    public static short countBits(int x) {

        short numBits = 0;
        while ( x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    public static void main (String args[]) {

        System.out.println("Bits in 0: " + countBits(0));
        System.out.println("Bits in 1: " + countBits(1));
        System.out.println("Bits in 2: " + countBits(2));
        System.out.println("Bits in 3: " + countBits(3));
        System.out.println("Bits in 4: " + countBits(4));

        System.out.println("Bits in 5: " + countBits(5));
        System.out.println("Bits in 6: " + countBits(6));
        System.out.println("Bits in 7: " + countBits(7));
        System.out.println("Bits in 8: " + countBits(8));
        System.out.println("Bits in 9: " + countBits(9));
        System.out.println("Bits in 10: " + countBits(10));

    }

}
