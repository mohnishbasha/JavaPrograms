package com.algorithms.numbers.squareNumbers;

/*

http://www.geeksforgeeks.org/find-number-perfect-squares-two-given-numbers/

Number of perfect squares between two given numbers
Given two given numbers a and b where 1<=a<=b, find the number of perfect squares between a and b (a and b inclusive).

Examples

Input :  a = 3, b = 8
Output : 1
The only perfect in given range is 4.

Input : a = 9, b = 25
Output : 3
The three squares in given range are 9,
16 and 25

 */


// Java program to count squares between a and b
/*

Method 1 : One naive approach is to check all the numbers between a and b (inclusive a and b) and increase count by one
whenever we encounter a perfect square. Following is the code for the above approach:

 */
class CountSquares1
{
    static int countSquares(int a, int b)
    {
        int cnt = 0; // Initialize result

        // Traverse through all numbers
        for (int i=a; i<=b; i++)

            // Check if current number 'i' is perfect
            // square
            for (int j=1; j*j<=i; j++)
                if (j*j==i)
                    cnt++;
        return cnt;
    }
}


/*

Method 2 (Efficient) We can simply take square root of ‘a’ and square root of ‘b’ and count the perfect squares
between them using

floor(sqrt(b)) - ceil(sqrt(a)) + 1

We take floor of sqrt(b) because we need to consider
numbers before b.

We take ceil of sqrt(a) because we need to consider
numbers after a.


For example, let b = 24, a = 8.  floor(sqrt(b)) = 4,
ceil(sqrt(a)) = 3.  And number of squares is 4 - 3 + 1
= 2. The two numbers are 9 and 16.
Following is the code for the above approach:


Time complexity of this solution is O(Log b). A typical implementation of square root for a number n takes time equal
to O(Log n) [See this for a sample implementation of square root]


 */
class CountSquares2
{
    double countSquares(int a, int b)
    {
        return (Math.floor(Math.sqrt(b)) -
                Math.ceil(Math.sqrt(a)) + 1);
    }
}


// Driver Code
public class CountSquareNumbers
{
    public static void main(String[] args)
    {
        int a = 9, b = 25;
        // method 1
        CountSquares1 obj = new CountSquares1();
        System.out.print("Count of squares is " +
                obj.countSquares(a, b));

        CountSquares2 obj1 = new CountSquares2();
        System.out.print("Count of squares is " +
                (int)obj1.countSquares(a, b));
    }
}