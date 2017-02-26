package com.datastructures.queue.array.impl1;

import java.util.Arrays;

class Queue<T> {

    private int front;
    private int rear;
    int size;
    T[] queue;

    public Queue(int inSize) {
        size = inSize;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isempty() {
        return (front == -1 && rear == -1);
    }

    public void enQueue(T value) {

        if ((rear+1)%size==front) {
            throw new IllegalStateException("Queue is full");

        } else if (isempty()) {
            front++;
            rear++;
            queue[rear] = value;

        } else {
            rear=(rear+1)%size;
            queue[rear] = value;

        }
    }

    public T deQueue() {
        T value = null;
        if (isempty()) {
            throw new IllegalStateException("queue is empty, cant dequeue");
        } else if (front == rear) {
            value = queue[front];
            front = -1;
            rear = -1;

        } else {
            value = queue[front];
            front=(front+1)%size;

        }
        return value;

    }

    @Override
    public String toString() {
        return "Queue [front=" + front + ", rear=" + rear + ", size=" + size
                + ", queue=" + Arrays.toString(queue) + "]";
    }

}


public class QueueImpl {

    public static <T> void main(String[] args) {
        Queue newQueue = new Queue(5);
        newQueue.enQueue(10);
        newQueue.enQueue(20);
        newQueue.enQueue(30);
        newQueue.enQueue(40);
        newQueue.enQueue(50);
        System.out.println((T) newQueue.toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.toString());
        newQueue.enQueue(60);
        newQueue.enQueue(70);
        System.out.println((T) newQueue.toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.deQueue().toString());
        System.out.println((T) newQueue.toString());


    }

}