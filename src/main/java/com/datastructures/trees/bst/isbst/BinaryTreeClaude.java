package com.datastructures.trees.bst.isbst;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
* Binary Tree implementation with basic operations and traversals
*/
public class BinaryTreeClaude {
   
    /**
     * Node class for binary tree
     */
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
    }
 
    private Node root;
 
    /**
     * Creates binary tree from array representation
     * @param values Array with tree values, null represents empty node
     * @throws IllegalArgumentException if values array is invalid
     */
    public BinaryTreeClaude(Integer[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Values array cannot be null");
        }
        this.root = buildTree(values);
    }
 
    /**
     * Helper method to build tree from array
     */
    private Node buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
 
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(values[0]);
        queue.offer(root);
        
        for (int i = 1; i < values.length; i += 2) {
            Node current = queue.poll();
            
            if (current != null) {
                if (i < values.length && values[i] != null) {
                    current.left = new Node(values[i]);
                    queue.offer(current.left);
                }
                if (i + 1 < values.length && values[i + 1] != null) {
                    current.right = new Node(values[i + 1]);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
 
    /**
     * Returns pre-order traversal of tree
     */
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
 
    private void preorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.data);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }
 
    /**
     * Returns in-order traversal of tree
     */
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
 
    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.data);
        inorderHelper(node.right, result);
    }
 
    /**
     * Returns post-order traversal of tree
     */
    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
 
    private void postorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.data);
    }
 
    /**
     * Returns level-order traversal of tree
     */
    public List<List<Integer>> levelorderTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
 
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
 
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                currentLevel.add(current.data);
 
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
 
    /**
     * Returns height of tree
     */
    public int height() {
        return getHeight(root);
    }
 
    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
 
    /**
     * Returns size (number of nodes) in tree
     */
    public int size() {
        return getSize(root);
    }
 
    private int getSize(Node node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }
 
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Binary Tree Tests");
        System.out.println("========================");
 
        // Test 1: Basic Tree Operations
        System.out.println("\nTest 1: Basic Tree");
        testTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 
            "Basic complete binary tree");
 
        // Test 2: Single Node Tree
        System.out.println("\nTest 2: Single Node");
        testTree(new Integer[]{1}, 
            "Single node tree");
 
        // Test 3: Left-skewed Tree
        System.out.println("\nTest 3: Left-skewed");
        testTree(new Integer[]{1, 2, null, 3, null, 4}, 
            "Left-skewed tree");
 
        // Test 4: Right-skewed Tree
        System.out.println("\nTest 4: Right-skewed");
        testTree(new Integer[]{1, null, 2, null, 3, null, 4}, 
            "Right-skewed tree");
 
        // Test 5: Empty Tree
        System.out.println("\nTest 5: Empty Tree");
        try {
            new BinaryTree(new Integer[]{});
            System.out.println("Empty tree created successfully");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
 
        // Test 6: Null Input
        System.out.println("\nTest 6: Null Input");
        try {
            new BinaryTree(null);
            System.out.println("Failed: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught null input");
        }
 
        // Test 7: Complex Tree
        System.out.println("\nTest 7: Complex Tree");
        testTree(new Integer[]{1, 2, 3, null, 4, 5, 6, null, null, 7}, 
            "Complex tree with nulls");
    }
 
    /**
     * Helper method to test tree operations
     */
    private static void testTree(Integer[] values, String description) {
        try {
            System.out.println("\nTesting: " + description);
            System.out.println("Input: " + Arrays.toString(values));
            
            BinaryTree tree = new BinaryTree(values);
            
            System.out.println("Pre-order: " + tree.preorderTraversal());
            System.out.println("In-order: " + tree.inorderTraversal());
            System.out.println("Post-order: " + tree.postorderTraversal());
            System.out.println("Level-order: " + tree.levelorderTraversal());
            System.out.println("Height: " + tree.height());
            System.out.println("Size: " + tree.size());
            
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        runTests();
    }
 }