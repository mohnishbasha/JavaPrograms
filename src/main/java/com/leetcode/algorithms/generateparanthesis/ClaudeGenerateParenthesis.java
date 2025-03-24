package com.leetcode.algorithms.generateparanthesis;

import java.util.ArrayList;
import java.util.List;

/**
* Generates all valid combinations of n pairs of balanced parentheses
*/
public class ClaudeGenerateParenthesis {

    /**
     * Generates balanced parentheses combinations
     * @param n Number of pairs to generate
     * @return List of valid combinations
     * @throws IllegalArgumentException if n is negative
     */
    public static List<String> generateParentheses(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of pairs cannot be negative");
        }
 
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
 
    /**
     * Backtracking helper to generate combinations
     * @param result List to store results
     * @param current Current combination being built
     * @param open Count of open parentheses
     * @param close Count of close parentheses
     * @param n Total pairs needed
     */
    private static void backtrack(List<String> result, String current, 
                                int open, int close, int n) {
        // Base case: valid combination found
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
 
        // Can add open parenthesis if not exceeded n
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
 
        // Can add close parenthesis if less than open count
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
 
    /**
     * Validates if a string has balanced parentheses
     */
    private static boolean isBalanced(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Balanced Parentheses Tests");
        System.out.println("=================================");
 
        // Test 1: Basic cases
        System.out.println("\nTest 1: Basic cases");
        testCase(0, Collections.singletonList(""));
        testCase(1, Collections.singletonList("()"));
        testCase(2, Arrays.asList("(())", "()()"));
        testCase(3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
 
        // Test 2: Invalid input
        System.out.println("\nTest 2: Invalid input");
        try {
            generateParentheses(-1);
            System.out.println("Failed: Should throw exception for negative input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative input");
        }
 
        // Test 3: Validate all combinations
        System.out.println("\nTest 3: Validate all combinations");
        testValidCombinations(4);
 
        // Test 4: Count verification
        System.out.println("\nTest 4: Count verification");
        verifyCount(5);
 
        // Test 5: Large input performance
        System.out.println("\nTest 5: Large input performance");
        testPerformance(10);
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(int n, List<String> expected) {
        try {
            List<String> result = generateParentheses(n);
            Collections.sort(result);
            Collections.sort(expected);
            
            System.out.printf("n=%d:%n", n);
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + result);
            System.out.println(result.equals(expected) ? "PASSED" : "FAILED");
            
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
 
    /**
     * Helper method to validate all combinations
     */
    private static void testValidCombinations(int n) {
        List<String> combinations = generateParentheses(n);
        boolean allValid = true;
        
        for (String combination : combinations) {
            if (!isBalanced(combination)) {
                System.out.printf("Invalid combination found: %s%n", combination);
                allValid = false;
            }
        }
        
        System.out.printf("All combinations valid for n=%d: %s%n", 
            n, allValid ? "PASSED" : "FAILED");
    }
 
    /**
     * Helper method to verify count of combinations
     */
    private static void verifyCount(int n) {
        // Number of combinations should follow Catalan numbers
        int[] expectedCounts = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862};
        
        List<String> combinations = generateParentheses(n);
        System.out.printf("n=%d: Expected count=%d, Got count=%d - %s%n",
            n, expectedCounts[n], combinations.size(),
            combinations.size() == expectedCounts[n] ? "PASSED" : "FAILED");
    }
 
    /**
     * Helper method to test performance
     */
    private static void testPerformance(int n) {
        long startTime = System.currentTimeMillis();
        List<String> result = generateParentheses(n);
        long endTime = System.currentTimeMillis();
        
        System.out.printf("Generated %d combinations for n=%d in %d ms%n", 
            result.size(), n, (endTime - startTime));
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }