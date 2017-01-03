package com.algorithms.sort.quicksort;

/*

Read:
http://www.geeksforgeeks.org/3-way-quicksort/

In simple QuickSort algorithm, we select an element as pivot, partition the array around pivot and recur for
subarrays on left and right of pivot.
Consider an array which has many redundant elements. For example, {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4,
4, 4}. If 4 is picked as pivot in Simple QuickSort, we fix only one 4 and recursively process remaining occurrences.

The idea of 3 way QuickSort is to process all occurrences of pivot.

In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
a) arr[l..i] elements less than pivot.
b) arr[i+1..j-1] elements equal to pivot.
c) arr[j..r] elements greater than pivot.

 */

public class ThreeWayQuickSort {


}
