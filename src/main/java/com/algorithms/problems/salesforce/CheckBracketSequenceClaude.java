package com.algorithms.problems.salesforce;


import java.util.*;

/**
* Validates balanced bracket sequences using stack approach
*/
public class CheckBracketSequenceClaude {

   /**
    * Checks if bracket sequence is valid/balanced
    * @param sequence String containing brackets to check
    * @return true if sequence is valid, false otherwise
    * @throws IllegalArgumentException if input is null
    */
   public static boolean isValidSequence(String sequence) {
       // Input validation
       if (sequence == null) {
           throw new IllegalArgumentException("Input sequence cannot be null");
       }

       Stack<Character> stack = new Stack<>();

        //  The map is used to:
        //  Store closing brackets as keys
        //  Store corresponding opening brackets as values
        //  This is clever because:
        //  When you encounter a closing bracket in a string, you can quickly look up what opening bracket it should match
       Map<Character, Character> bracketPairs = new HashMap<>();
       bracketPairs.put(')', '(');
       bracketPairs.put('}', '{');
       bracketPairs.put(']', '[');

       // Process each character
       for (char ch : sequence.toCharArray()) {
           // Handle opening brackets
           if (ch == '(' || ch == '{' || ch == '[') {
               stack.push(ch);
               continue;
           }

           // Handle closing brackets
           if (ch == ')' || ch == '}' || ch == ']') {
               // Stack empty means no matching opening bracket
               if (stack.isEmpty()) {
                   return false;
               }

               // Check if matches with top of stack
               if (stack.pop() != bracketPairs.get(ch)) {
                   return false;
               }
           }
       }

       // Stack should be empty if all brackets matched
       return stack.isEmpty();
   }

   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Bracket Sequence Tests");
       System.out.println("=============================");

       // Test 1: Basic valid sequences
       System.out.println("\nTest 1: Basic valid sequences");
       testCase("()", true);
       testCase("[]", true);
       testCase("{}", true);
       testCase("([{}])", true);
       testCase("{[()]}", true);

       // Test 2: Invalid sequences
       System.out.println("\nTest 2: Invalid sequences");
       testCase("(]", false);
       testCase("[}", false);
       testCase("{)", false);
       testCase("([)]", false);
       testCase("{[}]", false);

       // Test 3: Empty and single brackets
       System.out.println("\nTest 3: Empty and single brackets");
       testCase("", true);
       testCase("(", false);
       testCase(")", false);
       testCase("[", false);
       testCase("]", false);

       // Test 4: Nested sequences
       System.out.println("\nTest 4: Nested sequences");
       testCase("((()))", true);
       testCase("{{{}}}", true);
       testCase("[[[[]]]", false);
       testCase("((())", false);
       testCase("{{{}}}", true);

       // Test 5: Mixed sequences
       System.out.println("\nTest 5: Mixed sequences");
       testCase("()[]{}()", true);
       testCase("[({})]", true);
       testCase("{[}]", false);
       testCase("([)]", false);
       testCase("{[()]}", true);

       // Test 6: Edge cases
       System.out.println("\nTest 6: Edge cases");
       try {
           isValidSequence(null);
           System.out.println("Failed: Should throw exception for null input");
       } catch (IllegalArgumentException e) {
           System.out.println("Passed: Caught null input");
       }

       // Test 7: Long sequences
       System.out.println("\nTest 7: Long sequences");
       testCase("({[()]}{[()]})", true);
       testCase("((((((()))))))", true);
       testCase("((((((())))))", false);
       testCase("{{{{{{{}}}}}}}", true);
   }

   /**
    * Helper method to test and verify results
    */
   private static void testCase(String sequence, boolean expected) {
       try {
           boolean result = isValidSequence(sequence);
           System.out.printf("\"%s\": Expected %b, Got %b - %s%n",
               sequence, expected, result,
               result == expected ? "PASSED" : "FAILED");
       } catch (Exception e) {
           System.out.printf("\"%s\": Exception: %s%n",
               sequence, e.getMessage());
       }
   }

   public static void main(String[] args) {
       runTests();
   }
}