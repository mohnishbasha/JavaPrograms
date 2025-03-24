package com.sort.quicksort;

/*

Read:
http://www.geeksforgeeks.org/3-way-quicksort/

In simple QuickSort algorithm, we select an data as pivot, partition the array around pivot and recur for
subarrays on left and right of pivot.
Consider an array which has many redundant elements. For example, {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4,
4, 4}. If 4 is picked as pivot in Simple QuickSort, we fix only one 4 and recursively process remaining occurrences.

The idea of 3 way QuickSort is to process all occurrences of pivot.

In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
a) arr[l..i] elements less than pivot.
b) arr[i+1..j-1] elements equal to pivot.
c) arr[j..r] elements greater than pivot.

 */

 /*
  * 
  This implementation includes several optimizations:

Three-Way Partitioning: Efficiently handles duplicates by creating three partitions (less than, equal to, and greater than pivot)
Median-of-Three: Uses median-of-three method for pivot selection to avoid worst-case scenarios
Insertion Sort for Small Arrays: Switches to insertion sort for small subarrays (less than 10 elements)
Input Validation: Checks for null or empty arrays

The code features:

Comprehensive comments explaining the algorithm and each method
Clear variable naming and consistent formatting
Test cases demonstrating different scenarios:

Random array
Array with many duplicates
Nearly sorted array


Utility methods for array manipulation and printing

The three-way partitioning makes this implementation particularly efficient for arrays with many duplicate elements, as equal elements are handled in a single pass rather than being repeatedly compared.
  */

 /**
 * Implementation of Three-Way QuickSort algorithm
 * Handles duplicates efficiently by partitioning array into three parts:
 * elements less than pivot, equal to pivot, and greater than pivot
 */
public class ThreeWayQuickSort {
    
    /**
     * Public method to sort the array
     * @param arr Array to be sorted
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Recursive three-way quick sort method
     * @param arr Array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        
        // Use insertion sort for small subarrays (optimization)
        if (high - low < 10) {
            insertionSort(arr, low, high);
            return;
        }
        
        // Partition points
        int[] partition = partition(arr, low, high);
        int lt = partition[0];  // Last index of elements less than pivot
        int gt = partition[1];  // First index of elements greater than pivot
        
        // Recursively sort left and right partitions
        quickSort(arr, low, lt - 1);   // Sort elements less than pivot
        quickSort(arr, gt + 1, high);  // Sort elements greater than pivot
    }
    
    /**
     * Partitions array into three parts:
     * - Elements less than pivot
     * - Elements equal to pivot
     * - Elements greater than pivot
     * @return int[] array containing indices: [lt, gt]
     *         lt: last index of elements < pivot
     *         gt: first index of elements > pivot
     */
    private int[] partition(int[] arr, int low, int high) {
        // Choose pivot using median-of-three (optimization)
        int pivot = medianOfThree(arr, low, high);
        
        // Variables for three-way partitioning
        int lt = low;      // Last position of elements less than pivot
        int i = low;       // Current element being examined
        int gt = high;     // First position of elements greater than pivot
        
        // Partition array
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        
        return new int[]{lt, gt};
    }
    
    /**
     * Selects pivot using median-of-three method
     * Examines first, middle, and last elements
     */
    private int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        
        // Sort low, mid, high elements
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        
        // Place pivot at high-1 position
        swap(arr, mid, high - 1);
        return arr[high - 1];
    }
    
    /**
     * Insertion sort for small subarrays
     */
    private void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Swaps two elements in array
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        ThreeWayQuickSort sorter = new ThreeWayQuickSort();
        
        // Test case 1: Random array
        int[] arr1 = {5, 2, 9, 3, 5, 6, 5, 2, 8, 1};
        System.out.println("Original array 1:");
        printArray(arr1);
        sorter.sort(arr1);
        System.out.println("Sorted array 1:");
        printArray(arr1);
        
        // Test case 2: Array with many duplicates
        int[] arr2 = {3, 3, 3, 2, 2, 1, 1, 3, 2, 1};
        System.out.println("\nOriginal array 2:");
        printArray(arr2);
        sorter.sort(arr2);
        System.out.println("Sorted array 2:");
        printArray(arr2);
        
        // Test case 3: Nearly sorted array
        int[] arr3 = {1, 2, 3, 5, 4, 6, 7, 8, 9, 10};
        System.out.println("\nOriginal array 3:");
        printArray(arr3);
        sorter.sort(arr3);
        System.out.println("Sorted array 3:");
        printArray(arr3);
    }
    
    /**
     * Utility method to print array
     */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}