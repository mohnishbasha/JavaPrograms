package com.sort.countingsort;

/*
 
Counting Sort is a non-comparison-based sorting algorithm that sorts integers or objects that can be mapped to integers (like characters or other discrete objects) by counting the occurrences of each unique element in the input. It is particularly efficient when the range of input values (e.g., the difference between the maximum and minimum values) is not significantly larger than the number of elements to be sorted.

### How Counting Sort Works:

1. **Find the Range**: Determine the minimum and maximum values in the array to define the range of possible values.

2. **Count Occurrences**: Create a "count array" (of size equal to the range of values) to store the count of each unique element in the input array.

3. **Cumulative Count**: Modify the count array to store cumulative counts, which helps in placing elements in their correct sorted position.

4. **Build the Sorted Array**: Traverse the input array, and for each element, use the cumulative count array to place it in the correct position in the output array. Decrement the count in the count array after placing each element.

5. **Copy Back (Optional)**: Copy the sorted output array back to the original array if needed.

### Properties of Counting Sort:
- **Time Complexity**: O(n + k), where `n` is the number of elements in the input array and `k` is the range of the input values.
- **Space Complexity**: O(k) for the count array and an additional O(n) for the output array.
- **Stable**: Counting Sort is stable if implemented correctly, meaning that the relative order of equal elements remains the same.

### When to Use Counting Sort:
- It is efficient for sorting integers or discrete elements with a limited range.
- It is not suitable for sorting data with a very large range or floating-point numbers.

### Example:

Input array: `[4, 2, 2, 8, 3, 3, 1]`

Steps:
1. Find range: Min = 1, Max = 8 (range = 8 - 1 + 1 = 8).
2. Count occurrences:
   ```
   Count array: [0, 1, 2, 2, 1, 0, 0, 0, 1]
   (index corresponds to the number, and the value at each index is its count)
   ```
3. Cumulative count:
   ```
   Count array: [0, 1, 3, 5, 6, 6, 6, 6, 7]
   ```
4. Build sorted array:
   ```
   Sorted array: [1, 2, 2, 3, 3, 4, 8]
   ```

This is how Counting Sort produces a sorted array efficiently without comparisons.

 * 
 */

/*

https://www.youtube.com/watch?v=TTnvXY82dtM

Counting Sort
Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects
 having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in
 the output sequence.

Let us understand it with the help of an example.

For simplicity, consider the data in the range 0 to 9.
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each data at each index
  stores the sum of previous counts.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in
the output sequence.

  3) Output each object from the input sequence followed by
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2.

  Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place
  next data 1 at an index 1 smaller than this index.



Output:
Sorted character array is eeeefggkkorss
Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
Auxiliary Space: O(n+k)

Points to be noted:
1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
3. It is often used as a sub-routine to another sorting algorithm like radix sort.
4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
5. Counting sort can be extended to work for negative inputs also.

Exercise:
1. Modify above code to sort the input data in the range from M to N.
2. Modify above code to sort negative input data.
3. Is counting sort stable and online?
4. Thoughts on parallelizing the counting sort algorithm.



Input: 9 4 10 8 2 4
Create Index from 2 to 10
Index     2 3 4 5 6 7 8 9 10
Count     1 0 2 0 0 0 1 1 1
Sum       1 1 3 3 3 3 4 5 6
Sum       1 1 1 3 3 3 3 4 5 - subs 1 everytime inserted in output

Input Index  1 2 3 4 5 6
Output       2 4 4 8 9 10

 */

class CountingSortG4G
{
    void sort(char arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        char out[] = new char[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i=0; i<n; ++i)
            count[arr[i]] = count[arr[i]] + 1; // ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            out[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = out[i];
    }

    void intSort(int arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        int out[] = new int[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i=0; i< n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        // IMP STEP **
        for (int i=1; i <= 256 - 1; ++i)
            count[i] += count[i-1];

        // Build the output int array
        for (int i = 0; i < n; ++i)
        {
            out[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = out[i];
    }

    // Driver method
    public static void main(String args[])
    {
        CountingSortG4G ob = new CountingSortG4G();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };

        ob.sort(arr);

        System.out.println("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]);

        int intarr[] = {1,2,3,4,5,2,1,3,7,3,5,6,7,4,9,3,4,7};

        ob.intSort(intarr);

        System.out.println("\nSorted int array is ");
        for (int i=0; i<intarr.length; ++i)
            System.out.print(intarr[i]);
    }
}