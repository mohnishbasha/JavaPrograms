package com.sort.dnp;


/*
    Sort an n-length array of 0s, 1s and -1s in linear time
*/

public class Count012LinearTime {
}


/*
    int[] array = [0,-1,-1,-1,1,1,1,1,1,1,1,0,0,0,0];
        -1, 0, 1

        [-1,-1,-1,0,0,0,1,1,1,]

        Output = -1, -1, 0, 0, 1, 1, 1
        String Formated Array Output

// ------------------------------------------------------------------------------------
        input = 1, -1, 0, 1, 1, 0, 0
        |        |                |

        Public String sortNumbers(int[] a) {

        Int l = 0;
        Int h = a.length() - 1;
        Int m = 0
        Int temp

        if( a == null || a.isEmpty())
        Return “”;


        while(m <= h) {

        Int val = a[m];
        switch(val) {
        Case -1:
// swap(l, m) // swap elements l, m in a
        int temp = a[l]
        a[l] = a[m];
        a[m] = temp;
        L++;
        m++;
        break;
        Case 0:
        M++;
        Break;
        Case 1:
        // swap(m, h) // swap elements m, h in a
        Int temp = a[m]
        a[m] = a[h];
        a[h] = temp;
        m++;
        h--;
        Break;
        } // end of switch
        } // end of while
        Return a.toString();
        }


        input = 1, -1, 0, 1, 1, 0, 0

        Pass 1:
        l=0, m=0, h=6
        Val = 1
        0 -1 0 1 1 0 1

        Pass 2:
        l=0 m=1 h=5
        Val = -1
        -1 0 0 1 1 0 1

        Pass 3
        l=1 m=2 h=5
        -1 0 0 1 1 0 1

        Pass 4:
        l=1 m=3 h=5
        Val = 1
        -1 0 0 0 1 1 1

import java.util.Arrays;

public class SortArrayMohinish {
    private static void swap(int index, int index2, int[] a) {
        int temp = a[index];
        a[index] = a[index2];
        a[index2] = temp;
    }

    private static int[] sortNumbers(int[] a) {
        int l = 0;
        int h = a.length - 1; //fixed
        int m = 0;

        if( a == null || a.length == 0)
            return a;

        while (m <= h) {

            int val = a[m];
            switch (val) {
                case -1:
                    swap(l, m, a); //fixed
                    l++;
                    m++;
                    break;
                case 0:
                    m++;
                    break;
                case 1:
                    swap(m, h, a); //fixed
                    m++;
                    h--;
                    break;
            } // end of switch
        } // end of while
        return a;
    }

    public static void main(String[] args) {
        int[] array = { 1, 1, 0, -1, 0, -1 };
        int[] sortedArray = sortNumbers(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
    swapping index 0 and index 5 = -1  1  0  -1  0 1
        swapping index 1 and index 4 = -1  0  0  -1  1 1
        swapping index 0 and index 3 =
        [-1, 0, 0, -1, 1, 1]

        [-1, 0, 0, -1, 1, 1]



*/
