package com.algorithms.sort.quicksort;

/*

QuickSort
- does in place sort
- doesnt require extra space
- better for sorting arrays

Quiz:
http://quiz.geeksforgeeks.org/quiz-quicksort/

MergeSort:
- requires extra space of O(n)
- better for sorting linked lists


 */

/*
Read:
http://quiz.geeksforgeeks.org/quick-sort/

QuickSort
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given
array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.

The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot,
 put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all
 greater elements (greater than x) after x. All this should be done in linear time.

We strongly recommend that you click here and practice it, before moving on to the solution.

Partition Algorithm
There can be many ways to do partition, following code adopts the method given in CLRS book. The logic is simple,
we start from the leftmost element and keep track of index of smaller (or equal to) elements as i. While traversing,
if we find a smaller element, we swap current element with arr[i]. Otherwise we ignore current element.

Implementation:
Following are C++, Java and Python implementations of QuickSort.

 */

// Java program for implementation of QuickSort
class QuickSortG4G
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */

    int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];
        int pIndex = (start - 1); // index of smaller element // set to -1

        for (int i=start; i <= end-1; i++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[i] <= pivot)
            {
                // swap arr[i] and arr[j]
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;

                pIndex++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[pIndex+1];
        arr[pIndex+1] = arr[end];
        arr[end] = temp;

        return pIndex+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int start, int end)
    {
        if (start < end)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pIndex = partition(arr, start, end);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, start, pIndex-1);
            sort(arr, pIndex+1, end);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSortG4G ob = new QuickSortG4G();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
