package org.algorithms.search;

public class BinarySearch {

	/* Snippet: Binary Search
	 * Author: SPlutard
	 *
	 *Description: An efficient method for searching SORTED arrays. Returns the number if found, otherwise returns -1.
	 */

	public static int binarySearch(Integer[] list, int listLength, int searchItem) {
	    int first=0;
	    int last = listLength - 1;
	    int mid=0;
	    
	    boolean found = false;
	    
	    //Loop until found or end of list.
	    while(first <= last &&!found) {
	        //Find the middle.
	        mid = (first + last) /2;
	        
	        //Compare the middle item to the search item.
	        if(list[mid] == searchItem) found = true;
	        else { //Not found, readjust search parameters, halving the size & start over.
	            if(list[mid] > searchItem) last = mid -1;
	            else first = mid + 1;
	        }
	    }
	    
	    if(found) return mid;
	    else return(-1);
	}
	
	 public static void main( String [ ] args )
	    {
	        int SIZE = 8;
	        Integer [ ] a = new Integer [ SIZE ];
	        for( int i = 0; i < SIZE; i++ )
	            a[ i ] = i * 2;

	        for( int i = 0; i < SIZE * 2; i++ )
	            System.out.println( "Found " + i + " at " +
	                                 binarySearch( a,SIZE, i ) );

	    }
}
