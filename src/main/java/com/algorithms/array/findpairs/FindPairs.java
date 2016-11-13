package com.algorithms.array.findpairs;

/*
Find a pair of elements from an array whose sum equals a given number
Examples: [3, -2, 1, 7, -3, 5, 9] -> true
          [3, -2, 1, 7, 3, 5, 9] -> false
          [3, -2, 1, 7, -4, 5, 9] -> false

There are 3 approaches to this solution:

Let the sum be T and n be the size of array

http://k2code.blogspot.in/2012/01/given-integer-array-and-number-x-find.html

Approach 1:
The naive way to do this would be to check all combinations (n choose 2). This exhaustive search is O(n2).

Approach 2:
 A better way would be to sort the array. This takes O(n log n)
Then for each x in array A, use binary search to look for T-x. This will take O(nlogn).
So, overall search is  O(n log n)

Approach 3 :
The best way would be to insert every element into a hash table (without sorting). This takes O(n) as constant time insertion.
Then for every x, we can just look up its complement, T-x, which is O(1).
Overall the run time of this approach is O(n).

 */


/*

2 Sum Problem : Given an integer array and a number T, find all unique pairs of (a, b) whose sum is equal to T
Friday, January 06, 2012  2Sum, array, hashtable, kodeknight, pair, sorting, sum, unique  19 comments
You are given an array of n integers and a target sum T. The goal is to determine whether or not there are two numbers x,y in A with x+y=T.

Example : Suppose we have an int array = {5, 3, 7, 0, 1, 4, 2} and T = 5. The unique pairs that sum up to 5 are (5, 0) (3, 2) and (1, 4).

There are three approaches to solve this problem - 1) brute force, 2) sort the array and use binary and search, and 3) Using the hashtable.
Please scroll down, if you are only interested in the best approach i.e. approach 3 using hashtables.


 */
public class FindPairs {

    // O(n2)
    public boolean findZero_approach1(int a[]) {

        boolean found = false;
        for(int i=0;i<a.length;i++) {

            for(int j=0;j < a.length; j++) {

                if(a[i] + a[j] == 0) {
                    found = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        return found;
    }


    /*
    3rd and Best - Use hash table

    I have already mentioned in problem in the application of hash table here.
        The best way would be to insert every element into a hash table (without sorting). This takes O(n) as constant time insertion.
        Then for every x, we can just look up its complement, T-x, which is O(1).
        Overall it takes will be O(n).
     */

    // Let arr be the given array.
    // And T be the given sum

    /*
    public boolean findZero_approach_2(int arr[]) {

        for (int i=0;  i< arr.length - 1 ;i++)
        {
            hash(arr[i]) = i;  // key is the element and value is its index.
        }

        for (int i=0; i<arr.length - 1; i++)
        {
            if (hash(T - arr[i]) != i ) // if T - ele exists and is different we found a pair
                System.out.println( "pair i , hash(T - arr[i]) has sum T");

        }

    }

     */


    public static void main(String args[]) {

        int arr[] = {5, 3, 7, 0, 1, 4, 2, -2};
        FindPairs fp = new FindPairs();
        System.out.println(fp.findZero_approach1(arr));



    }


}


