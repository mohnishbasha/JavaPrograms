package com.algorithms.sort.quicksort;

public class QuickSortSimpleVersion {
	  private long[] data;

	  private int len;

	  public QuickSortSimpleVersion(int max) {
	    data = new long[max];
	    len = 0;
	  }

	  public void insert(long value) {
	    data[len] = value; 
	    len++;
	  }

	  public void display() {
	    System.out.print("Data");
	    for (int j = 0; j < len; j++)
	      System.out.print(data[j] + " ");
	    System.out.println("");
	  }

	  public void quickSort() {
		  recQuickSort(0, len - 1);
	  }

	  public void recQuickSort(int left, int right) {
	    if (right - left <= 0) // if size <= 1 already sorted
	      return;
	    else // size is 2 or larger
	    {
	      long pivot = data[right]; // rightmost item
	      // partition range
	      int partition = partitionData(left, right, pivot);
	      recQuickSort(left, partition - 1); // sort left side
	      recQuickSort(partition + 1, right); // sort right side
	    }
	  }

	  public int partitionData(int left, int right, long pivot) {
	    int leftPtr = left - 1; // left (after ++)
	    int rightPtr = right; // right-1 (after --)
	    while (true) { // find bigger item
	      while (data[++leftPtr] < pivot)
	        ;
	      // find smaller item
	      while (rightPtr > 0 && data[--rightPtr] > pivot)
	        ;

	      if (leftPtr >= rightPtr) // if pointers cross, partition done
	        break;
	      else
	        swap(leftPtr, rightPtr);
	    }
	    swap(leftPtr, right); // restore pivot and return pivot location
	    return leftPtr;
	  }

	  public void swap(int d1, int d2) {
	    long temp = data[d1];
	    data[d1] = data[d2];
	    data[d2] = temp;
	  }

	  public static void main(String[] args) {
	    int maxSize = 16; // array size
	    QuickSortSimpleVersion arr = new QuickSortSimpleVersion(maxSize); // create array

	    for (int j = 0; j < maxSize; j++) // fill array with random numbers
	    {
	      long n = (int) (java.lang.Math.random() * 99);
	      arr.insert(n);
	    }
	    arr.display();
	    arr.quickSort();
	    arr.display();
	  }

	}

