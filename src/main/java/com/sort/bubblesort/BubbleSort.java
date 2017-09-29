package com.sort.bubblesort;

/* 0(n^2) */

public class BubbleSort {
	private long[] a;

	private int nElems;

	public BubbleSort(int max) {
		a = new long[max];
		nElems = 0;
	}

	// put element into array
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	// displays array contents
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public void bubbleSort() {
	    int out, in;

	    for (out = nElems - 1; out > 1; out--)
	      // outer loop (backward)
	      for (in = 0; in < out; in++)
	        // inner loop (forward)
	        if (a[in] > a[in + 1]) // out of order?
	          swap(in, in + 1); // swap them
	    /* 
	      for (i=0; i<n-1; i++) {
			for (j=0; j<n-1-i; j++)
  			if (a[j+1] < a[j]) {  
    				tmp = a[j];         
   	 			a[j] = a[j+1];
   	 			a[j+1] = tmp;
			}
		} */
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	public static void main(String[] args) {
		int maxSize = 100; // array size
		BubbleSort arr; // reference to array
		arr = new BubbleSort(maxSize);

		arr.insert(77); // insert 10 items
		arr.insert(66);
		arr.insert(44);
		arr.insert(34);
		arr.insert(22);
		arr.insert(88);
		arr.insert(12);
		arr.insert(00);
		arr.insert(55);
		arr.insert(33);

		arr.display();

		arr.bubbleSort();

		arr.display();
	}
}
