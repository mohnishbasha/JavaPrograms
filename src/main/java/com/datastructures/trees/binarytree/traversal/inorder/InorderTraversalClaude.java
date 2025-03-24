package com.datastructures.trees.binarytree.traversal.inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* Implements in-order traversal of binary tree
* (Left -> Root -> Right)
*/
public class InorderTraversalClaude {
   
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
     * Performs in-order traversal iteratively 
     * @param root Root of binary tree
     * @return List of values in in-order sequence
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Traverse to leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Process current node
            current = stack.pop();
            result.add(current.val);
            
            // Move to right subtree
            current = current.right;
        }
        
        return result;
    }
    
    /**
     * Recursive in-order traversal helper
     */
    private static void inorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorderRecursive(root.left, result);
        result.add(root.val);
        inorderRecursive(root.right, result);
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
        System.out.println("Running In-Order Traversal Tests");
        System.out.println("===============================");
 
        // Test 1: Basic binary tree
        System.out.println("\nTest 1: Basic binary tree");
        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
        testCase(test1, "[4, 2, 5, 1, 6, 3, 7]");
 
        // Test 2: Single node
        System.out.println("\nTest 2: Single node");
        Integer[] test2 = {1};
        testCase(test2, "[1]");
 
        // Test 3: Left-skewed tree
        System.out.println("\nTest 3: Left-skewed tree");
        Integer[] test3 = {3, 2, null, 1};
        testCase(test3, "[1, 2, 3]");
 
        // Test 4: Right-skewed tree
        System.out.println("\nTest 4: Right-skewed tree");
        Integer[] test4 = {1, null, 2, null, 3};
        testCase(test4, "[1, 2, 3]");
 
        // Test 5: Empty tree
        System.out.println("\nTest 5: Empty tree");
        testCase(null, "[]");
 
        // Test 6: Binary search tree
        System.out.println("\nTest 6: Binary search tree");
        Integer[] test6 = {4, 2, 6, 1, 3, 5, 7};
        testCase(test6, "[1, 2, 3, 4, 5, 6, 7]");
 
        // Test 7: Unbalanced tree
        System.out.println("\nTest 7: Unbalanced tree");
        Integer[] test7 = {1, 2, null, 3, 4, null, null, 5};
        testCase(test7, "[5, 3, 4, 2, 1]");
 
        // Compare iterative and recursive results
        System.out.println("\nTest 8: Compare iterative vs recursive");
        Integer[] test8 = {1, 2, 3, 4, 5, 6, 7};
        compareIterativeRecursive(test8);
    }
 
    /**
     * Helper method to test and verify results
     */
    private static void testCase(Integer[] values, String expected) {
        try {
            TreeNode root = createTree(values);
            List<Integer> result = inorderTraversal(root);
            String resultStr = result.toString();
            
            System.out.println("Input: " + Arrays.toString(values));
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + resultStr);
            System.out.println(resultStr.equals(expected) ? "PASSED" : "FAILED");
            
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
 
    /**
     * Helper method to compare iterative and recursive approaches
     */
    private static void compareIterativeRecursive(Integer[] values) {
        TreeNode root = createTree(values);
        
        // Get iterative result
        List<Integer> iterative = inorderTraversal(root);
        
        // Get recursive result
        List<Integer> recursive = new ArrayList<>();
        inorderRecursive(root, recursive);
        
        System.out.println("Input: " + Arrays.toString(values));
        System.out.println("Iterative: " + iterative);
        System.out.println("Recursive: " + recursive);
        System.out.println(iterative.equals(recursive) ? "MATCH" : "MISMATCH");
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }