package com.algorithms.anagram;

/*
Anagram:
http://www.java.achchuthan.org/2013/06/find-all-anagrams-of-word-in-java.html

Find all anagrams of a word in Java
dogs sgod gsod ogsd
dosg sgdo gsdo ogds
dsgo sdgo gdso osdg
dsog sdog gdos osgd
dgso sodg gods odgs
dgos sogd gosd odsg

 */

/*

So, when we came up with the permutations of “dogs” above, how did we do it? What were we implicitly thinking? Well,
it looks like what we did in each column was choose one letter to start with, and then we found all the possible
combinations for the string beginning with that letter. And once we picked a letter in the 2nd position, we then found
all the possible combinations that begin with that 2 letter sequence before we changed any of the letters in the first
2 positions. So, basically what we did was choose a letter and then peformed the permutation process starting at the
next position to the right before we come back and change the character on the left.

Finding the permutations with recursion
 Our description of the process that we followed sounds a lot like something that could be solved with recursion. How
 can we change our description so that it’s easier to write out in a recursive method? 
 
 Let’s phrase it like this: 
 In order to find all possible combinations for a given string, then start at a position x, then find and place all
 possible letters in position x. 
 
 Every time we put a new letter in position x, we should then find all the possible
 combinations at position x+1 – this would be the recursive call that we make. 
 
 How do we know when to print out a
 string? 
 
 Well, when we are at a position x that is greater than the number of letters in the input string, then we
 know that we have found one valid combination/permutation of the string and then we can print it out and return to
 changing letters at positions less than x. 
 
 This would be our base case – remember that we always must have a
 recursive case and a base case when using recursion.

 Which letters can we use in a given position?
 Another big part of this problem is figuring out which letters we can put in a given position. Using our sample string
  “dogs”, lets say that we are going through all the permutations where the first 2 letters are “gs”. Then, it should
  be clear that the letters in the 3rd or 4th position can only be either “d” or “o”, because “g” and “s” were already
  used. As part of our algorithm, we have to know which letters can be used in a given position – because we can’t reuse
   the letters that were used in the earlier positions. And in order to do this we can simply have an array of Boolean
   values that correspond to the positions of the letters in the input string – so if a certain character from the input
    string has already been used, then it’s position in the array would be set to “true”.

 */

 /*
  * Algorithm:
  - base case: start at position x, then find and place all possible letters in position x
  - Every time we put a new letter in position x, we should then find all the possible
    combinations at position x+1 – this would be the recursive call that we make
  - when we are at a position x that is greater than the number of letters in the input string, then we
 know that we have found one valid combination/permutation of the string and then we can print it out and return to
 changing letters at positions less than x. 
 - This would be our base case – remember that we always must have a
 recursive case and a base case when using recursion.

Algorithm Summary:
1. Base Case: If the current position `x` exceeds the length of the input string, a valid permutation is found. Print it and backtrack.  
2. Recursive Case: For each position `x`, place all possible letters, and recursively generate combinations for position `x+1`.  
3. Repeat until all permutations of the string are generated.  
This approach ensures every combination is explored through recursion with clear base and recursive cases.
  */

/**
 * Generates all possible anagrams of a given word using recursion
 * Uses Heap's Algorithm for generating permutations
 */
public class GenerateAnagrams {
    private final char[] characters;  // Store characters of the word
    private final String originalWord;  // Store original word for reference 
    private int anagramCount;  // Count of generated anagrams
    private static final int MAX_WORD_LENGTH = 10;  // Limit word length to prevent stack overflow

    /**
     * Constructor initializes the anagram generator with input validation
     */
    public GenerateAnagrams(String word) {
        // Input validation
        if (word == null) {
            throw new IllegalArgumentException("Input word cannot be null");
        }

        String cleanWord = word.trim().toLowerCase();

        if (cleanWord.isEmpty()) {
            throw new IllegalArgumentException("Input word cannot be empty");
        }

        if (cleanWord.length() > MAX_WORD_LENGTH) {
            throw new IllegalArgumentException(
                "Word length exceeds maximum limit of " + MAX_WORD_LENGTH + " characters");
        }

        if (!cleanWord.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException(
                "Word must contain only letters: " + word);
        }

        this.originalWord = cleanWord;
        this.characters = cleanWord.toCharArray();
        this.anagramCount = 0;

        // Generate anagrams
        System.out.println("\nGenerating anagrams for: " + word);
        System.out.println("========================");
        generateAnagrams(characters.length);
        System.out.println("Total anagrams generated: " + anagramCount);
    }

    /**
     * Recursively generates anagrams using Heap's Algorithm
     */
    private void generateAnagrams(int size) {
        if (size == 1) {
            displayAnagram();
            return;
        }

        /* 
         * Let's break down this code snippet which is part of Heap's Algorithm for generating permutations:

            Let's explain each part:

            1. `generateAnagrams(size - 1)`: 
            - This is the recursive call that generates permutations for a smaller subset
            - Each time, it works with one fewer element (size - 1)
            - When size becomes 1, it hits the base case and prints the current permutation

            2. `int j = (size % 2 == 1) ? 0 : i`:
            - If size is odd: j = 0
            - If size is even: j = i
            - This alternating pattern ensures we generate all possible permutations without repetition

            3. `swapCharacters(j, size - 1)`:
            - Swaps two characters in the array to create a new arrangement
            - One character is at position j (determined by the previous step)
            - The other is at position size-1 (last position in current subset)

            This is Heap's Algorithm, which is more efficient than naive permutation algorithms because it 
            generates each permutation by swapping just two elements from the previous permutation, 
            rather than rebuilding the sequence each time.
         */

        for (int i = 0; i < size; i++) {
            generateAnagrams(size - 1);
            int j = (size % 2 == 1) ? 0 : i; // if size is odd j=1, else j = 0
            swapCharacters(j, size - 1);
        }
    }

    /**
     * Swaps two characters in the array
     */
    private void swapCharacters(int i, int j) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }

    /**
     * Displays current anagram and updates count
     */
    private void displayAnagram() {
        String anagram = new String(characters);
        if (!anagram.equals(originalWord)) {
            System.out.println(anagram);
            anagramCount++;
        }
    }

    /**
     * Runs all test cases
     */
    public static void runTests() {
        try {
            new GenerateAnagrams("Love");  // Test 4-letter word
            new GenerateAnagrams("Dogs");  // Test another 4-letter word
            new GenerateAnagrams("Zental");  // Test 6-letter word
            
            // Test edge cases
            try {
                new GenerateAnagrams("");
            } catch (IllegalArgumentException e) {
                System.out.println("Empty string test passed: " + e.getMessage());
            }

            try {
                new GenerateAnagrams(null);
            } catch (IllegalArgumentException e) {
                System.out.println("Null input test passed: " + e.getMessage());
            }

            try {
                new GenerateAnagrams("SuperCalifragilistic");
            } catch (IllegalArgumentException e) {
                System.out.println("Long word test passed: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Main method invokes the tests
     */
    public static void main(String[] args) {
        runTests();
    }
}