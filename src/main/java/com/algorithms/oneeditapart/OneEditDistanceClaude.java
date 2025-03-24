package com.algorithms.oneeditapart;

/**
* Checks if two strings are exactly one edit operation apart
* Valid edit operations: insert, delete, replace single character
*/
public class OneEditDistanceClaude {

    /**
     * Determines if two strings differ by exactly one edit
     * @param str1 First string to compare - shorter string.
     * @param str2 Second string to compare - longer string.
     * @return true if strings are one edit apart, false otherwise
     * @throws IllegalArgumentException if either input is null
     */
    public static boolean oneEditApart(String str1, String str2) {
        // Input validation
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
 
        int len1 = str1.length();
        int len2 = str2.length();
 
        // Length difference more than 1 means multiple edits needed
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
 
        // Make str1 always the shorter string for simpler logic
        if (len1 > len2) {
            return oneEditApart(str2, str1);
        }
 
        // At this point str1 is shorter or equal length to str2
        boolean foundDifference = false;
        int i = 0; // index for str1
        int j = 0; // index for str2
 
        while (i < len1 && j < len2) {
            if (str1.charAt(i) != str2.charAt(j)) {
                // Found a difference
                if (foundDifference) {
                    return false; // Second difference found
                }
                foundDifference = true;
 
                if (len1 == len2) {
                    // For equal length strings, advance both indices
                    i++;
                }
                // For different lengths, only advance longer string index
                j++;
            } else {
                // Characters match, advance both indices
                i++;
                j++;
            }
        }
 
        // Return true if we found exactly one difference
        // or if we're at the end with exactly one char remaining
        return foundDifference || (len1 != len2);
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running One Edit Distance Tests");
        System.out.println("==============================");
 
        // Test 1: Single insert cases
        System.out.println("\nTest 1: Single insert");
        testCase("cut", "cute", true);
        testCase("cat", "cats", true);
        testCase("", "a", true);
        testCase("abc", "abcd", true);
 
        // Test 2: Single delete cases
        System.out.println("\nTest 2: Single delete");
        testCase("cute", "cut", true);
        testCase("boot", "bot", true);
        testCase("a", "", true);
        testCase("abcd", "abc", true);
 
        // Test 3: Single replace cases
        System.out.println("\nTest 3: Single replace");
        testCase("cat", "cut", true);
        testCase("dog", "dig", true);
        testCase("a", "b", true);
        testCase("abc", "abd", true);
 
        // Test 4: Multiple edit cases (should return false)
        System.out.println("\nTest 4: Multiple edits");
        testCase("cat", "dog", false); // Multiple replace
        testCase("foo", "foobar", false); // Multiple insert
        testCase("hello", "hi", false); // Multiple delete
        testCase("abc", "def", false);
 
        // Test 5: Equal strings (should return false)
        System.out.println("\nTest 5: Equal strings");
        testCase("", "", false);
        testCase("abc", "abc", false);
        testCase("x", "x", false);
 
        // Test 6: Edge cases
        System.out.println("\nTest 6: Edge cases");
        try {
            oneEditApart(null, "abc");
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        try {
            oneEditApart("abc", null);
            System.out.println("Failed: Should throw exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        // Test 7: Special characters
        System.out.println("\nTest 7: Special characters");
        testCase("a b", "ab", true);
        testCase("a#b", "ab", true);
        testCase("a\nb", "ab", true);
    }
 
    /**
     * Helper method to run and verify test cases
     */
    private static void testCase(String s1, String s2, boolean expected) {
        try {
            boolean result = oneEditApart(s1, s2);
            System.out.printf("\"%s\" vs \"%s\": Expected %b, Got %b - %s%n",
                s1, s2, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.printf("\"%s\" vs \"%s\": Exception: %s%n",
                s1, s2, e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }