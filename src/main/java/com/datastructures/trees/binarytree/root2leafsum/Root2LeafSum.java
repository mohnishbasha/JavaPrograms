package com.datastructures.trees.binarytree.root2leafsum;


import com.datastructures.trees.bst.isbst.BinaryTreeClaude;
import com.datastructures.trees.bst.isbst.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Youtube link - https://youtu.be/Jg4E4KZstFE
 *
 * Given a binary tree and a sum, find if there is a path from root to leaf
 * which sums to this sum.
 *
 * Solution
 * Keep going left and right and keep subtracting node value from sum.
 * If leaf node is reached check if whatever sum is remaining same as leaf node data.
 *
 * Time complexity is O(n) since all nodes are visited.
 *
 * Test cases:
 * Negative number, 0 and positive number
 * Tree with 0, 1 or more nodes
 *
 * Reference http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 */

public class Root2LeafSum {

    public boolean root2leaf(Node root, int sum, List<Node> path){

        // if root is null
        if(root == null){
            return false;
        }

        // if left and right tree is null
        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }

        // if path is true
        if(root2leaf(root.left, sum - root.data, path) || root2leaf(root.right, sum - root.data, path)){
            path.add(root);
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        Root2LeafSum rtl = new Root2LeafSum();
        Node head = null;
        List<Node> result = new ArrayList<>();

        BinaryTreeClaude bt = new BinaryTreeClaude();
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(4, head);
        head = bt.addNode(3, head);

        boolean r = rtl.root2leaf(head, 22, result);
        if(r){
            result.forEach(node -> System.out.print(node.data + " "));
        } else{
            System.out.println("No path for sum " + 22);
        }
    }
}