package com.algorithms.factorial;

import java.math.BigInteger;

/**
 * Demonstrates factorial calculation using both BigInteger and int
 * Shows limitations of using primitive types for factorial calculations
 */

public class FactorialBigIntegerClaude {

    /**
     * Calculates factorial using BigInteger
     * 
     * @param n number to calculate factorial for
     * @return factorial result as BigInteger
     * @throws IllegalArgumentException if n is negative
     */
    public static BigInteger calculateFactorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Calculates factorial using int (limited to n <= 12)
     * 
     * @param n number to calculate factorial for
     * @return factorial result as int
     * @throws IllegalArgumentException if n is negative
     * @throws ArithmeticException      if result would overflow int
     */
    public static int calculateFactorialInt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 12) {
            throw new ArithmeticException("Integer factorial only works up to 12! Due to overflow");
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Formats factorial result with thousands separator for better readability
     */
    private static String formatNumber(BigInteger number) {
        return String.format("%,d", number);
    }

    public static void main(String[] args) {
        int maxN = 20; // Maximum factorial to calculate

        // Calculate using BigInteger (handles large numbers)
        System.out.println("Factorial calculations using BigInteger:");
        System.out.println("=====================================");
        for (int i = 0; i <= maxN; i++) {
            BigInteger result = calculateFactorialBig(i);
            System.out.printf("%2d! = %s%n", i, formatNumber(result));
        }

        System.out.println("\nFactorial calculations using int (limited to 12!):");
        System.out.println("=====================================");
        // Calculate using int (demonstrates limitations)
        for (int i = 0; i <= maxN; i++) {
            try {
                int result = calculateFactorialInt(i);
                System.out.printf("%2d! = %,d%n", i, result);
            } catch (ArithmeticException e) {
                System.out.printf("%2d! = Overflow (exceeds int capacity)%n", i);
            }
        }

        // Demonstrate maximum values
        System.out.println("\nMaximum Values:");
        System.out.println("=====================================");
        System.out.println("Maximum int value: " + String.format("%,d", Integer.MAX_VALUE));
        System.out.println("12! = " + String.format("%,d", calculateFactorialInt(12)));
        System.out.println("13! = " + formatNumber(calculateFactorialBig(13)) +
                " (too large for int)");
    }
}