package com.datastructures.trees.binarytree.traversal.bfs;

/*
http://www.geeksforgeeks.org/level-order-tree-traversal/

Level order traversal of a tree is breadth first traversal for the tree.
https://en.wikipedia.org/wiki/Breadth-first_search
 */

/*

METHOD 1 (Use function to print a given level)

Algorithm:
There are basically two functions in this method. One is to print all nodes at a given level (printGivenLevel), and
other is to print level order traversal of the tree (printLevelorder). printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

// Function to print level order traversal of tree
printLevelorder(tree)
        for d = 1 to height(tree)
        printGivenLevel(tree, d);

// Function to print all nodes at a given level
        printGivenLevel(tree, level)
        if tree is NULL then return;
        if level is 1, then
        print(tree->data);
        else if level greater than 1, then
        printGivenLevel(tree->left, level-1);
        printGivenLevel(tree->right, level-1);

 */

/*

Output:
Level order traversal of binary tree is -
1 2 3 4 5

Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of
nodes in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).

 */



// Recursive Java program for level order traversal of Binary Tree

/* Class containing left and right child of current
   node and key value*/

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTreeLevelOrderTraversalR
{
    // Root of the Binary Tree
    Node root;

    public BinaryTreeLevelOrderTraversalR()
    {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else 
                return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTreeLevelOrderTraversalR tree = new BinaryTreeLevelOrderTraversalR();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}