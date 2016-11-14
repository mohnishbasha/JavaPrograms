package com.algorithms.problems.salesforce;

import java.util.Arrays;

class ReverseArrayByGroupSize {
    public void solution(int[] arr, int num) {
        if (num > arr.length || num == 0) {
            System.out.println("Invalid Entry");
            return;
        }

        int start = 0;
        int last = 0;
        int end = arr.length / num;
        for (int i = 0; i < end; i++) {
            start = i * num;
            last = (i + 1) * num - 1;
            int x = ((last - start) / 2) + start;
            int k = last;
            for (int j = start; j <= x; j++) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                k--;
            }
        }

        if (last != arr.length - 1) {
            start = last + 1;
            last = arr.length - 1;
            while (start <= last) {
                int temp = arr[start];
                arr[start++] = arr[last];
                arr[last--] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

public class SalesforceReverseArrayByGroupSize {
    public static void main(String[] args) {
        ReverseArrayByGroupSize mSol = new ReverseArrayByGroupSize();
        mSol.solution(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        }, 3);
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
    }
}