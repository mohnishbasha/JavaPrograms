package com.algorithms.strings.nonreapting;

/**
* Finds first non-repeating character in a string
*/
public class FirstNonRepeatingCharClaude {

    /**
     * Finds first character that appears exactly once
     * @param str Input string to search
     * @return First non-repeating char, or null if none found
     * @throws IllegalArgumentException if input is null
     */
    public static Character findFirstNonRepeating(String str) {
        // Input validation
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        if (str.isEmpty()) {
            return null;
        }
 
        // Count frequency of each character
        int[] frequency = new int[256];  // Assuming ASCII characters
        
        // First pass - count frequencies
        // Assuming frequency is declared as: int[] frequency = new int[256];
        for (char c : str.toCharArray()) {
            // Each char is automatically converted to its ASCII value (0-255) as array index
            frequency[c]++;
        }
        
        // Second pass - find first char with frequency 1
        for (char c : str.toCharArray()) {
            if (frequency[c] == 1) {
                return c;
            }
        }
        
        return null;  // No non-repeating character found
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running First Non-Repeating Character Tests");
        System.out.println("==========================================");
 
        // Test 1: Basic cases
        System.out.println("\nTest 1: Basic cases");
        testCase("abcab", 'c');
        testCase("abcabc", null);
        testCase("abcde", 'a');
        testCase("aabbcc", null);
 
        // Test 2: Single character cases
        System.out.println("\nTest 2: Single character cases");
        testCase("a", 'a');
        testCase("aa", null);
        testCase("aaa", null);
 
        // Test 3: Special characters
        System.out.println("\nTest 3: Special characters");
        testCase("a!b!c", 'a');
        testCase("!@#", '!');
        testCase("!@#!@#", null);
        testCase(" space ", 's');
 
        // Test 4: Numbers and mixed characters
        System.out.println("\nTest 4: Numbers and mixed characters");
        testCase("ab12ab1", '2');
        testCase("123123", null);
        testCase("ab12!@ab1!", '2');
 
        // Test 5: Edge cases
        System.out.println("\nTest 5: Edge cases");
        testCase("", null);
        try {
            findFirstNonRepeating(null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        // Test 6: Case sensitivity
        System.out.println("\nTest 6: Case sensitivity");
        testCase("aAbBAc", 'c');
        testCase("aAbBAcC", 'a');
 
        // Test 7: Long strings
        System.out.println("\nTest 7: Long strings");
        testCase("abcdefghijklmnopqrstuvwxyz", 'a');
        testCase("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy", 'z');
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(String input, Character expected) {
        try {
            Character result = findFirstNonRepeating(input);
            boolean passed = (result == null && expected == null) || 
                           (result != null && result.equals(expected));
            
            System.out.printf("Input: \"%s\"%nExpected: %s, Got: %s - %s%n",
                input,
                expected == null ? "null" : "'" + expected + "'",
                result == null ? "null" : "'" + result + "'",
                passed ? "PASSED" : "FAILED");
                
        } catch (Exception e) {
            System.out.printf("Input: \"%s\", Exception: %s%n",
                input, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }