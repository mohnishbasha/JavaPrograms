package com.algorithms.sort;

/* 0(n^2) */

public class InsertionSort {
	  private long[] number;

	  private int nElems;

	  public InsertionSort(int max) {
	    number = new long[max];
	    nElems = 0;
	  }

	  public void insert(long value) {
	    number[nElems] = value;
	    nElems++;
	  }

	  public void display() {
	    for (int j = 0; j < nElems; j++)
	      System.out.print(number[j] + " ");
	    System.out.println("");
	  }

	  public void insertionSort() {
	    int in, out;
	    //     out is dividing line
	    for (out = 1; out < nElems; out++) {
	      long temp = number[out]; // remove marked item
	      in = out; // start shifts at out
	      while (in > 0 && number[in - 1] >= temp) // until one is smaller,
	      {
	        number[in] = number[in - 1]; // shift item to right
	        --in; // go left one position
	      }
	      number[in] = temp; // insert marked item
	    }
	  }
	  /*
	   * public class InsertionSorter
	  {
	      private static int[] a;
	      private static int n;

	      public static void sort(int[] a0)
	      {
	          a=a0;
	          n=a.length;
	          insertionsort();
	      }

		// https://www.youtube.com/watch?v=lCDZ0IprFw4&t=167s

	      private static void insertionsort()
	      {
	          int i, j, key;
	          for (i=1; i<n; i++)
	          {
	              j = i;
	              key = a[j];
	              while ( j>0 && a[j-1] > key)
	              {
	                  a[j]=a[j-1];
	                  j--;
	              }
	              a[j] = key;
	          }
	      }

	  } */


      public static int[] sort(int[] A) {

          for (int i = 1; i < A.length; i++) {
              int key = A[i];
              int j = i - 1;

              while( j >= 0 && A[j] > key) {
                  A[j+1] = A[j];
                  j--;
              }
              A[j+1] = key;

          }
          return A;
      }

	  public static void main(String[] args) {
	    int maxSize = 100; // array size
	    InsertionSort arr; // reference to array
	    arr = new InsertionSort(maxSize); // create the array

	    arr.insert(47);
	    arr.insert(99);
	    arr.insert(44);
	    arr.insert(35);
	    arr.insert(22);
	    arr.insert(88);
	    arr.insert(41);
	    arr.insert(00);
	    arr.insert(16);
	    arr.insert(33);

	    arr.display();

	    arr.insertionSort();

	    arr.display();


       // int[] numbers = {10, 5, 3, 7, 2};
       //   sort(numbers);

	  }
}

/*
 * Insertion sort is an elementary sorting algorithm. It has a time complexity
 * of Θ(n2), thus being slower than heapsort, merge sort and also shellsort.
 * Insertion sort is well suited for sorting small data sets or for the
 * insertion of new elements into a sorted sequence.
 * 
 * 
 * 
 * Idea Let a0, ..., an-1 be the sequence to be sorted. At the beginning and
 * after each iteration of the algorithm the sequence consists of two parts: the
 * first part a0, ..., ai-1 is already sorted, the second part ai, ..., an-1 is
 * still unsorted (i 0, ..., n).
 * 
 * In order to insert element ai into the sorted part, it is compared with ai-1,
 * ai-2 etc. When an element aj with ajai is found, ai is inserted behind it. If
 * no such element is found, then ai is inserted at the beginning of the
 * sequence.
 * 
 * After inserting element ai the length of the sorted part has increased by
 * one. In the next iteration, ai+1 is inserted into the sorted part etc. While
 * at the beginning the sorted part consists of element a0 only, at the end it
 * consists of all elements a0, ..., an-1.
 * 
 * Example: The following table shows the steps for sorting the sequence 5 7 0 3
 * 4 2 6 1. On the left side the sorted part of the sequence is shown in red.
 * For each iteration, the number of positions the inserted element has moved is
 * shown in brackets. Altogether this amounts to 17 steps.
 */

/* 

5- 7 0 3 4 2 6 1   (0) 
5 7- 0 3 4 2 6 1   (0) 
0 5 7- 3 4 2 6 1   (2) 
0 3 5 7- 4 2 6 1   (2) 
0 3 4 5 7- 2 6 1   (2) 
0 2 3 4 5 7- 6 1   (4) 
0 2 3 4 5 6 7- 1   (1) 
0 1 2 3 4 5 6 7-   (6) 

*/
