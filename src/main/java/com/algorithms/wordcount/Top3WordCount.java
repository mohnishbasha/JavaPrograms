package com.algorithms.wordcount;

import java.util.*;

/**
* Finds top 3 most frequent words in text
* Returns words and their counts in descending order of frequency
*/
public class Top3WordCount {

   /**
    * Finds 3 most frequent words in text
    * @param text Input text to analyze
    * @return Map of top 3 words and their counts, sorted by frequency
    * @throws IllegalArgumentException if input is invalid 
    */
   public static Map<String, Integer> findTop3Words(String text) {
       // Input validation
       if (text == null) {
           throw new IllegalArgumentException("Input text cannot be null");
       }

       // Split text into words and count frequencies
       Map<String, Integer> wordCounts = new HashMap<>();

        // Input: "Hello, World! How are   you?"

        // Step 1: toLowerCase()
        // "hello, world! how are   you?"

        // Step 2: replaceAll("[^a-zA-Z\\s]", " ")
        // - [^a-zA-Z\\s] means "not a letter or whitespace"
        // - Replaces punctuation with spaces
        // "hello  world  how are   you "

        // Step 3: trim()
        // - Removes leading/trailing spaces
        // "hello  world  how are   you"

        // Step 4: split("\\s+")
        // - \\s+ means "one or more whitespace characters"
        // - Splits into array of words
        // ["hello", "world", "how", "are", "you"]
       String[] words = text.toLowerCase()
                           .replaceAll("[^a-zA-Z\\s]", " ")
                           .trim()
                           .split("\\s+");

       // Handle empty or whitespace-only text
       if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
           return new LinkedHashMap<>();
       }

       // Count word frequencies
       for (String word : words) {
           if (!word.isEmpty()) {
               wordCounts.merge(word, 1, Integer::sum);
           }
       }

       // Sort by frequency and get top 3
       return wordCounts.entrySet()
                       .stream()
                       .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                              .thenComparing(Map.Entry.comparingByKey()))
                       .limit(3)
                       .collect(LinkedHashMap::new,
                               (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                               LinkedHashMap::putAll);
   }

   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Top 3 Word Count Tests");
       System.out.println("=============================");

       // Test 1: Basic text
       System.out.println("\nTest 1: Basic text");
       testCase("the quick brown fox jumps over the lazy dog the",
               Map.of("the", 3, "quick", 1, "brown", 1));

       // Test 2: Case insensitive
       System.out.println("\nTest 2: Case insensitive");
       testCase("The THE the THE the",
               Map.of("the", 5));

       // Test 3: With punctuation
       System.out.println("\nTest 3: With punctuation");
       testCase("Hello, world! Hello again. World is beautiful!",
               Map.of("hello", 2, "world", 2, "is", 1));

       // Test 4: Less than 3 unique words
       System.out.println("\nTest 4: Less than 3 unique words");
       testCase("hello hello world",
               Map.of("hello", 2, "world", 1));

       // Test 5: Empty and whitespace
       System.out.println("\nTest 5: Empty and whitespace");
       testCase("", Collections.emptyMap());
       testCase("   ", Collections.emptyMap());

       // Test 6: Edge cases
       System.out.println("\nTest 6: Edge cases");
       try {
           findTop3Words(null);
           System.out.println("Failed: Should throw exception for null input");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught null input");
       }

       // Test 7: Multiple spaces and special characters
       System.out.println("\nTest 7: Multiple spaces and special characters");
       testCase("word1    word2,,,word3...word1!!!word2",
               Map.of("word1", 2, "word2", 2, "word3", 1));

       // Test 8: Long text
       System.out.println("\nTest 8: Long text");
       testCase("this is a longer test text with some repeated words " +
                "this text should show the most frequent words in this text",
               Map.of("this", 3, "text", 3, "is", 1));
   }

   /**
    * Helper method to test and verify results
    */
   private static void testCase(String input, Map<String, Integer> expected) {
       try {
           Map<String, Integer> result = findTop3Words(input);
           boolean passed = result.equals(expected);
           
           System.out.println("Input: \"" + input + "\"");
           System.out.println("Expected: " + mapToString(expected));
           System.out.println("Got: " + mapToString(result));
           System.out.println(passed ? "PASSED" : "FAILED");
           System.out.println();
           
       } catch (Exception e) {
           System.out.println("Input: \"" + input + "\"");
           System.out.println("Exception: " + e.getMessage());
           System.out.println();
       }
   }

   /**
    * Helper method to format map as string
    */
   private static String mapToString(Map<String, Integer> map) {
       if (map.isEmpty()) {
           return "{}";
       }
       StringBuilder sb = new StringBuilder("{");
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
           sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
       }
       sb.setLength(sb.length() - 2);  // Remove last ", "
       sb.append("}");
       return sb.toString();
   }

   public static void main(String[] args) {
       runTests();
   }
}