package com.sort.heap;

/*  O(n log n) */

import java.io.IOException;

class HeapNode {

  private int key;

  public HeapNode(int key) {
    this.key = key;
  }

  public int getKey() {
    return key;
  }

}

public class Heap {

  private HeapNode[] heapArray;

  private int maxSize;

  private int currentSize; // number of items in array

  public Heap(int mx) {
    maxSize = mx;
    currentSize = 0;
    heapArray = new HeapNode[maxSize];
  }

  public HeapNode remove()
  { 
    HeapNode root = heapArray[0];
    heapArray[0] = heapArray[--currentSize];
    trickleDown(0);
    return root;
  }

  public void trickleDown(int index) {
    int largerChild;

    HeapNode top = heapArray[index];
    HeapNode top1 = heapArray[index];

    if(top == top1){
    	
    }

    while (index < currentSize / 2)
    {
      int leftChild = 2 * index + 1;
      int rightChild = leftChild + 1;
      // find larger child
      if (rightChild < currentSize
          && 
          heapArray[leftChild].getKey() < heapArray[rightChild]
              .getKey())
        largerChild = rightChild;
      else
        largerChild = leftChild;

      if (top.getKey() >= heapArray[largerChild].getKey())
        break;

      heapArray[index] = heapArray[largerChild];
      index = largerChild; 
    }

    heapArray[index] = top;
  }

  public void displayHeap() {

    int nBlanks = 32;
    int itemsPerRow = 1;
    int column = 0;
    int currentIndex = 0; 
    while (currentSize > 0)
    {
      if (column == 0) 
        for (int k = 0; k < nBlanks; k++)
          System.out.print(' ');
      System.out.print(heapArray[currentIndex].getKey());

      if (++currentIndex == currentSize) // done?
        break;

      if (++column == itemsPerRow) // end of row?
      {
        nBlanks /= 2; 
        itemsPerRow *= 2; 
        column = 0; 
        System.out.println(); 
      } else
        for (int k = 0; k < nBlanks * 2 - 2; k++)
          System.out.print(' '); // interim blanks
    } 
  }

  public void displayArray() {
    for (int j = 0; j < maxSize; j++)
      System.out.print(heapArray[j].getKey() + " ");
    System.out.println("");
  }

  public void insertAt(int index, HeapNode newNode) {
    heapArray[index] = newNode;
  }

  public void incrementSize() {
    currentSize++;
  }

  public static void main(String[] args) throws IOException {

    int size, i;
    size = 100;

    Heap theHeap = new Heap(size);

    for (i = 0; i < size; i++) {
      int random = (int) (java.lang.Math.random() * 100);
      HeapNode newNode = new HeapNode(random);
      theHeap.insertAt(i, newNode);
      theHeap.incrementSize();
    }

    System.out.print("Random: ");
    theHeap.displayArray();
    for (i = size / 2 - 1; i >= 0; i--)
      theHeap.trickleDown(i);

    System.out.print("Heap:   ");
    theHeap.displayArray();
    theHeap.displayHeap();
    for (i = size - 1; i >= 0; i--) {
      HeapNode biggestNode = theHeap.remove();
      theHeap.insertAt(i, biggestNode);
    }
    System.out.print("Sorted: ");
    theHeap.displayArray();
  }
}

/*
 * Overview The heap sort works as its name suggests - it begins by building a
 * heap out of the data set, and then removing the largest item and placing it
 * at the end of the sorted array. After removing the largest item, it
 * reconstructs the heap and removes the largest remaining item and places it in
 * the next open position from the end of the sorted array. This is repeated
 * until there are no items left in the heap and the sorted array is full.
 * Elementary implementations require two arrays - one to hold the heap and the
 * other to hold the sorted elements. [1]
 * 
 * Heapsort inserts the input list elements into a heap data structure. The
 * largest value (in a max-heap) or the smallest value (in a min-heap) are
 * extracted until none remain, the values having been extracted in sorted
 * order. The heap's invariant is preserved after each extraction, so the only
 * cost is that of extraction.
 * 
 * During extraction, the only space required is that needed to store the heap.
 * In order to achieve constant space overhead, the heap is stored in the part
 * of the input array that has not yet been sorted. (The structure of this heap
 * is described at Binary heap: Heap implementation.)
 * 
 * Heapsort uses two heap operations: insertion and root deletion. Each
 * extraction places an data in the last empty location of the array. The
 * remaining prefix of the array stores the unsorted elements.
 */

