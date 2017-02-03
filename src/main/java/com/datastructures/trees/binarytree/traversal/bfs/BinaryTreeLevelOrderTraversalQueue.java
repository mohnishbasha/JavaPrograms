package com.datastructures.trees.binarytree.traversal.bfs;


/*
http://www.geeksforgeeks.org/level-order-tree-traversal/


METHOD 2 (Use Queue)

Algorithm:
For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root /*start from root
3) Loop while temp_node is not NULL
        a) print temp_node->data.
        b) Enqueue temp_node’s children (first left then right children) to q
        c) Dequeue a node from q and assign it’s value to temp_node
        Implementation:
        Here is a simple implementation of the above algorithm. Queue is implemented using an array with maximum size
        of 500. We can implement queue as linked list also.
 */

/*

Output:
Level order traversal of binary tree is -
1 2 3 4 5

 */

// Iterative Queue based Java program to do level order traversal
// of Binary Tree

/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.LinkedList;

/* Class to represent Tree node */
class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int item) {
        data = item;
        left = null;
        right = null;
    }
}

/* Class to print Level Order Traversal */
class BinaryTreeLevelOrderTraversalQueue {

    Node1 root;

    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */

    void printLevelOrder()
    {
        Queue<Node1> queue = new LinkedList<Node1>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node1 tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BinaryTreeLevelOrderTraversalQueue tree_level = new BinaryTreeLevelOrderTraversalQueue();
        tree_level.root = new Node1(1);
        tree_level.root.left = new Node1(2);
        tree_level.root.right = new Node1(3);
        tree_level.root.left.left = new Node1(4);
        tree_level.root.left.right = new Node1(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}