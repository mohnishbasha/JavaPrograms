package com.algorithms.problems.salesforce;

/**
 * Created by i835811 on 11/13/16.
 */
public class PowerOfNumber {

    public static int power(int x, int n) {
        if (n == 1)
            return x;
        else if (n % 2 == 1)
            return x * power(x, n - 1);
        else {
            int b = power(x, n / 2);
            return b * b;
        }
    }

    public static void main(String[] args){

        System.out.println(PowerOfNumber.power(2,3));
    }

}


