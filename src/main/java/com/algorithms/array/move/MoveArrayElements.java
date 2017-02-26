package com.algorithms.array.move;

/*

    // Move non-zero elements once either one cell straight down or one cell diagonally down (down and right).
    // If the destination cell is occupied (non-zero element), don't move the element.

    int mat1[][] =
    {
        { 0, 1, 0, 7, 2 },     // {0,0}, {0,1}, {0, 2} ....
        { 0, 0, 3, 0, 0 },     // {1,0}, {1, 1}, {1, 2} ....
        { 5, 0, 3, 0, 6 },
        { 3, 4, 0, 0, 0 }, // n - 1, m - 1
        { 8, 2, 0, 9, 4 }, // out of bound n, m
    };

   public void move(int mat1[n][m]) {

   if(mat1 == null)
       return;

   // n < 2

    for(int i=0; i < n - 1; i++) {

       for(int j = 0; j < m; j++) {

           if( a[i+1][j] == 0 ) {
               // swap();
           } else if( j+1 < m && a[i+1][j+1] == 0) {  // out of bound a[n][m]
                // swap()
           }
       }

    }

   }



 */
public class MoveArrayElements {


}
