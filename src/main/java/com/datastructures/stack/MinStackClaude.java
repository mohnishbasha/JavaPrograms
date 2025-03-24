package com.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
* MinStack implementation supporting push, pop, top, and getMin operations
* All operations are O(1) time complexity
*/
class MinStackClaude {
    private Stack<Integer> mainStack;    // Main stack for elements
    private Stack<Integer> minStack;     // Auxiliary stack for minimum elements
 
    /** Initialize MinStack */
    public MinStackClaude() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /** 
     * Pushes element onto stack
     * @param val Value to push
     */
    public void push(int val) {
        mainStack.push(val);
        
        // Update minimum stack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /** 
     * Removes element from top of stack
     * @throws EmptyStackException if stack is empty
     */
    public void pop() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        
        // If popped element is current minimum, update minStack
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }
    
    /** 
     * Returns top element
     * @return Top element
     * @throws EmptyStackException if stack is empty
     */
    public int top() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.peek();
    }
    
    /** 
     * Returns minimum element in stack
     * @return Minimum element
     * @throws EmptyStackException if stack is empty
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }
    
    /**
     * Returns true if stack is empty
     */
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
    
    /**
     * Returns current size of stack
     */
    public int size() {
        return mainStack.size();
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running MinStack Tests");
        System.out.println("=====================");
 
        // Test 1: Basic operations
        System.out.println("\nTest 1: Basic operations");
        MinStack stack1 = new MinStack();
        testPush(stack1, 3);
        testPush(stack1, 5);
        testMin(stack1, 3);
        testPush(stack1, 2);
        testMin(stack1, 2);
        testPop(stack1);
        testMin(stack1, 3);
 
        // Test 2: Empty stack operations
        System.out.println("\nTest 2: Empty stack operations");
        MinStack stack2 = new MinStack();
        testEmptyStackOperations(stack2);
 
        // Test 3: Duplicate values
        System.out.println("\nTest 3: Duplicate values");
        MinStack stack3 = new MinStack();
        testPush(stack3, 2);
        testPush(stack3, 2);
        testMin(stack3, 2);
        testPop(stack3);
        testMin(stack3, 2);
 
        // Test 4: Multiple operations
        System.out.println("\nTest 4: Multiple operations");
        MinStack stack4 = new MinStack();
        testMultipleOperations(stack4);
 
        // Test 5: Negative numbers
        System.out.println("\nTest 5: Negative numbers");
        MinStack stack5 = new MinStack();
        testNegativeNumbers(stack5);
 
        // Test 6: Large numbers
        System.out.println("\nTest 6: Large numbers");
        MinStack stack6 = new MinStack();
        testLargeNumbers(stack6);
    }
 
    private static void testPush(MinStack stack, int val) {
        try {
            stack.push(val);
            System.out.printf("Pushed %d - Stack top: %d, Min: %d%n", 
                val, stack.top(), stack.getMin());
        } catch (Exception e) {
            System.out.println("Push failed: " + e.getMessage());
        }
    }
 
    private static void testPop(MinStack stack) {
        try {
            int top = stack.top();
            stack.pop();
            System.out.printf("Popped %d - New min: %d%n", 
                top, stack.isEmpty() ? -1 : stack.getMin());
        } catch (Exception e) {
            System.out.println("Pop failed: " + e.getMessage());
        }
    }
 
    private static void testMin(MinStack stack, int expected) {
        try {
            int min = stack.getMin();
            System.out.printf("Min value - Expected: %d, Got: %d - %s%n",
                expected, min, min == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.println("GetMin failed: " + e.getMessage());
        }
    }
 
    private static void testEmptyStackOperations(MinStack stack) {
        try {
            stack.pop();
            System.out.println("Failed: Should throw exception for empty stack pop");
        } catch (EmptyStackException e) {
            System.out.println("Passed: Caught empty stack pop");
        }
 
        try {
            stack.getMin();
            System.out.println("Failed: Should throw exception for empty stack getMin");
        } catch (EmptyStackException e) {
            System.out.println("Passed: Caught empty stack getMin");
        }
 
        try {
            stack.top();
            System.out.println("Failed: Should throw exception for empty stack top");
        } catch (EmptyStackException e) {
            System.out.println("Passed: Caught empty stack top");
        }
    }
 
    private static void testMultipleOperations(MinStack stack) {
        testPush(stack, 5);
        testPush(stack, 2);
        testPush(stack, 3);
        testMin(stack, 2);
        testPop(stack);
        testMin(stack, 2);
        testPop(stack);
        testMin(stack, 5);
    }
 
    private static void testNegativeNumbers(MinStack stack) {
        testPush(stack, -2);
        testPush(stack, -5);
        testMin(stack, -5);
        testPush(stack, -1);
        testMin(stack, -5);
        testPop(stack);
        testMin(stack, -5);
    }
 
    private static void testLargeNumbers(MinStack stack) {
        testPush(stack, Integer.MAX_VALUE);
        testPush(stack, Integer.MAX_VALUE - 1);
        testMin(stack, Integer.MAX_VALUE - 1);
        testPush(stack, Integer.MAX_VALUE);
        testMin(stack, Integer.MAX_VALUE - 1);
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }