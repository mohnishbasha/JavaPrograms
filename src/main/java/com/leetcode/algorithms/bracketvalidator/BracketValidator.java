package com.leetcode.algorithms.bracketvalidator;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * 
 */
public class BracketValidator {


    // ---------------------------------------------------------------------
    // [Expected Approach 1] Using Stack – O(n) Time and O(n) Space
    /*
     * 
     * Step-by-step approach:
     * Declare a character stack (say temp).
     * Now traverse the string exp. 
     * - If the current character is a starting bracket ( ‘(‘ or ‘{‘  or ‘[‘ ) then push it to stack.
     * - If the current character is a closing bracket ( ‘)’ or ‘}’ or ‘]’ ) then pop from the stack and if the popped character is the matching starting bracket then fine.
     * - Else brackets are Not Balanced.
     * After complete traversal, if some starting brackets are left in the stack then the expression is Not balanced, else Balanced.
     * 
     */
    
     public static boolean isValid1(String s) {  

        // Declare a stack to hold the previous brackets.
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
          
            // Check if the character is an opening bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i)); 
            } 
            else {
              
                // If it's a closing bracket, check if the stack is non-empty
                // and if the top of the stack is a matching opening bracket
                if (!stk.empty() && 
                    ((stk.peek() == '(' && s.charAt(i) == ')') ||
                     (stk.peek() == '{' && s.charAt(i) == '}') ||
                     (stk.peek() == '[' && s.charAt(i) == ']'))) {
                    stk.pop(); 
                }
                else {
                    return false; // Unmatched closing bracket
                }
            }
        }
      
        // If stack is empty, return true (balanced), 
        // otherwise false
        return stk.empty();
    }

    // ---------------------------------------------------------------------
    // [Expected Approach 2] Without using Stack – O(n) Time and O(1) Space

    // Check if characters match
    public static boolean checkMatch(char c1, char c2) {
        
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        
        return false;
    }

    public static boolean isValid2(String s){
  
        // Initialize top to -1 (empty stack simulation)
        int top = -1;

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; ++i){
          
            // Push char if stack is empty or no match
            if (top < 0 || !checkMatch(c[top], c[i])){
                ++top;
                c[top] = c[i];
            } else {
              
                // Pop from stack if match found
                --top;
            }
        }
      
        // Return true if stack is empty (balanced)
        return top == -1;
    }
    
    // ---------------------------------------------------------------------
    // [Expected Approach 3] With using a Optimized Stack – O(n) Time and O(n) Space
    public static boolean isValid3(String s) {

        // If the length of string is odd, it cannot be valid.
        if (s.length() % 2 != 0) return false;

        // Create a Stack to keep track of opening brackets.
        Stack<Character> stack = new Stack<>();
    
        // Iterate through each character in the input string.
        for (char c : s.toCharArray()) {

            // Push the corresponding closing bracket for each opening bracket onto the stack.
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                // If stack is empty or top does not match with the closing bracket, return false.
                return false;
            }
        }

        // If stack is empty, all the opening brackets had a matching closing pair.
        return stack.isEmpty();
    
    }

    public static void main(String[] args) {

        // approach 1
        String s = "{()}[]";

        // test1
        if (isValid1(s))
            System.out.println("true");
        else
            System.out.println("false");

        // test 2
        if (isValid2(s))
            System.out.println("true");
        else
            System.out.println("false");

        // test 3
        if (isValid3(s))
            System.out.println("true");
        else
            System.out.println("false");
    }
    
}
