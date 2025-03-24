package com.algorithms.anagram;

import java.util.HashMap;

/**
* Searches for anagram substrings within a text using sliding window approach
*/
public class FindAnagramsSlidingWindow {

   /**
    * Checks if two character frequency maps represent an anagram
    */

    // pattern: "hello"
    // patternMap: {'h':1, 'e':1, 'l':2, 'o':1}
    // textMap:    {'h':1, 'e':1, 'l':2, 'o':1}  -> returns true (anagram)
    // textMap:    {'h':1, 'e':1, 'l':1, 'o':1}  -> returns false (wrong frequency of 'l')
    // textMap:    {'h':1, 'e':1, 'x':1, 'o':1}  -> returns false (missing 'l')

   private static boolean isAnagram(HashMap<Character, Integer> patternMap, 
                                  HashMap<Character, Integer> textMap) {
        // 1. Quick size check
        if (patternMap.size() != textMap.size()) {
            return false;  // Different number of unique characters = not an anagram
        }
       
       // 2. Check each character and its frequency
       for (Character c : patternMap.keySet()) {
        if (!textMap.containsKey(c) ||                    // Character missing in text
            !textMap.get(c).equals(patternMap.get(c))) {  // Different frequency
               return false;
           }
       }
       return true; // All characters match with same frequencies
   }

   /**
    * Searches for anagrams of pattern within text using sliding window
    * @throws IllegalArgumentException for invalid inputs
    */
   public static boolean findAnagram(String pattern, String text) {
       // Validate inputs
       if (pattern == null || text == null) {
           throw new IllegalArgumentException("Inputs cannot be null");
       }
       
       if (pattern.isEmpty() || text.isEmpty()) {
           throw new IllegalArgumentException("Inputs cannot be empty");
       }

       if (pattern.length() > text.length()) {
           return false;
       }

       // Create frequency maps
       HashMap<Character, Integer> patternMap = new HashMap<>();
       HashMap<Character, Integer> textMap = new HashMap<>();

       // Initialize pattern frequency map
       for (char c : pattern.toCharArray()) {
        
        // It's equivalent longer code:
        // if (patternMap.containsKey(c)) { 
        //    patternMap.put(c, patternMap.get(c) + 1);  // Increment existing count
        // } else {
        //    patternMap.put(c, 1);  // First occurrence
        // }

        // This is a concise way to increment a counter in a HashMap. Here's what each part does:
        // 1. patternMap.merge() - A HashMap method that handles both insertion and updates
        // c - The key (the character we're counting)
        // 1 - The value to use if the key doesn't exist yet
        // Integer::sum - The function to apply if the key already exists (adds old and new values)
        
        patternMap.merge(c, 1, Integer::sum);
        
       }

       // pattern = "abc" (windowSize = 3)
       // text = "xyzabc"
       //         ^^^     <- first window
       
       // We need to look at segments of text that are the same length as the pattern
       // If pattern is "abc", windowSize will be 3
       // Only looks at the first window of characters
       // If windowSize is 3, looks at positions 0, 1, and 2

       // Initialize text window frequency map
       int windowSize = pattern.length(); // sliding window size == pattern length
       for (int i = 0; i < windowSize; i++) {
           char c = text.charAt(i);
           textMap.merge(c, 1, Integer::sum); // For "xyz": {'x':1, 'y':1, 'z':1}
       }

       // Slide window through text, windowSize = 3 for "abc" pattern
       for (int i = windowSize; i <= text.length(); i++) {
           // Check current window
           if (isAnagram(patternMap, textMap)) {
               return true;
           }
           
           // Exit if at end of text 
           if (i == text.length()) {
               break;
           }

           // This code handles sliding the window forward by one character. 
           // text = "abcdef"
           // window size = 3
           // Initial window: "abc"
           // textMap: {'a':1, 'b':1, 'c':1}

            // Sliding window: "bcd"
            // 1. Remove 'a' (leftChar)  -> textMap: {'b':1, 'c':1}
            // 2. Add 'd' (rightChar)    -> textMap: {'b':1, 'c':1, 'd':1}
            
            //  If 'a' has count 2:
            //    - oldValue = 2
            //    - value = -1
            //    - newValue = 2 + (-1) = 1
            //    - Returns 1 (keeps entry with count 1)

            //    If 'a' has count 1:
            //    - oldValue = 1
            //    - value = -1
            //    - newValue = 1 + (-1) = 0
            //    - Returns null (removes 'a' from map)

           // Remove leftmost character
           char leftChar = text.charAt(i - windowSize);
           textMap.merge(leftChar, -1, (oldValue, value) -> { // Lambda function (oldValue, value) -> {...}:
               int newValue = oldValue + value;
               return newValue == 0 ? null : newValue;
           });

           // Example Pass for above code.
           // text = "abcdef"
           // windowSize = 3

           // Pass 1 (i = 3):
           // - Window was: "abc"
           // - leftChar = text.charAt(3 - 3) = text.charAt(0) = 'a'

           // Pass 2 (i = 4):
           // - Window was: "bcd"
           // - leftChar = text.charAt(4 - 3) = text.charAt(1) = 'b'

           // Add rightmost character
           char rightChar = text.charAt(i);
           textMap.merge(rightChar, 1, Integer::sum);
       }

       return false;
   }

   /**
    * Runs all test cases 
    */
   public static void runTests() {
       System.out.println("Running Anagram Search Tests");
       System.out.println("===========================");

       // Test normal cases
       System.out.println(findAnagram("xyz", "afdgzyxksldfm")); // Should return true
       System.out.println(findAnagram("veer", "ideserve")); // Should return true
       System.out.println(findAnagram("abc", "def")); // Should return false
       System.out.println(findAnagram("abc", "xyzbca")); // Should return true

       // Test edge cases
       
       try {
           findAnagram(null, "text"); // find null pattern
           System.out.println("Failed: Should throw exception for null input");
       } catch(IllegalArgumentException e) {
           System.out.println("Passed: Caught null input");
       }

       try {
           findAnagram("", "text");  // find empty pattern
           System.out.println("Failed: Should throw exception for empty input");
       } catch(IllegalArgumentException e) {
           System.out.println("Passed: Caught empty input");
       }

       // Test pattern longer than text
       System.out.println(findAnagram("pattern", "text")); // Should return false

       // Test exact matches
       System.out.println(findAnagram("abc", "abc")); // Should return true
       
       // Test with spaces
       System.out.println(findAnagram("a b", "b a")); // Should return true

       // Test case sensitivity 
       System.out.println(findAnagram("ABC", "abc")); // Should return false
   }

   /**
    * Main method to run tests
    */
   public static void main(String[] args) {
       runTests();
   }
}