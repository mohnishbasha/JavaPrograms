package com.datastructures.stack;

/**
* Stack implementation using array with fixed capacity
*/
public class StackUsingArrayClaude {
    private int[] array;      // Array to store elements
    private int top;          // Index of top element
    private int capacity;     // Maximum capacity
 
    /**
     * Initialize stack with given capacity
     * @throws IllegalArgumentException if capacity is non-positive
     */
    public StackUsingArrayClaude(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1;
    }
 
    /**
     * Pushes element onto stack
     * @throws StackOverflowException if stack is full
     */
    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowException("Stack is full");
        }
        array[++top] = element;
    }
 
    /**
     * Removes and returns top element
     * @throws EmptyStackException if stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top--];
    }
 
    /**
     * Returns top element without removing it
     * @throws EmptyStackException if stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }
 
    /**
     * Returns current size of stack
     */
    public int size() {
        return top + 1;
    }
 
    /**
     * Returns true if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }
 
    /**
     * Returns true if stack is full
     */
    public boolean isFull() {
        return top == capacity - 1;
    }
 
    /**
     * Custom exception for stack overflow
     */
    private static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String message) {
            super(message);
        }
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Stack Tests");
        System.out.println("==================");
 
        // Test 1: Basic operations
        System.out.println("\nTest 1: Basic operations");
        StackUsingArrayClaude stack1 = new StackUsingArrayClaude(3);
        testPush(stack1, 1);
        testPush(stack1, 2);
        testPush(stack1, 3);
        testPeek(stack1, 3);
        testPop(stack1, 3);
        testPop(stack1, 2);
        testSize(stack1, 1);
 
        // Test 2: Stack overflow
        System.out.println("\nTest 2: Stack overflow");
        StackUsingArrayClaude stack2 = new StackUsingArrayClaude(2);
        testPush(stack2, 1);
        testPush(stack2, 2);
        try {
            stack2.push(3);
            System.out.println("Failed: Should throw StackOverflowException");
        } catch (StackOverflowException e) {
            System.out.println("Passed: Caught stack overflow");
        }
 
        // Test 3: Empty stack operations
        System.out.println("\nTest 3: Empty stack operations");
        StackUsingArrayClaude stack3 = new StackUsingArrayClaude(3);
        try {
            stack3.pop();
            System.out.println("Failed: Should throw EmptyStackException");
        } catch (EmptyStackException e) {
            System.out.println("Passed: Caught empty stack pop");
        }
 
        try {
            stack3.peek();
            System.out.println("Failed: Should throw EmptyStackException");
        } catch (EmptyStackException e) {
            System.out.println("Passed: Caught empty stack peek");
        }
 
        // Test 4: Push-pop sequence
        System.out.println("\nTest 4: Push-pop sequence");
        StackUsingArrayClaude stack4 = new StackUsingArrayClaude(5);
        testPush(stack4, 10);
        testPush(stack4, 20);
        testPop(stack4, 20);
        testPush(stack4, 30);
        testPeek(stack4, 30);
        testSize(stack4, 2);
 
        // Test 5: Invalid capacity
        System.out.println("\nTest 5: Invalid capacity");
        try {
            new StackUsingArrayClaude(0);
            System.out.println("Failed: Should throw exception for zero capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught zero capacity");
        }
 
        try {
            new StackUsingArrayClaude(-1);
            System.out.println("Failed: Should throw exception for negative capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative capacity");
        }
 
        // Test 6: Full cycle
        System.out.println("\nTest 6: Full cycle");
        StackUsingArrayClaude stack6 = new StackUsingArrayClaude(3);
        testPush(stack6, 1);
        testPush(stack6, 2);
        testPush(stack6, 3);
        testPop(stack6, 3);
        testPop(stack6, 2);
        testPop(stack6, 1);
        testIsEmpty(stack6, true);
    }
 
    /**
     * Helper methods for testing
     */
    private static void testPush(StackUsingArrayClaude stack, int element) {
        try {
            stack.push(element);
            System.out.printf("Pushed %d - Size: %d%n", element, stack.size());
        } catch (Exception e) {
            System.out.println("Push failed: " + e.getMessage());
        }
    }
 
    private static void testPop(StackUsingArrayClaude stack, int expected) {
        try {
            int result = stack.pop();
            System.out.printf("Popped %d - Expected: %d - %s%n", 
                result, expected, result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.println("Pop failed: " + e.getMessage());
        }
    }
 
    private static void testPeek(StackUsingArrayClaude stack, int expected) {
        try {
            int result = stack.peek();
            System.out.printf("Peek: %d - Expected: %d - %s%n", 
                result, expected, result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.println("Peek failed: " + e.getMessage());
        }
    }
 
    private static void testSize(StackUsingArrayClaude stack, int expected) {
        int size = stack.size();
        System.out.printf("Size: %d - Expected: %d - %s%n", 
            size, expected, size == expected ? "PASSED" : "FAILED");
    }
 
    private static void testIsEmpty(StackUsingArrayClaude stack, boolean expected) {
        boolean isEmpty = stack.isEmpty();
        System.out.printf("Is Empty: %b - Expected: %b - %s%n", 
            isEmpty, expected, isEmpty == expected ? "PASSED" : "FAILED");
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }