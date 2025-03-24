package com.algorithms.array.spiral;

/**
* Prints elements of a 2D array in spiral order
*/
public class SpiralPrint2DClaude {

    /**
     * Prints matrix elements in spiral order going clockwise
     * @param matrix Input 2D array
     * @throws IllegalArgumentException if input is invalid
     */
    public static void printSpiral(int[][] matrix) {
        // Input validation
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }
 
        // Validate row dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if (cols == 0) {
            throw new IllegalArgumentException("Matrix rows cannot be empty");
        }
 
        // Check for jagged array
        for (int[] row : matrix) {
            if (row == null || row.length != cols) {
                throw new IllegalArgumentException("All rows must have same length");
            }
        }
 
        int row_ptr = 0, num_rows = rows; // i row start
        int col_ptr = 0, num_cols = cols; // j column start
         
        while (row_ptr < num_rows && col_ptr < num_cols) {

            // Print top row
            for (int k = col_ptr; k < num_cols; k++) {
                System.out.print(matrix[row_ptr][k] + " ");
            }
            row_ptr++;
 
            // Print rightmost column
            for (int k = row_ptr; k < num_rows; k++) {
                System.out.print(matrix[row_ptr][num_cols-1] + " ");
            }
            num_cols--;
 
            if (row_ptr < num_rows) {
                // Print bottom row
                for (int k = num_cols-1; k >= col_ptr; k--) {
                    System.out.print(matrix[num_rows-1][k] + " ");
                }
                num_rows--;
            }
 
            if (col_ptr < num_cols) {
                // Print leftmost column
                for (int k = num_rows-1; k >= row_ptr; k--) {
                    System.out.print(matrix[k][col_ptr] + " ");
                }
                col_ptr++;
            }
        }
         
    }
 
    /**
     * Prints matrix in regular format
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
        System.out.println();
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Spiral Print Tests");
        System.out.println("=========================");
 
        // Test 1: Regular rectangular matrix
        System.out.println("Test 1: Regular 3x6 matrix");
        int[][] test1 = {
            {1,  2,  3,  4,  5,  6},
            {7,  8,  9,  10, 11, 12},
            {13, 14, 15, 16, 17, 18}
        };
        System.out.println("Original matrix:");
        printMatrix(test1);
        System.out.println("Spiral order:");
        printSpiral(test1);
 
        // Test 2: Square matrix
        System.out.println("\nTest 2: Square 3x3 matrix");
        int[][] test2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original matrix:");
        printMatrix(test2);
        System.out.println("Spiral order:");
        printSpiral(test2);
 
        // Test 3: Single row
        System.out.println("\nTest 3: Single row matrix");
        int[][] test3 = {{1, 2, 3, 4}};
        System.out.println("Original matrix:");
        printMatrix(test3);
        System.out.println("Spiral order:");
        printSpiral(test3);
 
        // Test 4: Single column
        System.out.println("\nTest 4: Single column matrix");
        int[][] test4 = {{1}, {2}, {3}};
        System.out.println("Original matrix:");
        printMatrix(test4);
        System.out.println("Spiral order:");
        printSpiral(test4);
 
        // Test 5: Edge cases
        System.out.println("\nTest 5: Edge cases");
        try {
            printSpiral(null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        try {
            printSpiral(new int[0][]);
            System.out.println("Failed: Should throw exception for empty matrix");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught empty matrix");
        }
 
        // Test 6: Jagged array
        System.out.println("\nTest 6: Jagged array");
        try {
            int[][] jagged = {{1,2}, {1,2,3}};
            printSpiral(jagged);
            System.out.println("Failed: Should throw exception for jagged array");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught jagged array");
        }
 
        // Test 7: Small 2x2 matrix
        System.out.println("\nTest 7: Small 2x2 matrix");
        int[][] test7 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Original matrix:");
        printMatrix(test7);
        System.out.println("Spiral order:");
        printSpiral(test7);
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }