package com.algorithms.anagram;

import java.util.LinkedList;
import java.util.List;

/**
* Main class to perform anagram searches using suffix tree data structure
*/
public class FindAnagramsUsingTrie {

   /**
    * Runs all test cases
    */
   public static void runTests() {
       try {
           System.out.println("Running Suffix Tree Tests");
           System.out.println("========================");

           // Test 1: Basic suffix tree search
           String text1 = "geeksforgeeks.org";
           SuffixTree tree1 = new SuffixTree(text1);
           
           System.out.println("\nTest 1: Basic search with text: " + text1);
           tree1.searchTree("ee");
           tree1.searchTree("geek"); 
           tree1.searchTree("quiz");
           tree1.searchTree("forgeeks");

           // Test 2: Empty text
           try {
               new SuffixTree("");
               System.out.println("\nFailed: Should throw exception for empty text");
           } catch (IllegalArgumentException e) {
               System.out.println("\nPassed: Caught empty text exception");
           }

           // Test 3: Null text
           try {
               new SuffixTree(null);
               System.out.println("Failed: Should throw exception for null text");
           } catch (IllegalArgumentException e) {
               System.out.println("Passed: Caught null text exception");
           }

           // Test 4: Empty pattern search
           System.out.println("\nTest 4: Empty pattern search");
           try {
               tree1.searchTree("");
               System.out.println("Failed: Should throw exception for empty pattern");
           } catch (IllegalArgumentException e) {
               System.out.println("Passed: Caught empty pattern exception");
           }

           // Test 5: Special characters
           String text2 = "test@#$123";
           SuffixTree tree2 = new SuffixTree(text2);
           System.out.println("\nTest 5: Special character search");
           tree2.searchTree("@#$");
           tree2.searchTree("123");

       } catch (Exception e) {
           System.out.println("Test failed with unexpected error: " + e.getMessage());
           e.printStackTrace();
       }
   }

   /**
    * Main method to run tests
    */
   public static void main(String[] args) {
       runTests();
   }
}

/**
* Node class for suffix trie data structure
*/
class SuffixTrieNode {
   private static final int MAX_CHAR = 256;
   private final SuffixTrieNode[] children;
   private final List<Integer> indexes;

   /**
    * Constructor initializes empty node
    */
   public SuffixTrieNode() {
       indexes = new LinkedList<>();
       children = new SuffixTrieNode[MAX_CHAR];
   }

   /**
    * Inserts a suffix into the trie
    */
   public void insertSuffix(String s, int index) {
       if (s == null) {
           throw new IllegalArgumentException("Suffix cannot be null");
       }

       indexes.add(index);

       if (!s.isEmpty()) {
           char firstChar = s.charAt(0);
           if (children[firstChar] == null) {
               children[firstChar] = new SuffixTrieNode();
           }
           children[firstChar].insertSuffix(s.substring(1), index + 1);
       }
   }

   /**
    * Searches for a pattern in the trie
    * @return List of matching indexes or null if not found
    */
   public List<Integer> search(String s) {
       if (s == null) {
           throw new IllegalArgumentException("Search pattern cannot be null");
       }

       if (s.isEmpty()) {
           return indexes;
       }

       char firstChar = s.charAt(0);
       if (children[firstChar] != null) {
           return children[firstChar].search(s.substring(1));
       }
       return null;
   }
}

/**
* Suffix tree implementation using trie data structure
*/
class SuffixTree {
   private final SuffixTrieNode root;
   private final String text;

   /**
    * Constructs suffix tree from input text
    */
   public SuffixTree(String txt) {
       if (txt == null) {
           throw new IllegalArgumentException("Input text cannot be null");
       }
       if (txt.isEmpty()) {
           throw new IllegalArgumentException("Input text cannot be empty");
       }

       this.text = txt;
       this.root = new SuffixTrieNode();

       // Build suffix tree
       for (int i = 0; i < txt.length(); i++) {
           root.insertSuffix(txt.substring(i), i);
       }
   }

   /**
    * Searches for pattern in the suffix tree
    */
   public void searchTree(String pattern) {
       if (pattern == null) {
           throw new IllegalArgumentException("Search pattern cannot be null");
       }
       if (pattern.isEmpty()) {
           throw new IllegalArgumentException("Search pattern cannot be empty");
       }

       List<Integer> result = root.search(pattern);

       if (result == null) {
           System.out.println("Pattern '" + pattern + "' not found");
       } else {
           System.out.println("Found pattern '" + pattern + "' at positions:");
           for (Integer i : result) {
               System.out.println(i - pattern.length());
           }
       }
   }

   /**
    * Gets the original text
    */
   public String getText() {
       return text;
   }
}