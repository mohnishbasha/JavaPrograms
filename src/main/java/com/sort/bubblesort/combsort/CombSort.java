package com.sort.bubblesort.combsort;

/*
http://www.geeksforgeeks.org/comb-sort/
https://www.youtube.com/watch?v=n51GFZHXlYY

Comb Sort is mainly an improvement over Bubble Sort. Bubble sort always compares adjacent values.
So all inversions are removed one by one. Comb Sort improves on Bubble Sort by using gap of size more than 1.
The gap starts with a large value and shrinks by a factor of 1.3 in every iteration until it reaches the value 1.
Thus Comb Sort removes more than one inversion counts with one swap and performs better than Bublle Sort.

The shrink factor has been empirically found to be 1.3 (by testing Combsort on over 200,000 random lists)

Although, it works better than Bubble Sort on average, worst case remains O(n2).


 */

public class CombSort {

    // To find gap between elements
    int getNextGap(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    void sort(int arr[])
    {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++)
            {
                if (arr[i] > arr[i+gap])
                {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    // Driver method
    public static void main(String args[])
    {
        CombSort ob = new CombSort();
        int arr[] = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
        ob.sort(arr);

        System.out.println("sorted array");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");

    }
}

/*
    Run on IDE

        Output :
        Sorted array:
        -44 -6 0 1 3 4 8 23 28 56


        Illustration:

        Let the array elements be
        8, 4, 1, 56, 3, -44, 23, -6, 28, 0
        Initially gap value = 10
        After shrinking gap value => 10/1.3 = 7;

        8 4 1 56 3 -44 23 -6 28 0
        -6 4 1 56 3 -44 23  8 28 0
        -6 4 0 56 3 -44 23  8 28 1
        New gap value => 7/1.3 = 5;

        -44 4 0 56 3 -6 23 8 28 1
        -44 4 0 28 3 -6 23 8 56 1
        -44 4 0 28 1 -6 23 8 56 3
        New gap value => 5/1.3 = 3;

        -44 1  0 28 4 -6 23 8 56 3
        -44 1 -6 28 4  0 23 8 56 3
        -44 1 -6 23 4  0 28 8 56 3
        -44 1 -6 23 4  0  3 8 56 28
        New gap value => 3/1.3 = 2;

        -44 1 -6 0 4 23 3 8 56 28
        -44 1 -6 0 3 23 4 8 56 28
        -44 1 -6 0 3 8 4 23 56 28
        New gap value => 2/1.3 = 1;

        -44 -6 1 0 3 8 4 23 56 28
        -44 -6 0 1 3 8 4 23 56 28
        -44 -6 0 1 3 4 8 23 56 28
        -44 -6 0 1 3 4 8 23 28 56

        no more swaps required (Array sorted)
        Time Complexity : Worst case complexity of this algorithm is O(n2) and the Best Case complexity is O(n).

        Auxiliary Space : O(1).

*/