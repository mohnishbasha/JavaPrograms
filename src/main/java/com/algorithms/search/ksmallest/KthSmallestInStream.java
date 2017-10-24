package com.algorithms.search.ksmallest;
/*
asked in cisco:
http://www.geeksforgeeks.org/kth-largest-element-in-a-stream/

Problem:
Given an infinite stream of integers, find the k’th largest data at any point of time.

Example:

Input:
stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
k = 3

Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}
Extra space allowed is O(k).


A Simple Solution is to keep an array of size k. The idea is to keep the array sorted so that the k’th largest data
can be found in O(1) time (we just need to return first data of array if array is sorted in increasing order)

How to process a new data of stream?
For every new data in stream, check if the new data is smaller than current k’th largest data. If yes,
then ignore it. If no, then remove the smallest data from array and insert new data in sorted order.
Time complexity of processing a new data is O(k).


A Better Solution is to use a Self Balancing Binary Search Tree of size k. The k’th largest data can be
found in O(Logk) time.

How to process a new data of stream?
For every new data in stream, check if the new data is smaller than current k’th largest data. If yes, then
ignore it. If no, then remove the smallest data from the tree and insert new data. Time complexity of processing
a new data is O(Logk).


An Efficient Solution is to use Min Heap of size k to store k largest elements of stream. The k’th largest data is
always at root and can be found in O(1) time.

How to process a new data of stream?
Compare the new data with root of heap. If new data is smaller, then ignore it. Otherwise replace root with new
data and call heapify for the root of modified heap. Time complexity of finding the k’th largest data is O(Logk).



 */


public class KthSmallestInStream {

}



/*

// A C++ program to find k'th smallest data in a stream
#include<iostream>
#include<climits>
using namespace std;

// Prototype of a utility function to swap two integers
void swap(int *x, int *y);

// A class for Min Heap
class MinHeap
{
    int *harr; // pointer to array of elements in heap
    int capacity; // maximum possible size of min heap
    int heap_size; // Current number of elements in min heap
public:
    MinHeap(int a[], int size); // Constructor
    void buildHeap();
    void MinHeapify(int i);  //To minheapify subtree rooted with index i
    int parent(int i)  { return (i-1)/2;  }
    int left(int i)    { return (2*i + 1);  }
    int right(int i)   { return (2*i + 2);  }
    int extractMin();  // extracts root (minimum) data
    int getMin()       {  return harr[0]; }

    // to replace root with new node x and heapify() new root
    void replaceMin(int x) { harr[0] = x; MinHeapify(0); }
};

MinHeap::MinHeap(int a[], int size)
{
    heap_size = size;
    harr = a;  // store address of array
}

void MinHeap::buildHeap()
{
    int i = (heap_size - 1)/2;
    while (i >= 0)
    {
        MinHeapify(i);
        i--;
    }
}

// Method to remove minimum data (or root) from min heap
int MinHeap::extractMin()
{
    if (heap_size == 0)
        return INT_MAX;

    // Store the minimum vakue.
    int root = harr[0];

    // If there are more than 1 items, move the last item to root
    // and call heapify.
    if (heap_size > 1)
    {
        harr[0] = harr[heap_size-1];
        MinHeapify(0);
    }
    heap_size--;

    return root;
}

// A recursive method to heapify a subtree with root at given index
// This method assumes that the subtrees are already heapified
void MinHeap::MinHeapify(int i)
{
    int l = left(i);
    int r = right(i);
    int smallest = i;
    if (l < heap_size && harr[l] < harr[i])
        smallest = l;
    if (r < heap_size && harr[r] < harr[smallest])
        smallest = r;
    if (smallest != i)
    {
        swap(&harr[i], &harr[smallest]);
        MinHeapify(smallest);
    }
}

// A utility function to swap two elements
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

// Function to return k'th largest data from input stream
void kthLargest(int k)
{
    // count is total no. of elements in stream seen so far
    int count = 0, x;  // x is for new data

    // Create a min heap of size k
    int *arr = new int[k];
    MinHeap mh(arr, k);


    while (1)
    {
        // Take next data from stream
        cout << "Enter next data of stream ";
        cin >> x;

        // Nothing much to do for first k-1 elements
        if (count < k-1)
        {
            arr[count] = x;
            count++;
        }

        else
        {
          // If this is k'th data, then store it
          // and build the heap created above
          if (count == k-1)
          {
              arr[count] = x;
              mh.buildHeap();
          }

          else
          {
               // If next data is greater than
               // k'th largest, then replace the root
               if (x > mh.getMin())
                  mh.replaceMin(x); // replaceMin calls
                                    // heapify()
          }

          // Root of heap is k'th largest data
          cout << "K'th largest data is "
               << mh.getMin() << endl;
          count++;
        }
    }
}

// Driver program to test above methods
int main()
{
    int k = 3;
    cout << "K is " << k << endl;
    kthLargest(k);
    return 0;
}
Run on IDE
Output

K is 3
Enter next data of stream 23
Enter next data of stream 10
Enter next data of stream 15
K'th largest data is 10
Enter next data of stream 70
K'th largest data is 15
Enter next data of stream 5
K'th largest data is 15
Enter next data of stream 80
K'th largest data is 23
Enter next data of stream 100
K'th largest data is 70
Enter next data of stream
CTRL + C pressed


 */