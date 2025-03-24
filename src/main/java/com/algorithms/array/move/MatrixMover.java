package com.algorithms.array.move;

/*

    // Move non-zero elements once either one cell straight down or one cell diagonally down (down and right).
    // If the destination cell is occupied (non-zero data), don't move the data.

    int mat1[][] =
    {
        { 0, 1, 0, 7, 2 },     // {0,0}, {0,1}, {0, 2} ....
        { 0, 0, 3, 0, 0 },     // {1,0}, {1, 1}, {1, 2} ....
        { 5, 0, 3, 0, 6 },
        { 3, 4, 0, 0, 0 }, // n - 1, m - 1
        { 8, 2, 0, 9, 4 }, // out of bound n, m
    };

   public void move(int mat1[n][m]) {

   if(mat1 == null)
       return;

   // n < 2

    for(int i=0; i < n - 1; i++) {

       for(int j = 0; j < m; j++) {

           if( a[i+1][j] == 0 ) {
               // swap();
           } else if( j+1 < m && a[i+1][j+1] == 0) {  // out of bound a[n][m]
                // swap()
           }
       }

    }

   }

 */

 /**
 * Program to move non-zero elements in a matrix either straight down 
 * or diagonally down-right, if destination is unoccupied (zero)
 */

 /*
  * 
  This implementation includes:

    Core Logic:

    Process matrix bottom-up to avoid overwriting
    For each non-zero element:

    First try to move straight down
    If not possible, try to move diagonally down-right
    Only move if destination is zero

    Returns whether any movement occurred

    Input Validation:

    Null check
    Empty matrix check
    Row/column bounds checks

    Test Cases:

    Basic movement
    No possible moves
    Multiple moves possible
    Edge cases (null, empty matrix)


    Helper Methods:
    Matrix printing
    Clear test output

    The program handles different scenarios:

    Elements can move straight down if space available
    Elements can move diagonally down-right if straight down is blocked
    Elements don't move if both positions are blocked
    Multiple elements can move in the same turn
    Edge cases are properly handled
  */
public class MatrixMover {
    
    /**
     * Moves non-zero elements down or diagonally in the matrix
     * @param matrix Input matrix to be modified
     * @return true if any element was moved, false otherwise 
     */
    public static boolean moveElements(int[][] matrix) {
        // Input validation
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix input");
        }
        
        // In a 2D array (matrix) in Java:
        // matrix.length gives you the number of rows (the first dimension)
        // matrix[0].length gives you the number of columns (the second dimension)

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean moved = false;
        
        // int[][] test1 = {
        //    {1, 0, 3},
        //    {0, 0, 0},
        //    {4, 5, 0}
        // };

        // Process bottom-up to avoid overwriting
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != 0) {  // Found non-zero element
                    // Try moving straight down
                    if (row + 1 < rows && matrix[row + 1][col] == 0) {
                        matrix[row + 1][col] = matrix[row][col];
                        matrix[row][col] = 0;
                        moved = true;
                    }
                    // Try moving diagonally down-right if couldn't move straight down
                    else if (col + 1 < cols && row + 1 < rows && 
                             matrix[row + 1][col + 1] == 0) {
                        matrix[row + 1][col + 1] = matrix[row][col];
                        matrix[row][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        
        return moved;
    }
    
    /**
     * Prints the matrix in a formatted way
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Matrix Mover Tests");
        System.out.println("=========================");
        
        // Test 1: Basic movement
        System.out.println("Test 1: Basic movement");
        int[][] test1 = {
            {1, 0, 3},
            {0, 0, 0},
            {4, 5, 0}
        };
        System.out.println("Before:");
        printMatrix(test1);
        moveElements(test1);
        System.out.println("After:");
        printMatrix(test1);
        
        // Test 2: No possible moves
        System.out.println("Test 2: No possible moves");
        int[][] test2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Before:");
        printMatrix(test2);
        moveElements(test2);
        System.out.println("After:");
        printMatrix(test2);
        
        // Test 3: Multiple moves possible
        System.out.println("Test 3: Multiple moves possible");
        int[][] test3 = {
            {1, 2, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Before:");
        printMatrix(test3);
        moveElements(test3);
        System.out.println("After:");
        printMatrix(test3);
        
        // Test 4: Edge cases
        try {
            moveElements(null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
        
        try {
            moveElements(new int[0][0]);
            System.out.println("Failed: Should throw exception for empty matrix");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught empty matrix");
        }
    }
    
    public static void main(String[] args) {
        runTests();
    }
}