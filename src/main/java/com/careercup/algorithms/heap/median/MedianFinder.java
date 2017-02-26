package com.careercup.algorithms.heap.median;

/*
http://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/

LeetCode – Find Median from Data Stream (Java)

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
So the median is the mean of the two middle value.

http://www.zrzahid.com/median-of-a-stream-of-integer/

 */

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public MedianFinder(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }
}