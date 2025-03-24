package com.algorithms.search.ksmallest.solutions;

import java.util.Arrays;

/**
* Finds kth smallest element in array using QuickSelect algorithm
*/
public class KthSmallestQuickSelectClaude {

    /**
     * Finds kth smallest element in array
     * @param arr Input array
     * @param k Position (1-based) to find
     * @return kth smallest element
     * @throws IllegalArgumentException for invalid inputs
     */
    public static int findKthSmallest(int[] arr, int k) {
        // Input validation
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("k must be between 1 and array length");
        }
 
        return quickSelect(arr, 0, arr.length - 1, k - 1); // Convert to 0-based index
    }
 
    /**
     * QuickSelect algorithm implementation
     * @param arr Array to search
     * @param left Left boundary
     * @param right Right boundary
     * @param k kth position to find (0-based)
     * @return kth element
     */
    private static int quickSelect(int[] arr, int left, int right, int k) {
        // Base case: single element
        if (left == right) {
            return arr[left];
        }
 
        // Select pivot and partition array
        int pivotIndex = partition(arr, left, right);
 
        // If pivot is target element
        if (k == pivotIndex) {
            return arr[k];
        }
        // If k is in left half
        else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        }
        // If k is in right half
        else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }
 
    /**
     * Partitions array around pivot
     * Uses median-of-three for better pivot selection
     */
    private static int partition(int[] arr, int left, int right) {
        // Choose median of three as pivot
        int mid = left + (right - left) / 2;
        int pivot = medianOfThree(arr, left, mid, right);
        swap(arr, pivot, right);  // Move pivot to end
 
        pivot = arr[right];
        int i = left - 1;
 
        // Partition around pivot
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
 
        // Put pivot in its final position
        swap(arr, i + 1, right);
        return i + 1;
    }
 
    /**
     * Finds median of three elements
     */
    private static int medianOfThree(int[] arr, int a, int b, int c) {
        int A = arr[a], B = arr[b], C = arr[c];
        if (A <= B) {
            if (B <= C) return b;
            if (A <= C) return c;
            return a;
        }
        if (A <= C) return a;
        if (B <= C) return c;
        return b;
    }
 
    /**
     * Swaps two elements in array
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Kth Smallest Element Tests");
        System.out.println("=================================");
 
        // Test 1: Basic cases
        System.out.println("\nTest 1: Basic cases");
        testCase(new int[]{7, 10, 4, 3, 20, 15}, 3, 7);
        testCase(new int[]{7, 10, 4, 3, 20, 15}, 4, 10);
        testCase(new int[]{1, 2, 3, 4, 5, 6}, 2, 2);
 
        // Test 2: Edge cases with k
        System.out.println("\nTest 2: Edge cases with k");
        testCase(new int[]{1, 2, 3, 4, 5}, 1, 1);  // First element
        testCase(new int[]{1, 2, 3, 4, 5}, 5, 5);  // Last element
 
        // Test 3: Array variations
        System.out.println("\nTest 3: Array variations");
        testCase(new int[]{1}, 1, 1);  // Single element
        testCase(new int[]{2, 1}, 1, 1);  // Two elements
        testCase(new int[]{3, 2, 1}, 2, 2);  // Three elements
 
        // Test 4: Invalid inputs
        System.out.println("\nTest 4: Invalid inputs");
        try {
            findKthSmallest(null, 1);
            System.out.println("Failed: Should throw exception for null array");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null array");
        }
 
        try {
            findKthSmallest(new int[]{1, 2, 3}, 0);
            System.out.println("Failed: Should throw exception for k=0");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught k=0");
        }
 
        try {
            findKthSmallest(new int[]{1, 2, 3}, 4);
            System.out.println("Failed: Should throw exception for k>length");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught k>length");
        }
 
        // Test 5: Larger arrays
        System.out.println("\nTest 5: Larger arrays");
        testCase(new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20}, 4, 31);
        testCase(new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20}, 1, 17);
        testCase(new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20}, 9, 93);
 
        // Test 6: Negative numbers
        System.out.println("\nTest 6: Negative numbers");
        testCase(new int[]{-5, -10, 0, -15, 20}, 2, -10);
        testCase(new int[]{-20, -10, -30, -40, -50}, 3, -30);
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int[] arr, int k, int expected) {
        try {
            int[] original = Arrays.copyOf(arr, arr.length);
            int result = findKthSmallest(arr, k);
            System.out.printf("Array: %s, k=%d: Expected %d, Got %d - %s%n",
                Arrays.toString(original), k, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Array: %s, k=%d: Exception: %s%n",
                Arrays.toString(arr), k, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }