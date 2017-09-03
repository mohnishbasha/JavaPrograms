package com.algorithms.array.strings.removeduplicate;

/*
Telephonic: ServiceNow

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory. For example, Given input
array A = [1,1,2], Your function should return length = 2, and A is now [1,2].

https://gist.github.com/guolinaileen/4670376

 */

public class RemoveDuplicatesInPlace {



    public int removeDuplicatesInPlace(int[] A) {
        int length=A.length;
        if(length==0 || length==1) return length;
        int i=1;
        for(int j=1; j<length; j++)
        {
            if(A[j]!=A[j-1])
            {
                A[i]=A[j];
                i++;
            }
        }
        if(i<length) A[i]='\0';
        return i;
    }

    // Function to remove duplicate elements
    // This function returns new size of modified
    // array.
    // http://www.geeksforgeeks.org/remove-duplicates-sorted-array/

    /*

        Remove duplicates from sorted array
            Given a sorted array, the task is to remove the duplicate elements from the array.

            Examples:

            Input  : arr[] = {2, 2, 2, 2, 2}
            Output : arr[] = {2}
                     new size = 1

            Input  : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
            Output : arr[] = {1, 2, 3, 4, 5}
                     new size = 5
            Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.

            Method 1: (Using extra space)

            Create an auxiliary array temp[] to store unique elements.
            Traverse input array and one by one copy unique elements of arr[] to temp[]. Also keep track of count of
            unique elements. Let this count be j.

            Copy j elements from temp[] to arr[] and return j

     */

    /*
        Output:
            1 2 3 4 5
            Time Complexity : O(n)
            Auxiliary Space : O(1)
     */
    static int removeDuplicatesInPlace1(int arr[], int n)
    {
        if (n==0 || n==1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i=0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];

        arr[j++] = arr[n-1];

        return j;
    }

    // Function to remove duplicate elements
    // This function returns new size of modified
    // array.
    /*
        Output:
            1 2 3 4 5
            Time Complexity : O(n)
            Auxiliary Space : O(n)
     */
    static int removeDuplicates(int arr[], int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;

        int[] temp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];

        // Modify original array
        for (int i=0; i<j; i++)
            arr[i] = temp[i];

        return j;
    }


}
