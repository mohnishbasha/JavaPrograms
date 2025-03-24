package com.algorithms.palindrome.simple;

/**
 * Checks if a string is a palindrome using recursive approach
 */
public class PalindromeCheckerClaudeRecursive {
    
    /**
     * Recursive palindrome check with configurable options
     * @param str Input string to check
     * @param ignoreCase Whether to ignore case when comparing
     * @param ignoreSpaces Whether to ignore spaces and punctuation
     * @return true if palindrome, false otherwise
     * @throws IllegalArgumentException if input is null
     */
    public static boolean isPalindrome(String str, boolean ignoreCase, boolean ignoreSpaces) {
        // Validate input
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        // Process string based on options
        String processedStr = str;
        if (ignoreCase) {
            processedStr = processedStr.toLowerCase();
        }
        if (ignoreSpaces) {
            processedStr = processedStr.replaceAll("[\\s\\p{Punct}]", "");
        }
        
        return isPalindromeRecursive(processedStr, 0, processedStr.length() - 1);
    }

    /**
     * Recursive helper method to check palindrome
     * @param str String to check
     * @param start Start index
     * @param end End index
     * @return true if substring is palindrome
     */
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base cases
        if (start >= end) {
            return true;  // Empty string or single character
        }
        
        // If characters don't match, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        
        // Recursively check the substring
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    /**
     * Overloaded method with default strict checking
     */
    public static boolean isPalindrome(String str) {
        return isPalindrome(str, false, false);
    }

    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Palindrome Tests (Recursive)");
        System.out.println("===================================");

        // Test 1: Basic palindromes
        System.out.println("\nTest 1: Basic palindromes (case sensitive)");
        testCase("radar", true);
        testCase("level", true);
        testCase("deified", true);
        testCase("hello", false);
        
        // Test 2: Case sensitivity
        System.out.println("\nTest 2: Case sensitivity");
        testCase("Radar", false);  // Strict check
        testCaseIgnoreCase("Radar", true);  // Case insensitive
        testCaseIgnoreCase("A man a plan a canal Panama", true);
        
        // Test 3: Spaces and punctuation
        System.out.println("\nTest 3: Spaces and punctuation");
        testCase("A man a plan a canal Panama", false);  // Strict check
        testCaseIgnoreAll("A man, a plan, a canal: Panama!", true);  // Ignore all
        testCaseIgnoreAll("Do geese see God?", true);
        testCaseIgnoreAll("Never odd or even.", true);
        
        // Test 4: Edge cases
        System.out.println("\nTest 4: Edge cases");
        testCase("", true);  // Empty string
        testCase("a", true);  // Single character
        try {
            isPalindrome(null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
        
        // Test 5: Long palindromes
        System.out.println("\nTest 5: Long palindromes");
        testCase("aaaaaaaaaaaaaaaaaaaaa", true);  // 21 a's
        testCaseIgnoreAll("A man, a plan, a cat, a ham, a yak, " +
                         "a yam, a hat, a canal: Panama!", true);
        
        // Test 6: Unicode characters
        System.out.println("\nTest 6: Unicode characters");
        testCase("αββα", true);
        testCase("στσ", true);
        testCase("αβγ", false);
    }
    
    // Helper methods for testing
    private static void testCase(String input, boolean expected) {
        try {
            boolean result = isPalindrome(input);
            System.out.printf("\"%s\": Expected %b, Got %b - %s%n",
                input, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("\"%s\": Exception: %s%n", input, e.getMessage());
        }
    }
    
    private static void testCaseIgnoreCase(String input, boolean expected) {
        try {
            boolean result = isPalindrome(input, true, false);
            System.out.printf("\"%s\" (ignore case): Expected %b, Got %b - %s%n",
                input, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("\"%s\": Exception: %s%n", input, e.getMessage());
        }
    }
    
    private static void testCaseIgnoreAll(String input, boolean expected) {
        try {
            boolean result = isPalindrome(input, true, true);
            System.out.printf("\"%s\" (ignore all): Expected %b, Got %b - %s%n",
                input, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("\"%s\": Exception: %s%n", input, e.getMessage());
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}