package com.algorithms.book.eopij.ch05;

/**
* Reverses the digits of an integer number
*/
public class ReverseDigitsClaude {

    /**
     * Reverses digits of input integer, handling negative numbers and overflow
     * @param num Input integer to reverse
     * @return Reversed integer value
     * @throws ArithmeticException if result would overflow
     */
    public static long reverse(int num) {
        // Handle zero input
        if (num == 0) {
            return 0;
        }
 
        long result = 0;
        long n = Math.abs((long) num);  // Convert to long to handle MIN_VALUE
 
        // Reverse digits
        while (n > 0) {
            long lastDigit = n % 10;
 
            // Check for overflow before multiplying
            if (result > Long.MAX_VALUE/10 || 
                (result == Long.MAX_VALUE/10 && lastDigit > Long.MAX_VALUE%10)) {
                throw new ArithmeticException("Reversed number would overflow");
            }
 
            result = result * 10 + lastDigit;
            n /= 10;
        }
 
        // Apply sign of original number
        return num < 0 ? -result : result;
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Digit Reversal Tests");
        System.out.println("===========================");
 
        // Test 1: Positive numbers
        System.out.println("\nTest 1: Positive numbers");
        testCase(1230, 321);
        testCase(3451, 1543);
        testCase(1000, 1);
        testCase(1, 1);
 
        // Test 2: Negative numbers  
        System.out.println("\nTest 2: Negative numbers");
        testCase(-1230, -321);
        testCase(-3451, -1543);
        testCase(-1000, -1);
        testCase(-1, -1);
 
        // Test 3: Special cases
        System.out.println("\nTest 3: Special cases");
        testCase(0, 0);  // Zero
        testCase(100, 1); // Trailing zeros
        testCase(Integer.MAX_VALUE, 7463847412L); // Max int
        
        // Test 4: Overflow cases
        System.out.println("\nTest 4: Overflow cases");
        try {
            reverse(1234567890);  // Will overflow when reversed
            System.out.println("Failed: Should throw exception for overflow");
        } catch (ArithmeticException e) {
            System.out.println("Passed: Caught overflow exception");
        }
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int input, long expected) {
        try {
            long result = reverse(input);
            System.out.printf("Input: %d, Expected: %d, Got: %d - %s%n", 
                input, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Input: %d - Exception: %s%n", 
                input, e.getMessage());
        }
    }
 
    /**
     * Main method runs tests
     */
    public static void main(String[] args) {
        runTests();
    }
 }