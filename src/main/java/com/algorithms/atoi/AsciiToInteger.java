package com.algorithms.atoi;


import java.lang.*;

/*

https://www.geeksforgeeks.org/write-your-own-atoi/

The atoi() function takes a string (which represents an integer) as an argument and returns its value.

Time Complexity: O(n) where n is the number of characters in the input string.

We only need to handle four cases:

- Discards all leading whitespaces
- sign of the number
- overflow
- invalid input

ASCII
American Standard Code for Information Interchange.

 */


public class AsciiToInteger {

    public static int atoi(char[] input) {

        long result = 0l; // Initialize result
        boolean isneg = false;

        // Iterate through all characters of input string and
        // update result

        for (int i=0; i<input.length; i++) {

            // check if negative integer.
            if (i == 0 && input[i] == '-') {
                isneg = true;
                continue;
            }

            // check for integer range.
            if (input[i] <  '0' || input[i] > '9') {
                break;
            }

            int digitValue = input[i] - '0';
            result = result * 10 + digitValue;

            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException("integer");
            }

        }

        if (isneg) {
            result = result * -1;
        }

        return (int) result;
    }


    public static void main(String[] args) {
        System.out.println(atoi("".toCharArray())); // 0
        System.out.println(atoi("12ab".toCharArray())); // 12
        System.out.println(atoi("0.123".toCharArray())); // 0
        System.out.println(atoi("-123".toCharArray())); // -123
        System.out.println(atoi("999999999999999999999999999".toCharArray())); // exception
    }
}
