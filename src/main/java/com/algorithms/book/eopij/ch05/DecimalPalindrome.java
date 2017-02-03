package com.algorithms.book.eopij.ch05;

/**
 * Elements of Java Interview
 * Chapter 05, Page 55, 5.9
 *
 * Complexity O(n)
 */

/*

Description
log10(x) represents the logarithm of x to the base 10.

Mathematically, log10(x) is equivalent to log(10, x). See Example 1.

The logarithm to the base 10 is defined for all complex arguments x ≠ 0.

log10(x) rewrites logarithms to the base 10 in terms of the natural logarithm: log10(x) = ln(x)/ln(10). See Example 2.

See the ln help page for details.

Environment Interactions
When called with a floating-point argument, this function is sensitive to the environment variable DIGITS which
determines the numerical working precision.

Examples

Example 1
Compute these logarithms using log10:
log10(10), log10(1000), log10(1)
1, 3, 0


Compute the same logarithms using log with 10 as the first argument:
log(10, 10), log(10, 1000), log(10, 1)
1, 3, 0



 */


public class DecimalPalindrome {


    public static boolean isPalindromeNumber(int x) {

        if ( x < 0) {
            return false;
        }

        final int numDigits = (int)(Math.floor(Math.log10(x))) + 1;
        int msdMask = (int)Math.pow(10, numDigits - 1);

        System.out.println("numDigits: " + numDigits);
        System.out.println("msdMask: " + msdMask);


        for( int i = 0; i < (numDigits/2); ++i)
        {
            if(x / msdMask != x%10) {
                return false;
            }
            x %= msdMask;
            x /= 10;
            msdMask /= 100;
        }
        return true;

    }

    public static void main (String args[]) {

        System.out.println("1230321: " + isPalindromeNumber(1230321));
        System.out.println("3451: " + isPalindromeNumber(3451));
    }

}
