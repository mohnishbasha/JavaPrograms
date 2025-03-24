package com.algorithms.array.spiralanti;

import java.util.Stack;

/**
* Prints elements of a 2D array in anti-spiral order 
* (spiral order in reverse using a stack)
*/
public class AntiSpiral2DClaude {

   /**
    * Prints matrix elements in anti-spiral order
    * @param matrix Input 2D array
    * @throws IllegalArgumentException if input is invalid
    */
   public static void printAntiSpiral(int[][] matrix) {
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

       Stack<Integer> stack = new Stack<>();
       int startRow = 0, endRow = rows - 1;
       int startCol = 0, endCol = cols - 1;

       // Traverse in spiral order and push to stack
       while (startRow <= endRow && startCol <= endCol) {
           // Push top row
           for (int i = startCol; i <= endCol; i++) {
               stack.push(matrix[startRow][i]);
           }
           startRow++;

           // Push rightmost column
           for (int i = startRow; i <= endRow; i++) {
               stack.push(matrix[i][endCol]);
           }
           endCol--;

           if (startRow <= endRow) {
               // Push bottom row
               for (int i = endCol; i >= startCol; i--) {
                   stack.push(matrix[endRow][i]);
               }
               endRow--;
           }

           if (startCol <= endCol) {
               // Push leftmost column
               for (int i = endRow; i >= startRow; i--) {
                   stack.push(matrix[i][startCol]);
               }
               startCol++;
           }
       }

       // Print in reverse order by popping from stack
       while (!stack.isEmpty()) {
           System.out.print(stack.pop() + " ");
       }
       System.out.println();
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
       System.out.println("Running Anti-Spiral Print Tests");
       System.out.println("==============================");

       // Test 1: Regular rectangular matrix
       System.out.println("Test 1: Regular 4x5 matrix");
       int[][] test1 = {
           {1,  2,  3,  4,  5},
           {6,  7,  8,  9,  10},
           {11, 12, 13, 14, 15},
           {16, 17, 18, 19, 20}
       };
       System.out.println("Original matrix:");
       printMatrix(test1);
       System.out.println("Anti-spiral order:");
       printAntiSpiral(test1);

       // Test 2: Square matrix
       System.out.println("\nTest 2: Square 3x3 matrix");
       int[][] test2 = {
           {1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}
       };
       System.out.println("Original matrix:");
       printMatrix(test2);
       System.out.println("Anti-spiral order:");
       printAntiSpiral(test2);

       // Test 3: Single row
       System.out.println("\nTest 3: Single row matrix");
       int[][] test3 = {{1, 2, 3, 4}};
       System.out.println("Original matrix:");
       printMatrix(test3);
       System.out.println("Anti-spiral order:");
       printAntiSpiral(test3);

       // Test 4: Single column
       System.out.println("\nTest 4: Single column matrix");
       int[][] test4 = {{1}, {2}, {3}};
       System.out.println("Original matrix:");
       printMatrix(test4);
       System.out.println("Anti-spiral order:");
       printAntiSpiral(test4);

       // Test 5: Edge cases
       System.out.println("\nTest 5: Edge cases");
       try {
           printAntiSpiral(null);
           System.out.println("Failed: Should throw exception for null input");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught null input");
       }

       try {
           printAntiSpiral(new int[0][]);
           System.out.println("Failed: Should throw exception for empty matrix");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught empty matrix");
       }

       // Test 6: Jagged array
       System.out.println("\nTest 6: Jagged array");
       try {
           int[][] jagged = {{1,2}, {1,2,3}};
           printAntiSpiral(jagged);
           System.out.println("Failed: Should throw exception for jagged array");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught jagged array");
       }

       // Test 7: 2x2 matrix
       System.out.println("\nTest 7: Small 2x2 matrix");
       int[][] test7 = {
           {1, 2},
           {3, 4}
       };
       System.out.println("Original matrix:");
       printMatrix(test7);
       System.out.println("Anti-spiral order:");
       printAntiSpiral(test7);
   }

   public static void main(String[] args) {
       runTests();
   }
}