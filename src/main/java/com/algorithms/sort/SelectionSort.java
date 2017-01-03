package org.algorithms.sort;

/* 0(n^2) */

public class SelectionSort {
	  private long[] a;

	  private int nElems;

	  public SelectionSort(int max) {
	    a = new long[max];
	    nElems = 0;
	  }

	  public void insert(long value) {
	    a[nElems] = value;
	    nElems++;
	  }

	  public void display() {
	    for (int j = 0; j < nElems; j++)
	      System.out.print(a[j] + " ");
	    System.out.println("");
	  }

	  public void selectionSort() {
	    int i, j, min;

	    for (i = 0; i < nElems - 1; i++)
	    {
	      min = i; // minimum
	      for (j = i + 1; j < nElems; j++)
	        if (a[j] < a[min]) // if min greater,
	          min = j; // a new min
	      swap(i, min); // swap them
	    }
	  }

	  private void swap(int one, int two) {
	    long temp = a[one];
	    a[one] = a[two];
	    a[two] = temp;
	  }

	  public static void main(String[] args) {
	    int maxSize = 100;
	    SelectionSort arr; // reference to array
	    arr = new SelectionSort(maxSize); // create the array

	    arr.insert(17); // insert 10 items
	    arr.insert(29);
	    arr.insert(34);
	    arr.insert(45);
	    arr.insert(52);
	    arr.insert(68);
	    arr.insert(71);
	    arr.insert(80);
	    arr.insert(96);
	    arr.insert(33);

	    arr.display();

	    arr.selectionSort();

	    arr.display();
	  }

	}

/*
 * 
 * Method The algorithm works as follows:
 * 
 * Find the minimum value in the list Swap it with the value in the first
 * position Repeat the steps above for remainder of the list (starting at the
 * second position) Effectively, we divide the list into two parts: the sublist
 * of items already sorted, which we build up from left to right and is found 
 * at the beginning, and the sublist of items remaining to be sorted, occupying the
 * remainder of the array.
 */

/*
Here is an example of this sort algorithm sorting five elements:

64 25 12 22 11
11 25 12 22 64

11 12 25 22 64
11 12 22 25 64
*/

/*
 * 
 * Selection sort can also be used on list structures that make add and remove
 * efficient, such as a linked list. In this case it's more common to remove the
 * minimum element from the remainder of the list, and then insert it at the end
 * of the values sorted so far. For example:
 */

/*
64 25 12 22 11
11 64 25 12 22
11 12 64 25 22
11 12 22 64 25
11 12 22 25 64 

*/