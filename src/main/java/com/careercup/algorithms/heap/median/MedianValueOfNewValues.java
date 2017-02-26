package com.careercup.algorithms.heap.median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://www.careercup.com/question?id=8020256

Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new
values are generated.

O(m * n)


Tutorial MinHeap & MaxHeap:
https://www.youtube.com/watch?v=WKOqTfz1EW8
http://courses.cs.vt.edu/cs2604/spring02/Notes/C07.Heaps.pdf

Binary Tree Properties - Nice Tutorial Must Watch
Heap, MaxHeap, Build a heap
https://www.youtube.com/watch?v=2fA1FdxNqiE
https://www.youtube.com/watch?v=HI97KDV23Ig

1) Height of Binary Tree = 2 ^ (n + 1) + 1, where n is the number of nodes

2)
Max Nodes in Binary Tree  = 2 ^ (h + 1) - 1
Max Nodes in Ternary Tree = 3 ^ (h + 1) - 1
Max Nodes in N-Ary Tree   = n ^ (h + 1) - 1
Number of nodes atmost at any height = n / 2 ^ (h + 1)

- where h is height of the tree

3) Number of Leaf nodes in complete binary tree

Leaves = |n/2| + 1 to n


Max-Heapify: psuedo code

max-heapify(A, i)
{
    l = 2i;
    r = 2i + 1;

    if( l <= A.heapsize and A[l] > A[i])
        largest = l;
    else
        largest = i;

    if( r <= A.heapsize and A[r] > A[largest])
        largest = r;

    if(largest != i)
        swap(A[i], A[largest])
        max-heapify(A, largest)
}

Time Complexity O(log n)
Space Complexity - 0(log n) - Number of recursions


 */

public class MedianValueOfNewValues {
    public static void main(String[] args) throws IOException {
        Median median = new Median();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int value = Integer.parseInt(br.readLine());
            // median.addNewNumber(value);
           // System.out.println("Median: "+ median.getMedian());
        }
    }
}
class Median{

    /*

    PriorityQueue<Integer> minPriorityQueue = new PriorityQueue();
    PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue(new Comparator() {
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void addNewNumber(int randomNumber){

        //If both maxHeap and minHeap are equal.
        if(maxPriorityQueue.size() == minPriorityQueue.size()){
            //when size is not zero;
            if(maxPriorityQueue.peek()!= null && randomNumber >  minPriorityQueue.peek()) {
                maxPriorityQueue.offer(minPriorityQueue.poll());
                minPriorityQueue.offer(randomNumber);
            }
            else {
                maxPriorityQueue.offer(randomNumber);
            }
        } else {
            if(randomNumber < maxPriorityQueue.peek()) {
                minPriorityQueue.offer(maxPriorityQueue.poll());
                maxPriorityQueue.offer(randomNumber);

            } else {
                minPriorityQueue.offer(randomNumber);
            }
        }
    }

    public double getMedian() {
        if(maxPriorityQueue.size()==0) {
            return 0;
        }
        if(maxPriorityQueue.size() == minPriorityQueue.size()) {
            return (maxPriorityQueue.peek()+ minPriorityQueue.peek())/2d;
        } else {
            return maxPriorityQueue.peek();
        }
    }
    */
}