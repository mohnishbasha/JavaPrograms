package com.sort.dnp;

/*

There is an array which has numbers in categories(Low, Medium, High) something like
2 1 3 5 7 9 6
H M H L M L M


You have to sort the numbers according to the category. So after sorting the output of above array will be-
5 9 1 7 6 2 3
L L M M M H H

The input to the function is just an array. And you can assume that you have helper functions which tell if number belong to this category or not,
isHigh(n), isLow(n), isMedium(n)


// l, m, h
2 1 3 5 7 9 6
H M H L M L M

l           h
m

void sort(int a[]) {

   // base condition
   if (a == null) {
       return;
   }

   int l, m = 0;
   int h = a.size - 1;
   int tmp = 0;

   while(m <= h) {

       // if med
       if( isMedium(a[m]) ) {
           m++;
       }

       // if low
       else if ( isLow(a[m) ) {
            tmp = a[m];
            a[m] = a[l];
            a[l] = tmp;
            l++;
            m++;
       }

       // if high
       else if ( isHigh(a[m) ) {
            tmp = a[m];
            a[m] = a[h];
            a[h] = tmp;
            h--;
       }
   }
}

0 1 2 3 4 5 6
2 1 3 5 7 9 6
H M H L M L M

l=0
m=0
h=6

6 1 3 5 7 9 2
M M H L M L H

h = 5
l=0
6 1 3 5

 */

public class VeritasInPlaceSort {
}
