package com.algorithms.problems.salesforce;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MirrorBinaryTree
{
    static class Node
    {
        char value;
        Node left;
        Node right;

        Node(char val)
        {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void mirrorImage(Node root)
    {
        if(root == null)
            return;
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirrorImage(root.left);
        mirrorImage(root.right);
    }

    public static void traversal(Node root)
    {
        if(root == null) return;
        traversal(root.left);
        System.out.print(" "+root.value);
        traversal(root.right);

    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Node root = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');

        root.left = B;
        root.right = C;

        traversal(root);
        mirrorImage(root);
        traversal(root);
    }
}
