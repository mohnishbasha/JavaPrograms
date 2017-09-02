package com.datastructures.trees.binarytree.traversal.postorder.stack;

/*
http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/

Iterative Postorder Traversal | Set 2 (Using One Stack)
We have discussed a simple iterative postorder traversal using two stacks in the previous post. In this post, an approach with only one stack is discussed.

The idea is to move down to leftmost node using left pointer. While moving down, push root and root’s right child to stack. Once we reach leftmost node, print it if it doesn’t have a right child. If it has a right child, then change root so that the right child is processed before.

Following is detailed algorithm.

1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.

 */

// A java program for iterative postorder traversal using stack

import java.util.ArrayList;
import java.util.Stack;

// A binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right;
    }
}

class BinaryTree
{
    Node root;
    ArrayList<Integer> list = new ArrayList<Integer>();

    // An iterative function to do postorder traversal
    // of a given binary tree
    ArrayList<Integer> postOrderIterative(Node node)
    {
        Node prev = null;
        Stack<Node> st = new Stack<Node>();

        // Check for empty tree
        if (node == null)
            return list;

        st.push(node);

        while (!st.isEmpty())
        {
            Node current = st.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current)
            {
                if (current.left != null)
                    st.push(current.left);
                else if (current.right != null)
                    st.push(current.right);
                else
                {
                    st.pop();
                    list.add(current.data);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    st.push(current.right);
                else
                {
                    st.pop();
                    list.add(current.data);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            }
            else if (current.right == prev)
            {
                st.pop();
                list.add(current.data);
            }

            prev = current;
        }

        return list;
    }
}

public class PostOrderTraversal {
    // Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);

        System.out.println("Post order traversal of binary tree is :");
        System.out.println(mylist);
    }
}