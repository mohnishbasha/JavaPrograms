package com.algorithms.atoi;

/*
  * 
  Key improvements made:

Input Validation:

Added null check
Better handling of empty input
Added handling for '+' sign


Overflow Handling:

Improved overflow detection logic
Special handling for Integer.MIN_VALUE case
More precise bounds checking before multiplication


Error Handling:

More specific exception messages
Added IllegalArgumentException for null input


Additional Features:

Added String convenience method
Better handling of invalid inputs
Added tracking of valid digits found


Testing:

Added comprehensive test cases
Added helper method for testing
Better error reporting


Documentation:

Added JavaDoc comments
Improved inline comments
Better explanation of edge cases



The main fixes address:

Potential integer overflow issues
Edge cases like null input
Handling of positive sign
Better validation of input characters
More precise error messages

The code now handles:

Null and empty inputs
Leading signs (+ and -)
Integer bounds correctly
Invalid characters
Overflow conditions
Edge cases like "-0" and "++1"
  */

/**
 * Converts ASCII string representations of numbers to integers
 * Handles positive and negative integers with overflow checking
 */
public class AsciiToIntegerClaude {

    /**
     * Converts character array to integer with bounds checking
     * @param input Character array containing ASCII representation of number
     * @return Converted integer value
     * @throws ArithmeticException if result exceeds Integer bounds
     * @throws IllegalArgumentException if input is null
     */
    public static int atoi(char[] input) {
        // Input validation
        if (input == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        // Handle empty input
        if (input.length == 0) {
            return 0;
        }

        long result = 0L;  // Use long to check for overflow
        boolean isNegative = false;
        int startIndex = 0;  // Track start of numeric portion

        // Check for sign
        if (input[0] == '-' || input[0] == '+') {
            isNegative = input[0] == '-';
            startIndex = 1;
        }

        // Process each digit
        boolean hasDigits = false;  // Track if we found any valid digits
        
        for (int i = startIndex; i < input.length; i++) {
            char currentChar = input[i];
            
            // Stop at first non-digit character
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            hasDigits = true;

            /* Trick
             * 
             * This line converts a numeric character (like '5') into its actual integer value (5) using a clever ASCII math trick.
    
             Here's how it works:
    
                In ASCII/Unicode, numeric characters '0' through '9' are stored as consecutive values:
                '0' = 48 (ASCII value)
                '1' = 49
                '2' = 50
                ...and so on
    
                When you subtract the character '0' from any numeric character, you get the actual numeric value:
                    '5' - '0' = 53 - 48 = 5
                    '9' - '0' = 57 - 48 = 9
                    '0' - '0' = 48 - 48 = 0
                    
                This is much cleaner than alternatives like:
                Using Character.getNumericValue(currentChar)
                Having a lookup table/switch statement
                Using Integer.parseInt(String.valueOf(currentChar))
                It's both efficient (single subtraction operation) and readable once you understand the ASCII trick.
             */
            int digitValue = currentChar - '0';
            
            // Check for overflow before multiplying
            // can skip.
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digitValue > Integer.MAX_VALUE % 10)) {
                if (isNegative && result == Integer.MAX_VALUE / 10 && 
                    digitValue == (Integer.MAX_VALUE % 10) + 1) {
                    return Integer.MIN_VALUE;  // Special case for -2^31
                }
                throw new ArithmeticException("Integer overflow");
            }

            result = result * 10 + digitValue;
        }

        // Handle case where no valid digits were found
        if (!hasDigits) {
            return 0;
        }

        // Apply sign
        return (int) (isNegative ? -result : result);
    }

    /**
     * Convenience method that accepts String input
     * @param input String containing number
     * @return Converted integer value
     */
    public static int atoi(String input) {
        return input == null ? 0 : atoi(input.toCharArray());
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        // Test basic functionality
        runTest("");           // Should return 0
        runTest("12ab");      // Should return 12
        runTest("0.123");     // Should return 0
        runTest("-123");      // Should return -123
        runTest("+123");      // Should return 123
        
        // Test edge cases
        runTest(null);        // Should return 0
        runTest("-0");        // Should return 0
        runTest("++1");       // Should return 0
        runTest("--1");       // Should return 0
        
        // Test bounds
        runTest("2147483647");    // Should return Integer.MAX_VALUE
        runTest("-2147483648");   // Should return Integer.MIN_VALUE
        
        // Test overflow
        try {
            runTest("2147483648");  // Should throw exception
        } catch (ArithmeticException e) {
            System.out.println("Correctly caught overflow: " + e.getMessage());
        }
        
        try {
            runTest("999999999999999999999999999");  // Should throw exception
        } catch (ArithmeticException e) {
            System.out.println("Correctly caught overflow: " + e.getMessage());
        }
    }

    /**
     * Helper method to run tests and print results
     */
    private static void runTest(String input) {
        try {
            int result = atoi(input);
            System.out.println("Input: \"" + input + "\" -> " + result);
        } catch (Exception e) {
            System.out.println("Input: \"" + input + "\" -> Exception: " + e.getMessage());
        }
    }
}