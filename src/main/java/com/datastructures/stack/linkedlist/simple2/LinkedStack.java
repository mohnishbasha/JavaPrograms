package com.datastructures.stack.linkedlist.simple2;

/*
http://cs-fundamentals.com/data-structures/stack-implementation-using-linked-list-in-java.php

good
simple

 */

public class LinkedStack <Item>
{
    private Node head; //the first node or top node
    private int size; // number of items

    //nested class to define node
    private class Node
    {
        Item item;
        Node next;
    }

    //Zero argument constructor
    public LinkedStack()
    {
        head = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    //Remove item from the beginning of the list.
    public Item pop()
    {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    //Add item to the beginning of the list.
    public void push(Item item)
    {
        Node temp = head;
        head = new Node();
        head.item = item;
        head.next = temp;
        size++;
    }

    public int size()
    {
        return size;
    }
}
