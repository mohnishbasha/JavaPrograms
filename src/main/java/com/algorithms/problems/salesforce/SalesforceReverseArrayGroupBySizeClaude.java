package com.algorithms.problems.salesforce;

import java.util.Arrays;

/**
* Reverses elements in array by group size 
* Example: For array [1,2,3,4,5] and group size 3:
* First group [1,2,3] becomes [3,2,1]
* Second group [4,5] becomes [5,4]
* Result: [3,2,1,5,4]
*/
public class SalesforceReverseArrayGroupBySizeClaude {

    /**
     * Reverses array elements in groups
     * @param array Array to reverse
     * @param k Group size
     * @throws IllegalArgumentException if invalid inputs
     */
    public static void reverseByGroups(int[] array, int k) {
        // Input validation
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("Group size must be positive");
        }
 
        // For each group
        for (int i = 0; i < array.length; i += k) {
            // Find start and end of current group
            int start = i;
            int end = Math.min(i + k - 1, array.length - 1);
            // ^^ This line calculates the end index for a group reversal operation, ensuring we don't go beyond array bounds.
            // Array: [1, 2, 3, 4, 5, 6, 7]
            // |Group1| |Group2| |G3|
            // i=0: min(0+3-1, 6) = min(2, 6) = 2    // First group: [1,2,3]
            // i=3: min(3+3-1, 6) = min(5, 6) = 5    // Second group: [4,5,6]
            // i=6: min(6+3-1, 6) = min(8, 6) = 6    // Last group: [7]
            
            // Reverse current group - swap
            while (start < end) {
                // Swap elements
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                
                start++;
                end--;
            }
        }
    }
 
    /**
     * Helper method to copy array
     */
    private static int[] copyArray(int[] array) {
        return array == null ? null : Arrays.copyOf(array, array.length);
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Reverse Array By Group Tests");
        System.out.println("===================================");
 
        // Test 1: Basic cases
        System.out.println("\nTest 1: Basic cases");
        testCase(new int[]{1,2,3,4,5}, 3, "[3,2,1,5,4]");
        testCase(new int[]{1,2,3,4,5,6}, 2, "[2,1,4,3,6,5]");
        testCase(new int[]{1,2,3,4,5,6}, 3, "[3,2,1,6,5,4]");
        testCase(new int[]{1,2,3,4,5,6}, 4, "[4,3,2,1,6,5]");
 
        // Test 2: Edge cases with group size
        System.out.println("\nTest 2: Edge cases with group size");
        testCase(new int[]{1,2,3,4,5}, 1, "[1,2,3,4,5]");  // k=1
        testCase(new int[]{1,2,3,4,5}, 5, "[5,4,3,2,1]");  // k=array length
        testCase(new int[]{1,2,3,4,5}, 6, "[5,4,3,2,1]");  // k>array length
 
        // Test 3: Special arrays
        System.out.println("\nTest 3: Special arrays");
        testCase(new int[]{1}, 1, "[1]");  // Single element
        testCase(new int[]{}, 3, "[]");    // Empty array
        testCase(new int[]{1,1,1,1}, 2, "[1,1,1,1]");  // Same elements
 
        // Test 4: Invalid inputs
        System.out.println("\nTest 4: Invalid inputs");
        try {
            reverseByGroups(null, 3);
            System.out.println("Failed: Should throw exception for null array");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null array");
        }
 
        try {
            reverseByGroups(new int[]{1,2,3}, 0);
            System.out.println("Failed: Should throw exception for zero group size");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught zero group size");
        }
 
        try {
            reverseByGroups(new int[]{1,2,3}, -1);
            System.out.println("Failed: Should throw exception for negative group size");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative group size");
        }
 
        // Test 5: Larger arrays
        System.out.println("\nTest 5: Larger arrays");
        testCase(new int[]{1,2,3,4,5,6,7,8,9,10}, 3, "[3,2,1,6,5,4,9,8,7,10]");
        testCase(new int[]{1,2,3,4,5,6,7,8,9,10}, 4, "[4,3,2,1,8,7,6,5,10,9]");
        
        // Test 6: Array with negative numbers
        System.out.println("\nTest 6: Array with negative numbers");
        testCase(new int[]{-1,-2,-3,4,5}, 2, "[-2,-1,4,-3,5]");
        testCase(new int[]{-1,-2,-3,-4,-5}, 3, "[-3,-2,-1,-5,-4]");
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int[] arr, int k, String expected) {
        try {
            int[] original = copyArray(arr);
            reverseByGroups(arr, k);
            String result = Arrays.toString(arr);
            System.out.printf("Array: %s, k=%d: Expected %s, Got %s - %s%n",
                Arrays.toString(original), k, expected, result,
                result.equals(expected) ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Array: %s, k=%d: Exception: %s%n",
                Arrays.toString(arr), k, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }