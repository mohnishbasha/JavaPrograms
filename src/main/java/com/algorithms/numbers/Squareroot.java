package com.algorithms.numbers;

/*
    http://www.geeksforgeeks.org/square-root-of-an-integer/

    Algorithm:
1) Start with 'start' = 0, end = 'x',
2) Do following while 'start' is smaller than or equal to 'end'.
      a) Compute 'mid' as (start + end)/2
      b) compare mid*mid with x.
      c) If x is equal to mid*mid, return mid.
      d) If x is greater, do binary search between mid+1 and end. In this case, we also update ans (Note that we need floor).
      e) If x is smaller, do binary search between start and mid-1

Below is C++ implementation of above idea.

Time Complexity: O(Log x)

 */

// A Java program to find floor(sqrt(x)
public class Squareroot
{
    public static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, res = 0;

        while (start <= end)
        {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if ( mid * mid == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                res = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return res;
    }

    // Driver Method
    public static void main(String args[])
    {
        int x = 11;
        System.out.println(floorSqrt(x));
    }
}
