package com.algorithms.array.findpairs;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * URL:
 *
 Read more:
 http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz4M6UYu2s2
 */

/*

Output :
input int array : [12, 14, 17, 15, 19, 20, -11]
All pairs in an array of integers whose sum is equal to a given value 9
(-11, 20)
input int array : [2, 4, 7, 5, 9, 10, -1]
All pairs in an array of integers whose sum is equal to a given value 9
(-1, 10)
(2, 7)
(4, 5)

 */

/**
 * Java Program to find all pairs on integer array whose sum is equal to k * * @author WINDOWS 7
 */

public class PrintPairsUsingTwoPointers {
    public static void main(String args[]) {
        prettyPrint(new int[]{12, 14, 17, 15, 19, 20, -11}, 9);
        prettyPrint(new int[]{2, 4, 7, 5, 9, 10, -1}, 9);
    }

    /**
     * Given a number finds two numbers from an array so that the sum is equal to that number k. * @param numbers * @param k
     */
    public static void printPairsUsingTwoPointers(int[] numbers, int k) {
        if (numbers.length < 2) {
            return;
        }
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
                left = left + 1;
                right = right - 1;
            } else if (sum < k) {
                left = left + 1;
            } else if (sum > k) {
                right = right - 1;
            }
        }
    } /* * Utility method to print two elements in an array that sum to k. */

    public static void prettyPrint(int[] random, int k) {
        System.out.println("input int array : " + Arrays.toString(random));
        System.out.println("All pairs in an array of integers whose sum is equal to a given value " + k);
        printPairsUsingTwoPointers(random, k);
    }
}


/*


One more thing, here we are using HashSet but since HashSet in Java internally uses HashMap, it would not make any
difference if use either of those data structure.By the this solution has few constraints, first it would need additional
 space of order O(n) to store numbers in Hashtable or Set, so you need additional space which could be problem if array
 is very large (remember the question we asked before writing solution). For a large array, you need a solution which
 doesn't require additional space, also known as in-place solution. If interviewer will ask you how do you find if
 two values in an array sum to a given value without any additional space, first solution will also not work because
 it's complexity is too high and it would too long to sort a large array. A solution with complexity e.g. O(n), O(logN)
  or O(NLongN) should work though. A more efficient in-place solution would be to sort the array and use two pointers to
   scan through array from both direction i.e. beginning and end. If sum of both the values are equal to given number
   then we output the pair and advance them. If the sum of two numbers is less than k then we increase the left pointer,
   else if the sum is greater than k we decrement the right pointer, until both pointers meet at some part of the array.
   The complexity of this solution would be O(NlogN) due to sorting. Remember to use a in-place sorting algorithm like
   quicksort to sort the array as we don't have additional space. Thankfully, Arrays.sort() method uses a two pivot
   quicksort algorithm to sort array of primitives.

 */