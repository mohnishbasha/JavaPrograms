package com.algorithms.primenumber;

/**
* Checks if a number is prime using efficient methods
*/
public class PrimeNumberClaude {
   
    /**
     * Determines if a number is prime
     * @param number Number to check
     * @return true if prime, false otherwise
     * @throws IllegalArgumentException if number is negative
     */
    public static boolean isPrime(long number) {
        
        // Handle negative numbers
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        
        // Handle special cases
        if (number <= 1) {
            return false;  // 0 and 1 are not prime
        }
        if (number == 2 ||  number == 3) {
            return true;  // 2 and 3 are prime
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;  // Even numbers > 2 are not prime
        }
        
        // Check divisibility up to square root
        // Only need to check numbers of form 6k ± 1
        long sqrt = (long) Math.sqrt(number);  // Only need to check up to square root
        for (long i = 5; i <= sqrt; i += 6) {  // Start at 5 and increment by 6
            if (number % i == 0 ||         // Check if divisible by i
                number % (i + 2) == 0) {   // Check if divisible by i+2
                return false;              // If divisible by either, not prime
            }
        }
        
        return true;
    }
    
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Prime Number Tests");
        System.out.println("=========================");
        
        // Test 1: Basic prime numbers
        System.out.println("\nTest 1: Basic prime numbers");
        testCase(2, true);
        testCase(3, true);
        testCase(5, true);
        testCase(7, true);
        testCase(11, true);
        testCase(13, true);
        testCase(17, true);
        testCase(19, true);
        
        // Test 2: Non-prime numbers
        System.out.println("\nTest 2: Non-prime numbers");
        testCase(4, false);
        testCase(6, false);
        testCase(8, false);
        testCase(9, false);
        testCase(10, false);
        testCase(12, false);
        testCase(15, false);
        
        // Test 3: Edge cases
        System.out.println("\nTest 3: Edge cases");
        testCase(0, false);
        testCase(1, false);
        try {
            isPrime(-5);
            System.out.println("Failed: Should throw exception for negative number");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative number");
        }
        
        // Test 4: Large prime numbers
        System.out.println("\nTest 4: Large prime numbers");
        testCase(997, true);
        testCase(7919, true);
        testCase(104729, true);  // 10,000th prime
        
        // Test 5: Large composite numbers
        System.out.println("\nTest 5: Large composite numbers");
        testCase(1000, false);
        testCase(10000, false);
        testCase(100000, false);
        
        // Test 6: Square numbers
        System.out.println("\nTest 6: Square numbers");
        testCase(4, false);   // 2²
        testCase(9, false);   // 3²
        testCase(25, false);  // 5²
        testCase(49, false);  // 7²
        
        // Test 7: Products of primes
        System.out.println("\nTest 7: Products of primes");
        testCase(6, false);    // 2 × 3
        testCase(15, false);   // 3 × 5
        testCase(91, false);   // 7 × 13
    }
    
    /**
     * Helper method to test and verify results
     */
    private static void testCase(long number, boolean expected) {
        try {
            boolean result = isPrime(number);
            System.out.printf("Is %d prime? Expected: %b, Got: %b - %s%n",
                number, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("Number %d: Exception: %s%n",
                number, e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        runTests();
    }
 }