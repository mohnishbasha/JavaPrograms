package com.algorithms.search.ksmallest.solutions;

/*
Expected Linear Time
http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/

 Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest data in the
  given array. It is given that ll array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10


 In this post method 4 is discussed which is mainly an extension of method 3 (QuickSelect) discussed in the previous
  post. The idea is to randomly pick a pivot data. To implement randomized partition, we use a random function,
  rand() to generate index between l and r, swap the data at randomly generated index with the last data, and
  finally call the standard partition process which uses last data as pivot.

Following is implementation of above Randomized QuickSelect.

 */

public class KthSmallest_Set2 {


    // This function returns k'th smallest data in arr[l..r]
    // using QuickSort based method.  ASSUMPTION: ALL ELEMENTS
    // IN ARR[] ARE DISTINCT
    int KthSmallest_Set2(int arr[], int l, int r, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {
            // Partition the array around a random data and
            // get position of pivot data in sorted array
            int pos = randomPartition(arr, l, r);

            // If position is same as k
            if (pos-l == k-1)
                return arr[pos];

            // If position is more, recur for left subarray
            if (pos-l > k-1)
                return KthSmallest_Set2(arr, l, pos-1, k);

            // Else recur for right subarray
            return KthSmallest_Set2(arr, pos+1, r, k-pos+l-1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process of QuickSort().  It considers
    // the last data as pivot and moves all smaller data
    // to left of it and greater elements to right. This function
    // is used by randomPartition()
    int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // Picks a random pivot data between l and r and
    // partitions arr[l..r] arount the randomly picked
    // data using partition()
    int randomPartition(int arr[], int l, int r)
    {
        int n = r-l+1;
        int pivot = (int)(Math.random()) % n;
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    // Driver method to test above
    public static void main(String args[])
    {
        KthSmallest_Set2 ob = new KthSmallest_Set2();
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length,k = 3;
        System.out.println("K'th smallest data is "+
                ob.KthSmallest_Set2(arr, 0, n-1, k));
    }
}
