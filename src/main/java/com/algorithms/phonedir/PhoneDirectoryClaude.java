package com.algorithms.phonedir;

import java.util.*;

/*
 * Implement a Phone Directory
    Given a list of contacts which exist in a phone directory. The task is to implement search query for the phone directory.
    The search query on a string ‘str’ displays all the contacts which prefix as ‘str’. One special property of the search
    function is that, when a user searches for a contact from the contact list then suggestions (Contacts with prefix as
    the string entered so for) are shown after user enters each character.

    Note : Contacts in the list consist of only lower case alphabets.

    Example:
    Input : contacts [] = {“gforgeeks” , “geeksquiz” }
            Query String = “gekk”

    Output : Suggestions based on "g" are
            geeksquiz
            gforgeeks

            Suggestions based on "ge" are
            geeksquiz

            No Results Found for "gek"

            No Results Found for "gekk"
 */

/**
* Phone directory implementation using Trie data structure
* Provides prefix based contact search/suggestions
*/
public class PhoneDirectoryClaude {

   /**
    * Trie node class for storing contact information 
    */
    private static class TrieNode {
        // Stores child nodes, where each key is a character and value is the corresponding TrieNode
        Map<Character, TrieNode> children;
        
        // Marks if this node represents the end of a valid contact
        boolean isEndOfWord;
        
        // Stores the complete contact string at leaf nodes
        String contact;
        
        // Constructor initializes an empty node
        TrieNode() {
            children = new HashMap<>();  // Initialize empty map for children
            isEndOfWord = false;        // Not end of word by default
            contact = null;             // No contact stored initially
        }
    }
   
   private final TrieNode root;
   
   public PhoneDirectoryClaude() {
       root = new TrieNode();
   }
   
   /**
    * Adds a contact to the directory
    * @param contact Contact to add
    * @throws IllegalArgumentException if contact is invalid
    */
   public void addContact(String contact) {
       // Validate contact
       if (contact == null || contact.isEmpty()) {
           throw new IllegalArgumentException("Contact cannot be null or empty");
       }
       
       if (!contact.matches("[a-z]+")) {
           throw new IllegalArgumentException("Contact must contain only lowercase letters");
       }
       
       // Add to trie
       TrieNode current = root;
       for (char ch : contact.toCharArray()) {
           current.children.putIfAbsent(ch, new TrieNode());
           current = current.children.get(ch);
       }
       current.isEndOfWord = true;
       current.contact = contact;
   }
   
   /**
    * Searches directory for contacts matching prefix
    * @param prefix Search prefix
    * @return List of matching contacts
    * @throws IllegalArgumentException if prefix is invalid
    */
   public List<String> search(String prefix) {
       // Validate prefix
       if (prefix == null) {
           throw new IllegalArgumentException("Search prefix cannot be null");
       }
       
       if (!prefix.isEmpty() && !prefix.matches("[a-z]+")) {
           throw new IllegalArgumentException("Search prefix must contain only lowercase letters");
       }
       
       List<String> results = new ArrayList<>();
       
       // Find node for last character of prefix
       TrieNode current = root;
       for (char ch : prefix.toCharArray()) {
           if (!current.children.containsKey(ch)) {
               return results; // No matches found
           }
           current = current.children.get(ch);
       }
       
       // Collect all words under this node
       collectWords(current, results);
       return results;
   }
   
   /**
    * Helper method to collect all words under a node
    */

    // Let's say we have these contacts: "john", "jane", "jack"
    // The trie looks like:
    //         root
    //         |
    //         j
    //         |
    //     +----|----+
    //     o     a    a
    //     |     |    |
    //     h     n    c
    //     |     |    |
    //     n     e    k

    // When collectWords is called:
    // - It checks if current node is end of word (isEndOfWord = true)
    // - If yes, adds that contact to results list
    // - Then recursively visits all child nodes
    // - Process continues until all paths are explored
    // - So if we call collectWords starting at the 'j' node:
    // - It will traverse all paths below 'j'
    // - And collect "john", "jane", "jack" in the results list
    // - This is particularly useful for the phone directory's prefix search, as it collects all contacts that share a given prefix.
        
   private void collectWords(TrieNode node, List<String> results) {
       if (node.isEndOfWord) {
           results.add(node.contact);
       }
       
       for (TrieNode child : node.children.values()) {
           collectWords(child, results);
       }
   }

   /**
    * Helper method to run test cases
    */
   private static void testSearchQuery(PhoneDirectoryClaude directory, String query) {
       System.out.println("\nSearch query: \"" + query + "\"");
       for (int i = 1; i <= query.length(); i++) {
           String prefix = query.substring(0, i);
           List<String> suggestions = directory.search(prefix);
           System.out.printf("\nSuggestions based on \"%s\" are:%n", prefix);
           if (suggestions.isEmpty()) {
               System.out.println("No Results Found");
           } else {
               suggestions.forEach(contact -> System.out.println(contact));
           }
       }
   }
   
   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Phone Directory Tests");
       System.out.println("============================");
       
       // Test 1: Basic functionality
       System.out.println("\nTest 1: Basic functionality");
       PhoneDirectoryClaude dir1 = new PhoneDirectoryClaude();
       dir1.addContact("gforgeeks");
       dir1.addContact("geeksquiz");
       testSearchQuery(dir1, "gekk");
       
       // Test 2: Multiple matching contacts
       System.out.println("\nTest 2: Multiple matching contacts");
       PhoneDirectoryClaude dir2 = new PhoneDirectoryClaude();
       dir2.addContact("john");
       dir2.addContact("jane");
       dir2.addContact("jack");
       dir2.addContact("james");
       testSearchQuery(dir2, "ja");
       
       // Test 3: No matches
       System.out.println("\nTest 3: No matches");
       PhoneDirectoryClaude dir3 = new PhoneDirectoryClaude();
       dir3.addContact("alice");
       dir3.addContact("bob");
       testSearchQuery(dir3, "charlie");
       
       // Test 4: Empty prefix
       System.out.println("\nTest 4: Empty prefix");
       PhoneDirectoryClaude dir4 = new PhoneDirectoryClaude();
       dir4.addContact("test");
       System.out.println("\nAll contacts:");
       dir4.search("").forEach(System.out::println);
       
       // Test 5: Invalid inputs
       System.out.println("\nTest 5: Invalid inputs");
       PhoneDirectoryClaude dir5 = new PhoneDirectoryClaude();
       try {
           dir5.addContact(null);
           System.out.println("Failed: Should throw exception for null contact");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught null contact");
       }
       
       try {
           dir5.addContact("ABC");  // Uppercase
           System.out.println("Failed: Should throw exception for uppercase letters");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught uppercase letters");
       }
       
       try {
           dir5.addContact("test123");  // Numbers
           System.out.println("Failed: Should throw exception for numbers");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught numbers in contact");
       }
       
       // Test 6: Duplicate contacts
       System.out.println("\nTest 6: Duplicate contacts");
       PhoneDirectoryClaude dir6 = new PhoneDirectoryClaude();
       dir6.addContact("test");
       dir6.addContact("test");  // Should not cause issues
       System.out.println("Contacts with prefix 't':");
       dir6.search("t").forEach(System.out::println);
   }
   
   public static void main(String[] args) {
       runTests();
   }
}