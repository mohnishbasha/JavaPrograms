package com.algorithms.array.majority;

/**

 http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/

 Check for Majority Element in a sorted array

 Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.

 Basically, we need to write a function say isMajority() that takes an array (arr[] ), array’s size (n) and a number to
 be searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).

 Examples:

 Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
 Output: True (x appears more than n/2 times in the given array)

 Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
 Output: False (x doesn't appear more than n/2 times in the given array)

 Input: arr[] = {1, 1, 1, 2, 2}, x = 1
 Output: True (x appears more than n/2 times in the given array)
 METHOD 1 (Using Linear Search)
 Linearly search for the first occurrence of the element, once you find it (let at index i), check element at index
 i + n/2. If element is present at i+n/2 then return 1 else return 0.

 Output:
 4 appears more than 3 times in arr[]
 Time Complexity: O(n)


*/

 /* Program to check for majority element in a sorted array */



class MajorityLinear {

    static boolean isMajority(int arr[], int n, int x)
    {
        int i, last_index = 0;

        /* get last index according to n (even or odd) */
        last_index = (n % 2 == 0) ? n/2 : n/2+1;

        /* search for first occurrence of x in arr[]*/
        for (i = 0; i < last_index; i++)
        {
            /* check if x is present and is present more
               than n/2 times */
            if (arr[i] == x && arr[i+n/2] == x)
                return true;
        }
        return false;
    }

    /* Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 4, 4, 4};
        int n = arr.length;
        int x = 4;
        if (isMajority(arr, arr.length, x)==true)
            System.out.println(x+" appears more than "+
                    n/2+" times in arr[]");
        else
            System.out.println(x+" does not appear more than "+
                    n/2+" times in arr[]");
    }
}
