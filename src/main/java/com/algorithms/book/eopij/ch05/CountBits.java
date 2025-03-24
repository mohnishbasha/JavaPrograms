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

    // Let's see how it works with number 7 (binary 0111):

    // Step 1: x = 0111
    //     0111 & 0001 = 0001  (nbits = 1)
    //     x >>>= 1 → 0011

    // Step 2: x = 0011
    //         0011 & 0001 = 0001  (nbits = 2)
    //         x >>>= 1 → 0001

    // Step 3: x = 0001
    //         0001 & 0001 = 0001  (nbits = 3)
    //         x >>>= 1 → 0000

    // Step 4: x = 0000
    //         Exit loop

    public static short countBits(int x) {
        short nbits = 0;                // Counter for 1 bits
        while (x != 0) {               // Continue until all bits are processed
            nbits += (x & 1);          // Add 1 if least significant bit is 1
            x >>>= 1;                  // Unsigned right shift by 1
        }
        return nbits;
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
