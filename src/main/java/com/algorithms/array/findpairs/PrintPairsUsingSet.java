package com.algorithms.array.findpairs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

Output:Random Integer array:[0,14,0,4,7,8,3,5,7]
Sum:11
pair of numbers from an array whose sum equals 11
(7,4)(3,8)(7,4)

Random Integer array:[10,9,5,9,0,10,2,10,1,9]
Sum:12
pair of numbers from an array whose sum equals 12
(2,10)

Read more:http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz4M6CH1pNT

 */

/**
 * Java Program to find two elements in an array that sum to k. * * @author WINDOWS 8
 */
public class PrintPairsUsingSet {
    public static void main(String args[]) {
        prettyPrint(getRandomArray(9), 11);
        prettyPrint(getRandomArray(10), 12);
    }

    /**
     * Given an array of integers finds two elements in the array whose sum is equal to n. * @param numbers * @param n
     */
    public static void printPairsUsingSet(int[] numbers, int sum) {
        if (numbers.length < 2) {
            return;
        }
        Set set = new HashSet(numbers.length);
        for (int value : numbers) {
            int target = sum - value;


            // if target number is not in set then add
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }


    /* * Utility method to find two elements in an array that sum to k. */
    public static void prettyPrint(int[] random, int k) {
        System.out.println("Random Integer array : " + Arrays.toString(random));
        System.out.println("Sum : " + k);
        System.out.println("pair of numbers from an array whose sum equals " + k);
        printPairsUsingSet(random, k);
    }

    /**
     * Utility method to return random array of Integers in a range of 0 to 15
     */
    public static int[] getRandomArray(int length) {
        int[] randoms = new int[length];
        for (int i = 0; i < length; i++) {
            randoms[i] = (int) (Math.random() * 15);
        }
        return randoms;
    }
}
