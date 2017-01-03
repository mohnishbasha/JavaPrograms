package com.algorithms.sort.mergesort;

/* O(n log n) */

public class MergeSortArray {
	private long[] theArray;

	private int nElems;

	public MergeSortArray(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}

	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) // if range is 1,
			return; // no use sorting
		else { // find midpoint
			int mid = (lowerBound + upperBound) / 2;
			// sort low half
			recMergeSort(workSpace, lowerBound, mid);
			// sort high half
			recMergeSort(workSpace, mid + 1, upperBound);
			// merge them
			merge(workSpace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items

		while (lowPtr <= mid && highPtr <= upperBound)
			if (theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];

		while (lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];

		while (highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];

		for (j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];
	}

	public static void main(String[] args) {
		int maxSize = 100; // array size
		MergeSortArray arr = new MergeSortArray(maxSize); // create the array

		arr.insert(14);
		arr.insert(21);
		arr.insert(43);
		arr.insert(50);
		arr.insert(62);
		arr.insert(75);
		arr.insert(14);
		arr.insert(2);
		arr.insert(39);
		arr.insert(5);
		arr.insert(608);
		arr.insert(36);

		arr.display();

		arr.mergeSort();

		arr.display();
	}
}

/*
 * 
 * Merge sort Main article: Merge sort Merge sort takes advantage of the ease of
 * merging already sorted lists into a new sorted list. It starts by comparing
 * every two elements (i.e., 1 with 2, then 3 with 4...) and swapping them if
 * the first should come after the second. It then merges each of the resulting
 * lists of two into lists of four, then merges those lists of four, and so on;
 * until at last two lists are merged into the final sorted list. Of the
 * algorithms described here, this is the first that scales well to very large
 * lists, because its worst-case running time is O(n log n).
 */

/*
 * Conceptually, a merge sort works as follows:
 * 
 * If the list is of length 0 or 1, then it is already sorted. Otherwise: Divide
 * the unsorted list into two sublists of about half the size. Sort each sublist
 * recursively by re-applying merge sort. Merge the two sublists back into one
 * sorted list. Merge sort incorporates two main ideas to improve its runtime:
 * 
 * A small list will take fewer steps to sort than a large list. Fewer steps are
 * required to construct a sorted list from two sorted lists than two unsorted
 * lists. For example, you only have to traverse each list once if they're
 * already sorted (see the merge function below for an example implementation).
 */
