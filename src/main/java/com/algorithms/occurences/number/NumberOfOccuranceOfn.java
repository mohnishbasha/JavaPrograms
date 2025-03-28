package com.algorithms.occurences.number;

/*
Time Complexity: O(Logn)
Programming Paradigm: Divide & Conquer

http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/

Count the number of occurrences in a sorted array
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
Expected time complexity is O(Logn)

Examples:

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
  Output: 1

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
  Output: 2

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
  Output: -1 // 4 doesn't occur in arr[]

 */


public class NumberOfOccuranceOfn {

    public static int first(int[] arr, int start, int last, int num) {
        int mid;
        int foundAt = -1;

        while (start <= last) {
            mid = (last + start) / 2;

            if (arr[mid] > num) {
                last = mid - 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            }
            //when found number, now we need to find the first occurrence of that repeated number
            else {
                foundAt = mid;
                last = mid - 1;
            }
        }
        return foundAt;
    }

    public static int last(int[] arr, int start, int last, int num) {

        int mid;
        int foundAt = -1;
        while (start <= last) {
            mid = (last + start) / 2;
            if (arr[mid] > num) {
                last = mid - 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            }
            //when found number, now we need to find the first occurrence of that repeated number
            else {
                foundAt = mid;
                start = mid + 1;
            }
        }
        return foundAt;
    }

    public static int NoOfOccurances(int[] arr, int num) {
        int len = arr.length -1;

        int start = first(arr, 0, len , num);
        int end   =  last(arr, 0, len, num);

        return end - start + 1;

    }

    /*

        Better Implementation

    */
    public static int findOccurances(int[] arr, int num) {
        int len = arr.length -1;

        int start =  find(arr, num, true);
        int end   =  find(arr, num, false);

        return end - start + 1;
    }

    public static int find(int[] array, int num, boolean first) {
        int mid;
        int pos = -1;

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            mid = (end + start) / 2;

            if (array[mid] > num) {
                end = mid - 1;
            } else if (array[mid] < num) {
                start = mid + 1;
            }
            //when found number, now we need to find the first occurrence of that repeated number
            // if array[mid] == num
            else {
                pos = mid;
                if (first)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        int[] arr = {9, 9, 9, 9, 9, 9};
        System.out.println(NoOfOccurances(arr, 9));
        System.out.println("--------------------------");

        int[] arr1 = {8, 8, 9, 9, 9, 9};
        System.out.println(NoOfOccurances(arr1, 9));
        System.out.println(NoOfOccurances(arr1, 8));
        System.out.println("--------------------------");

        int[] arr2 = {9,0, 0, 0, 0, 0};
        System.out.println(findOccurances(arr2, 9));
        System.out.println(findOccurances(arr2, 8));

        System.out.println("--------------------------");

        int[] arr3 = {9,9, 9, 9, 9, 9};
        System.out.println(findOccurances(arr3, 9));
        System.out.println(findOccurances(arr3, 8));
    }
}