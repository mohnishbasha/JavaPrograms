package com.datastructures.stack;

/*
http://www.programcreek.com/2014/02/leetcode-min-stack-java/

LeetCode – Min Stack (Java)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Java Solution

To make constant time of getMin(), we need to keep track of the minimum element for each element in the stack.
Define an element class that holds element value, min value, and pointer to elements below it.


 */
class Node {

    public int value;
    public int min;
    public Node next;

    public Node(int value, int min){
        this.value = value;
        this.min = min;
    }
}

public class MinStack {
    public Node top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top == null){
            top = new Node(x, x);
        }else{
            Node e = new Node(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }

    }

    public void pop() {
        if(top == null)
            return;
        Node temp = top.next;
        top.next = null;
        top = temp;

    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
}