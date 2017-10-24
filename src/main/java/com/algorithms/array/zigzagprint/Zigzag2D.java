package com.algorithms.array.zigzagprint;

/*
http://www.geeksforgeeks.org/print-given-matrix-zigzag-form/


Print a given matrix in zigzag form
Given a 2D array, print it in zigzag form.
Examples:

Input :
        1    2   3   4   5
        6    7   8   9   10
        11   12  13  14  15
        16  17  18  19   20
Output :
1 2 3 4 5 10 9 8 7 6 11 12 13 14 15 20 19 18 17 16


Input :
        10    24   32
        50    6    17
        99    10   11

Output :
10 24 32 17 6 50 99 10 11

 */

// Java program to print matrix in zig-zag form

public class Zigzag2D
{
    // Method to print matrix in zig-zag form
    static  void printZigZag(int row, int col, int a[][])
    {
        int evenRow = 0; //starts from the first row
        int oddRow = 1; //starts from the next row

        while (evenRow<row && oddRow<row)
        {
            for (int i=0;i<col;i++)
            {
                // evenRow will be printed in the same direction
                System.out.print(a[evenRow][i] + " ");
            }

            // Skipping next row so as to get the next evenRow
            evenRow = evenRow + 2;

            for (int i=col-1; i>=0; i--)
            {
                // oddRow will be printed in the opposite direction
                System.out.print(a[oddRow][i] + " ");
            }

            // Skipping next row so as to get the next oddRow
            oddRow = oddRow + 2;
        }
    }

    public static void main(String[] args)
    {

        int r = 4, c = 5;
        int mat[][] = { {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };


        printZigZag(r , c , mat);
    }
}