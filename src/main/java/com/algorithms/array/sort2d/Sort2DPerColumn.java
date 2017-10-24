package com.algorithms.array.sort2d;


/*
http://www.geeksforgeeks.org/sorting-2d-array-according-values-given-column-java/

Sorting a 2D Array according to values in any given column in Java
We are given a 2D array of order N X M and a column number K ( 1<=K<=m). Our task is to sort the 2D array according to
values in the Column K.

Examples:

Input : If our 2D array is given as (Order 4X4)
        39 27 11 42
        10 93 91 90
        54 78 56 89
        24 64 20 65
        Sorting it by values in column 3
Output : 39 27 11 42
         24 64 20 65
         54 78 56 89
         10 93 91 90


 */

// Java Code to sort 2D Matrix
// according to any Column

import java.util.*;

public class Sort2DPerColumn {

    // Function to sort by column
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }

    // Driver Code
    public static void main(String args[])
    {
        int matrix[][] = { { 39, 27, 11, 42 },
                { 10, 93, 91, 90 },
                { 54, 78, 56, 89 },
                { 24, 64, 20, 65 } };
        // Sort this matrix by 3rd Column
        int col = 3;
        sortbyColumn(matrix, col - 1);

        // Display the sorted Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}

/*

Output:

39 27 11 42
24 64 20 65
54 78 56 89
10 93 91 90

Time complexity : O(n Log n) where n is number of rows. Here assumption is that the sort() function uses a O(n Log n)
 sorting algorithm.

 */