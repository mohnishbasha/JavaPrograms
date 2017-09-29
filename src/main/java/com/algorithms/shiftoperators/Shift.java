package com.algorithms.shiftoperators;

/**
 * Created by  on 11/11/16.
 *
 * Reference:
 * https://www.youtube.com/watch?v=ruWWIBV560U
 *
 *
 * left shift - multiply by 2 i.e Multiply by - 2 ^ n
 * Right shift - divide by 2 i.e  Multiply by - 1 / 2 ^ n
 *
 */
public class Shift {

    public static void main(String args[]) {


        // left shift
        int a = 2;
        System.out.println(a<<1); // a^1

        a = 2;
        System.out.println(a<<2); // a^2

        a = 2;
        System.out.println(a<<3);

        a = 2;
        System.out.println(a<<7);

        a = 2;
        System.out.println(a<<9);


        // right shift
        a = 8;
        System.out.println(a>>1); // a/2^1

        a = 8;
        System.out.println(a>>2); // a/2^2

        a = 8;
        System.out.println(a>>3); // a/2^3

        // right shift
        a = -8;
        System.out.println(a>>1); // a/2^1

        a = -8;
        System.out.println(a>>2); // a/2^2

        a = -8;
        System.out.println(a>>3); // a/2^3
        // newly filled bit depends on left most bit.



        // right shift filled with zero >>>


        // right shift
        a = 8;
        System.out.println(a>>>1); //

        a = 8;
        System.out.println(a>>>2); //

        a = 8;
        System.out.println(a>>>3); //

        // right shift
        a = -8;
        System.out.println(a>>>1); //

        a = -8;
        System.out.println(a>>>2); //

        a = -8;
        System.out.println(a>>>3); //



    }
}
