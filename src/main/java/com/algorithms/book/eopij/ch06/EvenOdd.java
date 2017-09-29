package com.algorithms.book.eopij.ch06;

/**
 * Elements of Java Interview
 * Chapter 06, Page 60
 *
 * Complexity O(n)
 * Space Complexity O(1)
 */


public class EvenOdd {

    public static void evenOdd(int[] A) {

        int even = 0, odd = A.length - 1;

        while(even < odd) {
            if(A[even] %2 == 0) {
                even++;
            } else {
                int temp = A[even];
                A[even] = A[odd];
                A[odd--] = temp;
            }
        }
    }
}
