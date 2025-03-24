package com.algorithms.numbers;



/**
* Calculates floor of square root using binary search approach
*/

public class SquareRootClaude {
   
    /**
     * Finds floor value of square root of a number
     * @param num Input number to find square root of
     * @return Floor value of square root
     * @throws IllegalArgumentException if input is negative
     */
    public static int floorSqrt(int num) {
        // Validate input
        if (num < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        
        // Handle base cases
        if (num == 0 || num == 1) {
            return num;
        }
        
        // Binary search for square root
        int start = 1;
        int end = num;
        int result = 0;
        
        while (start <= end) {
            // Use long to avoid overflow
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid; // calculate square based on mid.
            
            if (square == num) {
                return mid;  // Perfect square
            }
            
            if (square < num) {
                // Update result and search upper half
                result = mid;
                start = mid + 1;
            } else {
                // Search lower half
                end = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Runs comprehensive test cases
     */
    public static void runTests() {
        System.out.println("Running Square Root Tests");
        System.out.println("========================");
 
        // Test 1: Perfect squares
        System.out.println("\nTest 1: Perfect squares");
        testCase(0, 0);
        testCase(1, 1);
        testCase(4, 2);
        testCase(9, 3);
        testCase(16, 4);
        testCase(25, 5);
        testCase(100, 10);
        
        // Test 2: Non-perfect squares
        System.out.println("\nTest 2: Non-perfect squares");
        testCase(2, 1);
        testCase(3, 1);
        testCase(8, 2);
        testCase(10, 3);
        testCase(99, 9);
        
        // Test 3: Large numbers
        System.out.println("\nTest 3: Large numbers");
        testCase(Integer.MAX_VALUE, 46340);  // Floor sqrt of MAX_VALUE
        testCase(1000000000, 31622);
        
        // Test 4: Edge cases
        System.out.println("\nTest 4: Edge cases");
        try {
            floorSqrt(-1);
            System.out.println("Failed: Should throw exception for negative input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative input");
        }
        
        // Test overflow handling
        System.out.println("\nTest 5: Overflow handling");
        testCase(2147395600, 46340);  // Close to MAX_VALUE
        
        // Test rounding behavior
        System.out.println("\nTest 6: Rounding behavior");
        testCase(7, 2);  // sqrt(7) ≈ 2.646, should return 2
        testCase(11, 3); // sqrt(11) ≈ 3.316, should return 3
    }
    
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int input, int expected) {
        try {
            int result = floorSqrt(input);
            System.out.printf("sqrt(%d) = %d, Expected: %d - %s%n", 
                input, result, expected,
                result == expected ? "PASSED" : "FAILED");
            
            // Verify result is actually floor of square root
            if (result * result > input || (result + 1) * (result + 1) <= input) {
                System.out.println("WARNING: Result may not be floor of square root");
            }
        } catch (Exception e) {
            System.out.printf("Input: %d - Exception: %s%n", 
                input, e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        runTests();
    }
 }