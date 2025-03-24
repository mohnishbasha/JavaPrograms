package com.algorithms.array.printdiagonal;

/*
http://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
https://www.youtube.com/watch?v=T8ErAYobcbc


Zigzag (or diagonal) traversal of Matrix
Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.

    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20
Diagonal printing of the above matrix is

    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20

Below is an Alternate Method to solve the above problem.

Matrix =>       1     2     3     4
                5     6     7     8
                9     10    11   12
                13    14    15   16
                17    18    19   20

Observe the sequence
          1 /  2 /  3 /  4
           / 5  /  6 /  7 /  8
               /  9 / 10 / 11 / 12
                   / 13 / 14 / 15 / 16
                       / 17 / 18 / 19 / 20


 */


/**
* Prints the elements of a 2D array in zigzag diagonal pattern
*/
class ZigZagPrintArray {

    /**
     * Prints elements in diagonal zigzag pattern
     * Time complexity: O(R*C) where R and C are dimensions
     * @param arr Input 2D array
     * @throws IllegalArgumentException if input is invalid
     */
    public static void printDiagonal(int[][] arr) {
        // Input validation
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            throw new IllegalArgumentException("Invalid input array");
        }
 
        // Print diagonals starting from first column
        // Let's visualize with a matrix:
        // 1  2  3  4
        // 5  6  7  8
        // 9  10 11 12
        // 13 14 15 16

        // The code will print diagonals starting from first column (1, 5, 9, 13):
        // 1. Start at 1: prints "1"
        // Start at 5: prints "5 2"
        // Start at 9: prints "9 6 3"
        // Start at 13: prints "13 10 7 4"
        // For example, when starting at 9:
        // First prints 9
        // Then i = 1 (row-1), j = 1: prints 6
        // Then i = 0 (row-2), j = 2: prints 3
        // Then stops because next position would be invalid
        // Each diagonal moves up-right (↗) until it hits the matrix boundary.

        int num_rows = arr.length;
        int num_cols = arr[0].length;

        for (int row = 0; row < num_rows; row++) {                    // Start from each element in first column
            System.out.print(arr[row][0] + " ");                  // Print the starting element
            
            int i = row - 1;    // Move one row up from current position - pointer
            int j = 1;          // Move one column right from current position - pointer
            
            while (isValid(i, j, num_rows, num_cols)) {                   // Keep going while in bounds
                System.out.print(arr[i][j] + " ");
                i--;    // Continue moving up
                j++;    // Continue moving right
            }
            System.out.println();                                 // New line after each diagonal
        }
 
        // Print diagonals starting from bottom row (except first element)
        for (int col = 1; col < num_cols; col++) {                    // Start from each element in bottom row (except first)
            System.out.print(arr[num_rows-1][col] + " ");            // Print the starting element
            
            int i = num_rows - 2;   // Start one row up
            int j = col + 1;    // Start one column right
            
            while (isValid(i, j, num_rows, num_cols)) {                  // Keep going while in bounds
                System.out.print(arr[i][j] + " ");
                i--;    // Move up
                j++;    // Move right
            }
            System.out.println();                                // New line after each diagonal
        }

        // Using the same matrix:
        // 1  2  3  4
        // 5  6  7  8
        // 9  10 11 12
        // 13 14 15 16

        // This code prints diagonals starting from bottom row (except first element, which was handled in previous part):
        // Start at 14: prints "14 11 8"
        // Start at 15: prints "15 12"
        // Start at 16: prints "16"
        // For example, when starting at 14:
        // First prints 14
        // Then i = 2 (rows-2), j = 2 (col+1): prints 11
        // Then i = 1, j = 3: prints 8
        // Then stops because next position would be invalid
        // Each diagonal moves up-right (↗) until it hits the matrix boundary, just like in the first part, but these diagonals start from the bottom row.

    }
 
    /**
     * Checks if array indices are valid
     */
    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running ZigZag Print Tests");
        System.out.println("=========================");
 
        // Test 1: Regular rectangular matrix
        System.out.println("\nTest 1: Regular 5x4 matrix");
        int[][] test1 = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        };
        printDiagonal(test1);
 
        // Test 2: Square matrix
        System.out.println("\nTest 2: Square 3x3 matrix");
        int[][] test2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printDiagonal(test2);
 
        // Test 3: Single row
        System.out.println("\nTest 3: Single row matrix");
        int[][] test3 = {{1, 2, 3, 4}};
        printDiagonal(test3);
 
        // Test 4: Single column
        System.out.println("\nTest 4: Single column matrix");
        int[][] test4 = {{1}, {2}, {3}};
        printDiagonal(test4);
 
        // Test 5: Edge cases
        System.out.println("\nTest 5: Edge cases");
        try {
            printDiagonal(null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        try {
            printDiagonal(new int[0][0]);
            System.out.println("Failed: Should throw exception for empty array");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught empty array");
        }
 
        // Test 6: Small 2x2 matrix
        System.out.println("\nTest 6: Small 2x2 matrix");
        int[][] test6 = {
            {1, 2},
            {3, 4}
        };
        printDiagonal(test6);
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }