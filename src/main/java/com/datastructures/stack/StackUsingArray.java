package com.datastructures.stack;

/*

http://www.programcreek.com/2015/03/implement-a-stack-using-an-array/

Implement a Stack Using an Array in Java

This post shows how to implement a stack by using an array.

The requirements of the stack are: 1) the stack has a constructor which accept a number to initialize its size,
2) the stack can hold any type of elements, 3) the stack has a push() and a pop() method.


I remember there is a similar example in the "Effective Java" book written by Joshua Bloch, but not sure how the
example is used. So I just write one and then read the book, and see if I miss anything.

 */
public class StackUsingArray<E> {
    private E[] arr = null;
    private int CAP;
    private int top = -1;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StackUsingArray(int cap) {
        this.CAP = cap;
        this.arr = (E[]) new Object[cap];
    }

    public E pop() {
        if(this.size == 0){
            return null;
        }

        this.size--;
        E result = this.arr[top];
        this.arr[top] = null;//prevent memory leaking
        this.top--;

        return result;
    }

    public boolean push(E e) {
        if (!isFull())
            return false;

        this.size++;
        this.arr[++top] = e;
        return false;
    }

    public boolean isFull() {
        if (this.size == this.CAP)
            return false;
        return true;
    }

    public String toString() {
        if(this.size==0){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.size; i++){
            sb.append(this.arr[i] + ", ");
        }

        sb.setLength(sb.length()-2);
        return sb.toString();
    }

    public static void main(String[] args) {

        StackUsingArray<String> stack = new StackUsingArray<String>(11);
        stack.push("hello");
        stack.push("world");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
