package com.algorithms.search;


/**
* Implements Binary Search algorithm for sorted arrays
*/
public class BinarySearchClaude {

    /**
     * Performs binary search to find target element
     * @param arr Sorted array to search in
     * @param target Element to find
     * @return Index of target if found, -1 if not found
     * @throws IllegalArgumentException if array is null
     */
    public static int search(int[] arr, int target) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
 
        int left = 0;
        int right = arr.length - 1;
 
        // Binary search loop
        while (left <= right) {
            // Calculate middle point without overflow
            int mid = left + (right - left) / 2;
 
            // Found target
            if (arr[mid] == target) {
                return mid;
            }
            
            // Search left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // Search right half
            else {
                left = mid + 1;
            }
        }
 
        return -1;  // Element not found
    }
 
    /**
     * Verifies if array is sorted in ascending order
     */
    private static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Binary Search Tests");
        System.out.println("==========================");
 
        // Test 1: Basic searches
        System.out.println("\nTest 1: Basic searches");
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15};
        testCase(arr1, 7, 3);     // Element exists in middle
        testCase(arr1, 1, 0);     // First element
        testCase(arr1, 15, 7);    // Last element
        testCase(arr1, 10, -1);   // Element doesn't exist
 
        // Test 2: Small arrays
        System.out.println("\nTest 2: Small arrays");
        testCase(new int[]{1}, 1, 0);          // Single element found
        testCase(new int[]{1}, 2, -1);         // Single element not found
        testCase(new int[]{1, 2}, 1, 0);       // Two elements
        testCase(new int[]{1, 2}, 2, 1);       // Two elements
        testCase(new int[]{}, 1, -1);          // Empty array
 
        // Test 3: Duplicate elements
        System.out.println("\nTest 3: Duplicate elements");
        int[] arr3 = {1, 2, 2, 2, 3, 4, 4, 5};
        testCase(arr3, 2, "2,3,4");  // Multiple possible positions
        testCase(arr3, 4, "6,7");    // Multiple possible positions
        testCase(arr3, 0, -1);       // Element not present
 
        // Test 4: Edge cases
        System.out.println("\nTest 4: Edge cases");
        try {
            search(null, 5);
            System.out.println("Failed: Should throw exception for null array");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null array");
        }
 
        // Test 5: Large numbers
        System.out.println("\nTest 5: Large numbers");
        int[] arr5 = {Integer.MIN_VALUE, -5, 0, 5, Integer.MAX_VALUE};
        testCase(arr5, Integer.MIN_VALUE, 0);   // Minimum value
        testCase(arr5, Integer.MAX_VALUE, 4);   // Maximum value
        testCase(arr5, 0, 2);                   // Zero
 
        // Test 6: Unsorted array warning
        System.out.println("\nTest 6: Unsorted array warning");
        int[] arr6 = {5, 2, 8, 1, 9};
        if (!isSorted(arr6)) {
            System.out.println("Warning: Array is not sorted, results may be incorrect");
        }
        testCase(arr6, 8, -1);  // May give incorrect result
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int[] arr, int target, int expected) {
        try {
            int result = search(arr, target);
            System.out.printf("Array: %s\nTarget: %d, Expected: %d, Got: %d - %s%n",
                Arrays.toString(arr), target, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Array: %s, Target: %d, Exception: %s%n",
                Arrays.toString(arr), target, e.getMessage());
        }
    }
 
    /**
     * Overloaded test method for cases with multiple possible positions
     */
    private static void testCase(int[] arr, int target, String expectedPositions) {
        try {
            int result = search(arr, target);
            System.out.printf("Array: %s\nTarget: %d, Expected one of: %s, Got: %d - %s%n",
                Arrays.toString(arr), target, expectedPositions, result,
                expectedPositions.contains(String.valueOf(result)) ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Array: %s, Target: %d, Exception: %s%n",
                Arrays.toString(arr), target, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }