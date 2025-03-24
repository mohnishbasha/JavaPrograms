package com.datastructures.trees.binarytree.traversal.bfs;

import java.util.*;

/**
* Implements level order traversal of binary tree
*/
public class BinaryTreeLevelOrderTraversalClaude {
   
   /**
    * Node class for binary tree
    */
   static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       
       TreeNode(int val) {
           this.val = val;
       }
   }
   
   /**
    * Performs level order traversal of binary tree
    * @param root Root node of binary tree
    * @return List of values at each level
    */
   public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       
       if (root == null) {
           return result;
       }
       
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       
       while (!queue.isEmpty()) {
           int levelSize = queue.size();
           List<Integer> currentLevel = new ArrayList<>();
           
           // Process all nodes at current level
           for (int i = 0; i < levelSize; i++) {
               TreeNode current = queue.poll();
               currentLevel.add(current.val);
               
               // Add children to queue
               if (current.left != null) {
                   queue.offer(current.left);
               }
               if (current.right != null) {
                   queue.offer(current.right);
               }
           }
           
           result.add(currentLevel);
       }
       
       return result;
   }

   /**
    * Creates binary tree from array representation
    * Null values represent empty nodes
    */
   private static TreeNode createTree(Integer[] values) {
       if (values == null || values.length == 0 || values[0] == null) {
           return null;
       }

       Queue<TreeNode> queue = new LinkedList<>();
       TreeNode root = new TreeNode(values[0]);
       queue.offer(root);
       
       for (int i = 1; i < values.length; i += 2) {
           TreeNode current = queue.poll();
           if (current != null) {
               if (i < values.length && values[i] != null) {
                   current.left = new TreeNode(values[i]);
                   queue.offer(current.left);
               }
               if (i + 1 < values.length && values[i + 1] != null) {
                   current.right = new TreeNode(values[i + 1]);
                   queue.offer(current.right);
               }
           }
       }
       
       return root;
   }

   /**
    * Runs all test cases
    */
   public static void runTests() {
       System.out.println("Running Binary Tree Level Order Tests");
       System.out.println("====================================");

       // Test 1: Basic tree
       System.out.println("\nTest 1: Basic tree");
       Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
       testCase(test1, "[[1], [2, 3], [4, 5, 6, 7]]");

       // Test 2: Single node
       System.out.println("\nTest 2: Single node");
       Integer[] test2 = {1};
       testCase(test2, "[[1]]");

       // Test 3: Left-skewed tree
       System.out.println("\nTest 3: Left-skewed tree");
       Integer[] test3 = {1, 2, null, 3, null, 4};
       testCase(test3, "[[1], [2], [3], [4]]");

       // Test 4: Right-skewed tree
       System.out.println("\nTest 4: Right-skewed tree");
       Integer[] test4 = {1, null, 2, null, 3, null, 4};
       testCase(test4, "[[1], [2], [3], [4]]");

       // Test 5: Empty tree
       System.out.println("\nTest 5: Empty tree");
       testCase(null, "[]");

       // Test 6: Complete binary tree
       System.out.println("\nTest 6: Complete binary tree");
       Integer[] test6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
       testCase(test6, "[[1], [2, 3], [4, 5, 6, 7], [8, 9, 10, 11, 12, 13, 14, 15]]");

       // Test 7: Incomplete tree
       System.out.println("\nTest 7: Incomplete tree");
       Integer[] test7 = {1, 2, 3, null, 4, null, 5};
       testCase(test7, "[[1], [2, 3], [4, 5]]");
   }

   /**
    * Helper method to test and verify results
    */
   private static void testCase(Integer[] values, String expected) {
       try {
           TreeNode root = createTree(values);
           List<List<Integer>> result = levelOrderTraversal(root);
           String resultStr = result.toString();
           
           System.out.println("Input: " + Arrays.toString(values));
           System.out.println("Expected: " + expected);
           System.out.println("Got: " + resultStr);
           System.out.println(resultStr.equals(expected) ? "PASSED" : "FAILED");
           
       } catch (Exception e) {
           System.out.println("Exception: " + e.getMessage());
       }
   }

   public static void main(String[] args) {
       runTests();
   }
}