package com.sort.mergesort;

/* 
 * These optimizations provide several benefits:

Memory Efficiency:

Only copies half the data to temp array
Reduces memory operations


Performance Improvements:

Uses insertion sort for small subarrays
Avoids unnecessary work on pre-sorted sequences
Reduces copying operations


Robustness:

Adds input validation
Handles edge cases better

 */

 /**
 * An optimized implementation of the Merge Sort algorithm that includes:
 * - Insertion sort for small subarrays
 * - Reduced temporary array usage
 * - Pre-sorted sequence detection
 * - Input validation
 */
public class OptimizedMergeSort {
    private int[] array;                // Main array to be sorted
    private int[] tempMergeArray;       // Temporary array for merging
    private int length;                 // Length of the array
    private static final int INSERTION_SORT_THRESHOLD = 10;  // Threshold for switching to insertion sort

    /**
     * Public sorting method that initializes the sorting process
     * @param inputArray Array to be sorted
     * @throws IllegalArgumentException if input array is null or empty
     */
    public void sort(int inputArray[]) {
        if (inputArray == null || inputArray.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        
        this.array = inputArray;
        this.length = inputArray.length;
        this.tempMergeArray = new int[length];
        doMergeSort(0, length - 1);
    }

    /**
     * Recursive method that implements the merge sort algorithm
     * @param l Left index of the subarray
     * @param r Right index of the subarray
     */
    private void doMergeSort(int l, int r) {
        // Use insertion sort for small subarrays
        if (r - l <= INSERTION_SORT_THRESHOLD) {
            insertionSort(l, r);
            return;
        }
        
        // Skip if subarray is already sorted
        if (isAlreadySorted(l, r)) {
            return;
        }
        
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            
            // Sort first and second halves
            doMergeSort(l, m);
            doMergeSort(m + 1, r);
            
            // Merge the sorted halves
            mergeParts(l, m, r);
        }
    }

    /**
     * Merges two sorted subarrays of array[]
     * First subarray is array[l..m]
     * Second subarray is array[m+1..r]
     */
    private void mergeParts(int l, int m, int r) {
        // Copy only the left half to temporary array
        // Right half will be accessed directly from original array
        for (int i = l; i <= m; i++) {
            tempMergeArray[i] = array[i];
        }
        
        int i = l;      // Initial index of left subarray (in temp array)
        int j = m + 1;  // Initial index of right subarray (in original array)
        int k = l;      // Initial index of merged array
        
        // Merge the two halves by comparing elements
        while (i <= m && j <= r) {
            if (tempMergeArray[i] <= array[j]) {
                array[k++] = tempMergeArray[i++];
            } else {
                array[k++] = array[j++];
            }
        }
        
        // Copy remaining elements of left half
        while (i <= m) {
            array[k++] = tempMergeArray[i++];
        }
        // No need to copy remaining right half - it's already in place
    }

    /**
     * Insertion sort for small subarrays
     * More efficient than merge sort for small arrays
     */
    private void insertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            
            // Move elements that are greater than key
            // to one position ahead of their current position
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Checks if the subarray is already sorted
     * @return true if the subarray array[l..r] is sorted
     */
    private boolean isAlreadySorted(int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method for testing the sort implementation
     */
    public static void main(String[] args) {
        int[] inputArray = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        
        OptimizedMergeSort sorter = new OptimizedMergeSort();
        sorter.sort(inputArray);
        
        System.out.println("Sorted array:");
        for (int num : inputArray) {
            System.out.print(num + " ");
        }
    }
}