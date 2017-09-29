package com.algorithms.problems.salesforce;

import java.util.Arrays;

class ReverseArrayByGroupSize {

    public void solution(int[] a, int n) {

        if (n > a.length || n == 0) {
            System.out.println("Invalid Entry");
            return;
        }

        int start = 0;
        int last = 0;

        int end = a.length / n;


        System.out.println("Outside: start: " + start + " last: " + last + " end: " + end);

        for (int i = 0; i < end; i++) {
            start = i * n;
            last = (i + 1) * n - 1;

            int x = ((last - start) / 2) + start;
            int k = last;

            System.out.println("Inside: start: " + start + " last: " + last + " end: " + end + " x: " + x + " k: " + k);

            for (int j = start; j <= x; j++) {
                int temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                k--;
            }
        }

        if (last != a.length - 1) {
            start = last + 1;
            last = a.length - 1;
            while (start <= last) {
                int temp = a[start];
                a[start++] = a[last];
                a[last--] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

public class SalesforceReverseArrayByGroupSize {
    public static void main(String[] args) {
        ReverseArrayByGroupSize mSol = new ReverseArrayByGroupSize();
        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        }, 3);


        /*
        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        }, 4);

        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        }, 4);

        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        }, 6);

        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        }, 15);
        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        }, 16);

        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        }, 17);
        */
    }
}