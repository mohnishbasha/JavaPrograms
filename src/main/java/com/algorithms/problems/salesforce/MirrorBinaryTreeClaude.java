package com.algorithms.problems.salesforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Creates mirror image of a binary tree by swapping left and right nodes
*/
public class MirrorBinaryTreeClaude {
   
    /**
     * Node class for binary tree
     */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int data) {
            this.data = data;
        }
    }
    
    /**
     * Creates mirror image of binary tree
     * @param root Root node of tree
     * @return Root node of mirrored tree
     */
    public static TreeNode mirror(TreeNode root) {
        // Base case
        if (root == null) {
            return null;
        }
        
        // Recursively mirror subtrees
        TreeNode leftMirrored = mirror(root.left);
        TreeNode rightMirrored = mirror(root.right);
        
        // Swap left and right pointers
        root.left = rightMirrored;
        root.right = leftMirrored;
        
        return root;
    }
    
    /**
     * Helper method to create binary tree from array
     * Null values represent empty nodes
     */
    private static TreeNode createTree(Integer[] inputs) {
        if (inputs == null || inputs.length == 0 || inputs[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(inputs[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        for (int i = 1; i < inputs.length; i += 2) {
            TreeNode current = queue.poll();
            
            if (current != null) {

                if (i < inputs.length && inputs[i] != null) {
                    current.left = new TreeNode(inputs[i]);
                    queue.offer(current.left);
                }

                if (i + 1 < inputs.length && inputs[i + 1] != null) {
                    current.right = new TreeNode(inputs[i + 1]);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
    
    /**
     * Helper method to get level-order traversal of tree (Bredth First Search)
     */
    private static List<Integer> levelOrder(TreeNode root) {

        List<Integer> result = new ArrayList<>();    // Stores final traversal
        
        if (root == null) return result;   // Handle empty tree
        
        Queue<TreeNode> queue = new LinkedList<>();  // Queue for BFS
        queue.offer(root);                          // Start with root
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();           // Get next node
            result.add(node.data);                  // Add to result
            
            // Add children to queue (if they exist)
            if (node.left != null)  queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        return result;
    }
    
    /**
     * Helper method to compare two trees
     */
    private static boolean areTreesEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        
        return root1.data == root2.data &&
               areTreesEqual(root1.left, root2.left) &&
               areTreesEqual(root1.right, root2.right);
    }
    
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running Mirror Binary Tree Tests");
        System.out.println("================================");
        
        // Test 1: Basic tree
        System.out.println("\nTest 1: Basic tree");
        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
        testCase(test1, "Basic balanced tree");
        
        // Test 2: Left-skewed tree
        System.out.println("\nTest 2: Left-skewed tree");
        Integer[] test2 = {1, 2, null, 3, null, 4, null};
        testCase(test2, "Left-skewed tree");
        
        // Test 3: Right-skewed tree
        System.out.println("\nTest 3: Right-skewed tree");
        Integer[] test3 = {1, null, 2, null, 3, null, 4};
        testCase(test3, "Right-skewed tree");
        
        // Test 4: Single node
        System.out.println("\nTest 4: Single node");
        Integer[] test4 = {1};
        testCase(test4, "Single node tree");
        
        // Test 5: Empty tree
        System.out.println("\nTest 5: Empty tree");
        Integer[] test5 = null;
        testCase(test5, "Empty tree");
        
        // Test 6: Complex tree
        System.out.println("\nTest 6: Complex tree");
        Integer[] test6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        testCase(test6, "Complex complete tree");
        
        // Test 7: Incomplete tree
        System.out.println("\nTest 7: Incomplete tree");
        Integer[] test7 = {1, 2, 3, null, 4, null, 5};
        testCase(test7, "Incomplete tree");
    }
    
    /**
     * Helper method to test and verify results
     */
    private static void testCase(Integer[] values, String description) {
        try {
            System.out.println("\nTesting: " + description);
            
            // Create original tree
            TreeNode original = createTree(values);
            System.out.println("Original tree (level-order): " + 
                             levelOrder(original));
            
            // Create mirror
            TreeNode mirrored = mirror(createTree(values));
            System.out.println("Mirrored tree (level-order): " + 
                             levelOrder(mirrored));
            
            // Mirror again should give original tree
            TreeNode doubleMirrored = mirror(createTree(values));
            boolean isCorrect = areTreesEqual(original, doubleMirrored);
            
            System.out.println("Double mirror matches original: " + 
                             (isCorrect ? "PASSED" : "FAILED"));
            
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        runTests();
    }
 }