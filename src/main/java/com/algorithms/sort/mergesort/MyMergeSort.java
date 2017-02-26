package com.algorithms.sort.mergesort;

/*


- See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.waAy8Cwi.dpuf


 */
public class MyMergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]){

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;
            // Below step sorts the left side of the array
            doMergeSort(l, m);
            // Below step sorts the right side of the array
            doMergeSort(m + 1, r);
            // Now merge both sides
            mergeParts(l, m, r);
        }
    }

    private void mergeParts(int l, int m, int r) {

        for (int i = l; i <= r; i++) {
            tempMergArr[i] = array[i];
        }
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}