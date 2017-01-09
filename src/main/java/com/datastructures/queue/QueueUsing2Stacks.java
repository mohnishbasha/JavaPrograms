package com.datastructures.queue;

/*
http://www.programcreek.com/2014/07/leetcode-implement-queue-using-stacks-java/
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

 */

import java.util.Stack;

public class QueueUsing2Stacks {

    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        if(value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                temp.push(value.pop());
            }

            value.push(x);

            while(!temp.isEmpty()){
                value.push(temp.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        value.pop();
    }

    // Get the front element.
    public int peek() {
        return value.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}
