package com.datastructures.stack;


import java.util.LinkedList;
import java.util.Queue;

/**
* Stack implementation using two queues
* Makes push operation O(n) and pop operation O(1)
*/
public class StackUsingQueueClaude {
   private Queue<Integer> q1;  // Main queue
   private Queue<Integer> q2;  // Auxiliary queue
   private int top;           // Tracks top element

   /**
    * Initialize stack with two empty queues
    */
   public StackUsingQueueClaude() {
       q1 = new LinkedList<>();
       q2 = new LinkedList<>();
   }

   /**
    * Pushes element onto stack
    * @throws IllegalStateException if stack reaches Integer.MAX_VALUE elements
    */
   public void push(int element) {
       // Check for overflow
       if (q1.size() == Integer.MAX_VALUE) {
           throw new IllegalStateException("Stack is full");
       }

       // Push element to q2
       q2.offer(element);

       // Move all elements from q1 to q2
       while (!q1.isEmpty()) {
           q2.offer(q1.poll());
       }

       // Swap queues
       Queue<Integer> temp = q1;
       q1 = q2;
       q2 = temp;

       // Update top element
       top = element;
   }

   /**
    * Removes and returns top element
    * @throws IllegalStateException if stack is empty
    */
   public int pop() {
       if (isEmpty()) {
           throw new IllegalStateException("Stack is empty");
       }

       top = q1.size() > 1 ? q1.peek() : null;
       return q1.poll();
   }

   /**
    * Returns top element without removing it
    * @throws IllegalStateException if stack is empty
    */
   public int peek() {
       if (isEmpty()) {
           throw new IllegalStateException("Stack is empty");
       }
       return top;
   }

   /**
    * Returns current size of stack
    */
   public int size() {
       return q1.size();
   }

   /**
    * Returns true if stack is empty
    */
   public boolean isEmpty() {
       return q1.isEmpty();
   }

   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Stack Using Queue Tests");
       System.out.println("==============================");

       // Test 1: Basic operations
       System.out.println("\nTest 1: Basic operations");
       StackUsingQueueClaude stack1 = new StackUsingQueueClaude();
       testPush(stack1, 1);
       testPush(stack1, 2);
       testPush(stack1, 3);
       testPeek(stack1, 3);
       testPop(stack1, 3);
       testPop(stack1, 2);
       testSize(stack1, 1);

       // Test 2: Empty stack operations
       System.out.println("\nTest 2: Empty stack operations");
       StackUsingQueueClaude stack2 = new StackUsingQueueClaude();
       try {
           stack2.pop();
           System.out.println("Failed: Should throw exception for empty stack");
       } catch (IllegalStateException e) {
           System.out.println("Passed: Caught empty stack pop");
       }

       try {
           stack2.peek();
           System.out.println("Failed: Should throw exception for empty peek");
       } catch (IllegalStateException e) {
           System.out.println("Passed: Caught empty stack peek");
       }

       // Test 3: Push-pop sequence
       System.out.println("\nTest 3: Push-pop sequence");
       StackUsingQueueClaude stack3 = new StackUsingQueueClaude();
       testPush(stack3, 10);
       testPush(stack3, 20);
       testPop(stack3, 20);
       testPush(stack3, 30);
       testPeek(stack3, 30);
       testSize(stack3, 2);

       // Test 4: Multiple elements
       System.out.println("\nTest 4: Multiple elements");
       StackUsingQueueClaude stack4 = new StackUsingQueueClaude();
       for (int i = 1; i <= 5; i++) {
           testPush(stack4, i);
       }
       for (int i = 5; i >= 1; i--) {
           testPop(stack4, i);
       }
       testIsEmpty(stack4, true);

       // Test 5: Large numbers
       System.out.println("\nTest 5: Large numbers");
       StackUsingQueueClaude stack5 = new StackUsingQueueClaude();
       testPush(stack5, Integer.MAX_VALUE);
       testPush(stack5, Integer.MIN_VALUE);
       testPop(stack5, Integer.MIN_VALUE);
       testPop(stack5, Integer.MAX_VALUE);
       
       // Test 6: Single element operations
       System.out.println("\nTest 6: Single element operations");
       StackUsingQueueClaude stack6 = new StackUsingQueueClaude();
       testPush(stack6, 42);
       testPeek(stack6, 42);
       testPop(stack6, 42);
       testIsEmpty(stack6, true);
   }

   /**
    * Helper methods for testing
    */
   private static void testPush(StackUsingQueueClaude stack, int element) {
       try {
           stack.push(element);
           System.out.printf("Pushed %d - Size: %d%n", element, stack.size());
       } catch (Exception e) {
           System.out.println("Push failed: " + e.getMessage());
       }
   }

   private static void testPop(StackUsingQueueClaude stack, int expected) {
       try {
           int result = stack.pop();
           System.out.printf("Popped %d - Expected: %d - %s%n", 
               result, expected, result == expected ? "PASSED" : "FAILED");
       } catch (Exception e) {
           System.out.println("Pop failed: " + e.getMessage());
       }
   }

   private static void testPeek(StackUsingQueueClaude stack, int expected) {
       try {
           int result = stack.peek();
           System.out.printf("Peek: %d - Expected: %d - %s%n", 
               result, expected, result == expected ? "PASSED" : "FAILED");
       } catch (Exception e) {
           System.out.println("Peek failed: " + e.getMessage());
       }
   }

   private static void testSize(StackUsingQueueClaude stack, int expected) {
       int size = stack.size();
       System.out.printf("Size: %d - Expected: %d - %s%n", 
           size, expected, size == expected ? "PASSED" : "FAILED");
   }

   private static void testIsEmpty(StackUsingQueueClaude stack, boolean expected) {
       boolean isEmpty = stack.isEmpty();
       System.out.printf("Is Empty: %b - Expected: %b - %s%n", 
           isEmpty, expected, isEmpty == expected ? "PASSED" : "FAILED");
   }

   public static void main(String[] args) {
       runTests();
   }
}