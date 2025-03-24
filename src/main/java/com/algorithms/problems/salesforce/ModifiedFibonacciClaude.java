package com.algorithms.problems.salesforce;

/**
* Implements modified Fibonacci sequence where each number is sum of k previous numbers
*/
public class ModifiedFibonacciClaude {

    /**
     * Generates modified Fibonacci sequence
     * @param n Number of elements to generate
     * @param k Number of previous elements to sum
     * @return Array containing sequence
     * @throws IllegalArgumentException if inputs are invalid
     */
    public static long[] fibonacci(int n, int k) {
        // Validate inputs
        if (n < 0 || k <= 0 || k > n) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        
        // Handle special cases
        if (n == 0) {
            return new long[0];
        }
 
        long[] sequence = new long[n];
 
        // Step 1: First k numbers are all 1
        for (int i = 0; i < Math.min(k, n); i++) { // Math.min(k, n) -- to check for bounds.
            sequence[i] = 1;
        }
 
        // Step 2: Generate rest by summing previous k numbers
        for (int i = k; i < n; i++) {
            // Sum previous k elements
            long sum = 0;
            for (int j = 1; j <= k; j++) {
                sum += sequence[i - j];
                
                // Check for overflow
                if (sum < 0) {
                    throw new ArithmeticException("Sequence overflow at position " + i);
                }
            }
            sequence[i] = sum;
        }
 
        return sequence;
    }
 
    /**
     * Formats array as string
     */
    private static String arrayToString(long[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) { // dont add , for the last element.
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Modified Fibonacci Tests");
        System.out.println("===============================");
 
        // Test 1: Standard cases (k=2)
        System.out.println("\nTest 1: Standard Fibonacci (k=2)");
        testCase(6, 2, "[1, 1, 2, 3, 5, 8]");
        testCase(8, 2, "[1, 1, 2, 3, 5, 8, 13, 21]");
 
        // Test 2: Three number sum (k=3)
        System.out.println("\nTest 2: Three number sum (k=3)");
        testCase(6, 3, "[1, 1, 1, 3, 5, 9]");
        testCase(8, 3, "[1, 1, 1, 3, 5, 9, 17, 31]");
 
        // Test 3: Four number sum (k=4)
        System.out.println("\nTest 3: Four number sum (k=4)");
        testCase(6, 4, "[1, 1, 1, 1, 4, 7]");
        testCase(8, 4, "[1, 1, 1, 1, 4, 7, 13, 25]");
 
        // Test 4: Edge cases
        System.out.println("\nTest 4: Edge cases");
        testCase(1, 1, "[1]");  // Single element
        testCase(2, 2, "[1, 1]");  // Two elements
        testCase(3, 3, "[1, 1, 1]");  // Three elements, k=3
 
        // Test 5: Invalid inputs
        System.out.println("\nTest 5: Invalid inputs");
        try {
            fibonacci(-1, 2);
            System.out.println("Failed: Should throw exception for negative n");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative n");
        }
 
        try {
            fibonacci(5, 0);
            System.out.println("Failed: Should throw exception for k=0");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught k=0");
        }
 
        try {
            fibonacci(3, 4);
            System.out.println("Failed: Should throw exception for k>n");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught k>n");
        }
 
        // Test 6: Large numbers
        System.out.println("\nTest 6: Large numbers");
        testCase(10, 2, "[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]");
        testCase(10, 3, "[1, 1, 1, 3, 5, 9, 17, 31, 57, 105]");
 
        // Test 7: Overflow check
        System.out.println("\nTest 7: Overflow check");
        try {
            fibonacci(93, 2);  // Should overflow around this point
            System.out.println("Note: No overflow occurred");
        } catch (ArithmeticException e) {
            System.out.println("Caught expected overflow");
        }
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int n, int k, String expected) {
        try {
            long[] result = fibonacci(n, k);
            String resultStr = arrayToString(result);
            System.out.printf("n=%d, k=%d: Expected %s, Got %s - %s%n",
                n, k, expected, resultStr,
                resultStr.equals(expected) ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("n=%d, k=%d: Exception: %s%n",
                n, k, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }