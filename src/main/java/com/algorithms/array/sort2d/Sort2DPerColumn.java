package com.algorithms.array.sort2d;

import java.util.Arrays;
import java.util.Comparator;

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

/**
* Sorts a 2D array by specified column values
*/
public class Sort2DPerColumn {

   /**
    * Sorts 2D array based on values in specified column
    * @param arr 2D array to sort
    * @param col Column index to sort by (0-based)
    * @throws IllegalArgumentException if input is invalid
    */
   public static void sortByColumn(int[][] arr, int col) {
       // Input validation, Validate row and column dimensions
       if (arr == null || arr.length == 0 || arr[0].length == 0) {
           throw new IllegalArgumentException("Input array cannot be null or empty");
       }
       
       int cols = arr[0].length;
       // Validate column index
       if (col < 0 || col >= cols) {
           throw new IllegalArgumentException(
               "Column index " + col + " is out of bounds. Valid range: 0 to " + (cols-1));
       }

       // Check if all rows have same length
       for (int[] row : arr) {
           if (row == null || row.length != cols) {
               throw new IllegalArgumentException("All rows must have same length");
           }
       }

       // Sort array by specified column
       Arrays.sort(arr, new Comparator<int[]>() {
           @Override
           public int compare(int[] row1, int[] row2) {
               // Compare values in specified column
               // Returns: -1 if row1 < row2, 0 if equal, 1 if row1 > row2
               return Integer.compare(row1[col], row2[col]);
           }
       });
   }

   /**
    * Prints 2D array in matrix format
    */
   private static void printMatrix(int[][] matrix) {
       for (int[] row : matrix) {
           for (int val : row) {
               System.out.printf("%4d", val);
           }
           System.out.println();
       }
       System.out.println();
   }

   /**
    * Makes a deep copy of 2D array
    */
    private static int[][] copyMatrix(int[][] matrix) {
        // Create new array with same number of rows as original
        int[][] copy = new int[matrix.length][];
        
        // For each row in the matrix
        for(int i = 0; i < matrix.length; i++) {
            // Create a copy of the current row using Arrays.copyOf
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }

   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Sort2D Tests");
       System.out.println("===================");

       // Test 1: Basic sorting
       System.out.println("Test 1: Basic sorting by different columns");
       int[][] test1 = {
           {39, 27, 11, 42},
           {10, 93, 91, 90},
           {54, 78, 56, 89},
           {24, 64, 20, 65}
       };

       // Test sorting by each column
       for (int col = 0; col < 4; col++) {
           System.out.println("\nSorting by column " + col + ":");
           int[][] matrix = copyMatrix(test1);
           System.out.println("Before:");
           printMatrix(matrix);
           
           sortByColumn(matrix, col);
           
           System.out.println("After:");
           printMatrix(matrix);
       }

       // Test 2: Already sorted array
       System.out.println("Test 2: Already sorted array");
       int[][] test2 = {
           {1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}
       };
       System.out.println("Before:");
       printMatrix(test2);
       sortByColumn(test2, 0);
       System.out.println("After:");
       printMatrix(test2);

       // Test 3: Single row
       System.out.println("Test 3: Single row");
       int[][] test3 = {{3, 1, 2}};
       System.out.println("Before:");
       printMatrix(test3);
       sortByColumn(test3, 1);
       System.out.println("After:");
       printMatrix(test3);

       // Test 4: Edge cases
       System.out.println("Test 4: Edge cases");
       
       // Null array
       try {
           sortByColumn(null, 0);
           System.out.println("Failed: Should throw exception for null input");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught null input");
       }

       // Empty array
       try {
           sortByColumn(new int[0][], 0);
           System.out.println("Failed: Should throw exception for empty array");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught empty array");
       }

       // Invalid column
       try {
           sortByColumn(test1, -1);
           System.out.println("Failed: Should throw exception for invalid column");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught invalid column");
       }

       // Jagged array
       try {
           int[][] jagged = {{1,2}, {1,2,3}};
           sortByColumn(jagged, 0);
           System.out.println("Failed: Should throw exception for jagged array");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught jagged array");
       }
   }

   public static void main(String[] args) {
       runTests();
   }
}