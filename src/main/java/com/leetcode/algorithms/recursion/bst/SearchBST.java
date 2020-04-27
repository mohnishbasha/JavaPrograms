package com.leetcode.algorithms.recursion.bst;

/*

https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3233/

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's
value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,
Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

You should return this subtree:

      2
     / \
    1   3

In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.

*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SearchBST {


    public TreeNode searchBST_recursion(TreeNode root, int val) {

        if (root == null || val == root.val) return root;

        return val < root.val ? searchBST_recursion(root.left, val) : searchBST_recursion(root.right, val);
    }


    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }

}
