package com.algorithms.sort;

/**
 *
 *
 * Tree Sort - Binary Search Tree Implementation in java.
 Tree Sort is a sort algorithm, which uses the Binary Search Tree (BST) concept. In this sort, we insert the elements
 in BST and the retrieving them in specific order will give us the desired result of sorting. For instance, if traverse
 in In-Order, the result would be sorted list of elements in ascending order and if traverse in Right->Root->Left order
 in BST, the result would be the sorted list of elements in descending order.

 The following code in java will implement the BST, the code is self-explanatory. In this implementation, recursive
 approach is used for inserting the new element in the tree instead of iterative approach.
 *
 * Average performance	O(n log n)
 * http://suresolution.blogspot.com/2012/07/tree-sort-binary-search-tree.html
 */


/*
 * BASIC NODE STORED IN A TREE.
 */
class Node {
    public Object element;
    public Node left;
    public Node right;

    // CONSTRUCTORS
    public Node(Object theElement) {
        this(theElement, null, null);
    }

    public Node(Object theElement, Node lLink, Node rLink) {
        element = theElement;
        this.left = lLink;
        this.right = rLink;
    }
}

/*
 * BST CLASS HAVE ONLY 1 CONSTRUCTOR, WHICH TAKES AS PARAMETER AN OBJECT TYPE.
 * ROOT ELEMENT WILL BE THE FIRST ELEMENT IN THE LIST OF ELEMENTS TO SORT.
 */

public class BinaryTreeSort {
    public Node root;

    public BinaryTreeSort(Object x) { // ONLY CONSTRUCTOR//
        root = new Node(x);
    }

    /* ( RECURSIVE APPROACH )
     * FUNCTION INSERT() WILL ADD THE NEW ELEMENT IN TREE CORRESPONDING TO THE
     * ROOT, AT EACH LEVEL IT WILL CHECK WHETHER THE ELEMENT TO BE ADDED IS
     * SMALLER (MOVE TO LEFT-SUBTREE) OR GREATER (MOVE TO RIGHT-SUBTREE); AND
     * ACCORDINGLY POSITION DECIDED.
     */
    public Node insert(Node node, Integer x) {
        if (node == null) {
            return node = new Node(x);
        }
        if (x < (Integer) node.element) {
            node.left = insert(node.left, x);
        } else {
            node.right = insert(node.right, x);
        }
        return node;
    }

    // IN-ORDER TRAVERSAL(LEFT->ROOT->RIGHT) OF TREE FOR GETTING ELEMENTS IN
    // ASCENDING ORDER//
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(((Integer) node.element).intValue() + ",");
            inOrder(node.right);
        }
    }

    // RIGHT->ROOT->LEFT TRAVERSAL OF TREE FOR GETTING ELEMENTS IN DESCENDING
    // ORDER//
    public void descOrder(Node node) {
        if (node != null) {
            descOrder(node.right);
            System.out.print(((Integer) node.element).intValue() + ",");
            descOrder(node.left);
        }
    }


    //MAIN METHOD//
    public static void main(String args[]) {

        // THE SOURCE OF ELEMENTS TO SORT//
        int[] arr = { 10, 9, 2, 3, 4, 5, 9, 12, 8, 18, 13, 16 };
        BinaryTreeSort bst = new BinaryTreeSort(new Integer(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            bst.insert(bst.root, new Integer(arr[i]));
        }
        System.out.print("Elements in Increasing Order: ");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.print("Elements in Decreasing Order: ");
        bst.descOrder(bst.root);
    }
}


