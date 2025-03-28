package com.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

/*
http://www.programcreek.com/2014/06/leetcode-implement-stack-using-queues-java/

LeetCode – Implement Stack using Queues (Java)

Implement the following operations of a stack using queues.
push(x) -- Push data x onto stack.
pop() -- Removes the data on top of the stack.
top() -- Get the top data.
empty() -- Return whether the stack is empty.

Note: only standard queue operations are allowed, i.e., poll(), offer(), peek(), size() and isEmpty() in Java.


 */

public class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push data x onto stack.
    public void push(int x) {

        if(empty()){
            queue1.offer(x);
        } else {

            if(queue1.size()>0) {
                queue2.offer(x);
                int size = queue1.size();
                while(size>0){
                    queue2.offer(queue1.poll());
                    size--;
                }
            } else if (queue2.size()>0) {
                queue1.offer(x);
                int size = queue2.size();
                while(size>0){
                    queue1.offer(queue2.poll());
                    size--;
                }
            }
        }
    }

    // Removes the data on top of the stack.
    public void pop() {
        if(queue1.size()>0){
            queue1.poll();
        }else if(queue2.size()>0){
            queue2.poll();
        }
    }

    // Get the top data.
    public int top() {
        if(queue1.size()>0){
            return queue1.peek();
        }else if(queue2.size()>0){
            return queue2.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {

        return queue1.isEmpty() & queue2.isEmpty();
    }
}