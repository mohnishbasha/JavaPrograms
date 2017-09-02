package com.sort.algorithms.sol2;

/*
http://www.geeksforgeeks.org/sort-array-converting-elements-squares/

Sort array after converting elements to their squares
Given a array of both positive and negative integers ‘arr[]’ which are sorted. Task is to sort square of the numbers of the Array.
Examples:

Input  : arr[] =  {-6, -3, -1, 2, 4, 5}
Output : 1, 4, 9, 16, 25, 36

Input  : arr[] = {-5, -4, -2, 0, 1}
Output : 0, 1, 4, 16, 25

Simple solution is to first convert each array elements into its square and than apply any “O(nlogn)”
sorting algorithm to sort the array elements.

 */

// Java program to Sort square of the numbers
// of the array
import java.util.*;

class SortSquares
{
    // Function to sort an square array
    public static void sortSquares(int arr[])
    {
        int n = arr.length;

        // First convert each array elements
        // into its square
        for (int i = 0 ; i < n ; i++)
            arr[i] = arr[i] * arr[i];

        // Sort an array using "inbuild sort function"
        // in Arrays class.
        Arrays.sort(arr);
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        int arr[] = { -6 , -3 , -1 , 2 , 4 , 5 };
        int n = arr.length;

        System.out.println("Before sort ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        sortSquares(arr);
        System.out.println("");
        System.out.println("After Sort ");
        for (int i = 0 ; i < n ; i++)
            System.out.print(arr[i] + " ");

    }
}
  /*
        Output:
        Before sort
        -6 -3 -1 2 4 5
        After Sort
        1 4 9 16 25 36
        Time complexity : O(n log n)
   */