package com.sort;

/*

G4G:
http://quiz.geeksforgeeks.org/shellsort/

ShellSort
ShellSort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead. When an
 data has to be moved far ahead, many movements are involved. The idea of shellSort is to allow exchange of far
 items. In shellSort, we make the array h-sorted for a large value of h. We keep reducing the value of h until it
 becomes 1. An array is said to be h-sorted if all sublists of every h’th data is sorted.


 */

/* O (n log^2 n ) - worst case */

public class ShellSort {
	  private long[] a;
	  private static ShellSort arr = null;

	  private int len;

	  public ShellSort(int max) {
	    a = new long[max];
	    len = 0;
	  }

	  public void insert(long value){
	    a[len] = value;
	    len++;
	  }

	  public void display() {
	    System.out.print("Data:");
	    for (int j = 0; j < len; j++)
	      System.out.print(a[j] + " ");
	    System.out.println("");
	  }

	  public void shellSort() {
	    int j, i;
	    long key;
	    //find initial value of h
	    int h = 1;

	    while (h <= len / 3)
	      h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

	    while (h > 0) // decreasing h, until h=1
	    {
	      // h-sort the file
	      for (i = h; i < len; i++) {
	        j = i;
	        key = a[j];

			  // one subpass (eg 0, 4, 8)
	        while (j > h - 1 && a[j - h] >= key) {
	          a[j] = a[j - h];
	          j -= h;
	        }

	        a[j] = key;
	      }

	      arr.display();
	      h = (h - 1) / 3; // decrease h
	    }
	  }

	  public static void main(String[] args) {
	    int maxSize = 27; // try w different length size 12 17 27 43
	    arr = new ShellSort(maxSize);

	    for (int j = 0; j < maxSize; j++) {
	      long n = (int) (java.lang.Math.random() * 99);
	      arr.insert(n);
	    }
	    arr.display();
	    arr.shellSort();
	   // arr.display();
	  }



        /* function to sort arr using shellSort */
        public int geeks4geeksShellSort(int arr[])
        {
            int n = arr.length;

            // Start with a big gap, then reduce the gap
            for (int gap = n/2; gap > 0; gap /= 2)
            {
                // Do a gapped insertion sort for this gap size.
                // The first gap elements a[0..gap-1] are already
                // in gapped order keep adding one more data
                // until the entire array is gap sorted
                for (int i = gap; i < n; i += 1)
                {
                    // add a[i] to the elements that have been gap
                    // sorted save a[i] in temp and make a hole at
                    // position i
                    int temp = arr[i];

                    // shift earlier gap-sorted elements up until
                    // the correct location for a[i] is found
                    int j;
                    for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                        arr[j] = arr[j - gap];

                    // put temp (the original a[i]) in its correct
                    // location
                    arr[j] = temp;
                }
            }
            return 0;
        }

	}

/*
 * 
 * Implementation The original implementation performs O(n2) comparisons and
 * exchanges in the worst case. A minor change given in V. Pratt's book[3]
 * improved the bound to O(n log2 n). This is worse than the optimal comparison
 * sorts, which are O(n log n).
 * 
 * Shell sort improves insertion sort by comparing elements separated by a gap
 * of several positions. This lets an data take "bigger steps" toward its
 * expected position. Multiple passes over the data are taken with smaller and
 * smaller gap sizes. The last step of Shell sort is a plain insertion sort, but
 * by then, the array of data is guaranteed to be almost sorted.
 * 
 * 
 * Consider a small value that is initially stored in the wrong end of the
 * array. Using an O(n2) sort such as bubble sort or insertion sort, it will
 * take roughly n comparisons and exchanges to move this value all the way to
 * the other end of the array. Shell sort first moves values using giant step
 * sizes, so a small value will move a long way towards its final position, with
 * just a few comparisons and exchanges.
 * 
 * One can visualize Shell sort in the following way: arrange the list into a
 * table and sort the columns (using an insertion sort). Repeat this process,
 * each time with smaller number of longer columns. At the end, the table has
 * only one column. While transforming the list into a table makes it easier to
 * visualize, the algorithm itself does its sorting in-place (by incrementing
 * the index by the step size, i.e. using i += step_size instead of i++).
 */

/*
For example, consider a list of numbers like [ 13 14 94 33 82 25 59 94 65 23 45 27 73 25 39 10 ]. If we started with a step-size of 5, we could visualize this as breaking the list of numbers into a table with 5 columns. This would look like this:

*/

/*
13 14 94 33 82
25 59 94 65 23
45 27 73 25 39
10
We then sort each column, which gives us

10 14 73 25 23
13 27 94 33 39
25 59 94 65 82
45

*/