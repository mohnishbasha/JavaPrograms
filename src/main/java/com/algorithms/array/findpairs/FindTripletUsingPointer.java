package com.algorithms.array.findpairs;

/**
 * URL:
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *
 */



class FindTripletUsingPointer {

    // returns true if there is triplet with sum equal
    // to 'sum' present in A[]. Also, prints the triplet
    boolean find3Numbers(int A[], int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        // -----
        // quickSort(A, 0, arr_size - 1);

        /* Now fix the first data one by one and find the
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) {
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first data in the remaining elements
            r = arr_size - 1; // index of the last data
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + " ," + A[l]
                            + " ," + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}