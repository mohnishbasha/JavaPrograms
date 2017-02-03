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

        int nextEven = 0, nextOdd = A.length - 1;

        while(nextEven < nextOdd) {
            if(A[nextEven] %2 == 0) {
                nextEven++;
            } else {
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
    }
}
