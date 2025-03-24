package com.sort.mergesort;

/*

- See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.waAy8Cwi.dpuf

 */
public class MyMergeSort {

    private int[] array;           // Main array
    private int[] tempMergeArray;     // Temporary array for merging
    private int length;            // Array length

    public void sort(int inputArray[]) {
        this.array = inputArray;
        this.length = inputArray.length;
        this.tempMergeArray = new int[length];    // Create temp array
        doMergeSort(0, length - 1);            // Start recursive sorting
    }

    private void doMergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;           // Find middle point
            
            doMergeSort(l, m);                 // Sort left half
            doMergeSort(m + 1, r);             // Sort right half
            mergeParts(l, m, r);               // Merge sorted halves
        }
    }

    private void mergeParts(int l, int m, int r) {

        // Copy to temp array
        for (int i = l; i <= r; i++) {
            tempMergeArray[i] = array[i];
        }
        
        int i = l;      // Left array index
        int j = m + 1;  // Right array index
        int k = l;      // Merged array index
        
        // Compare and merge
        while (i <= m && j <= r) {
            if (tempMergeArray[i] <= tempMergeArray[j]) {
                array[k] = tempMergeArray[i];
                i++;
            } else {
                array[k] = tempMergeArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i <= m) {
            array[k] = tempMergeArray[i];
            k++;
            i++;
        }

    }

    public static void main(String a[]){

        int[] inputArray = {45,23,11,89,77,98,4,28,65,43};
        
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArray);

        for(int i:inputArray){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}