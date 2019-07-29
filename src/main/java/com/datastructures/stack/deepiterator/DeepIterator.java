package com.datastructures.stack.deepiterator;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

/*


You are given an input iterable of

Iterable<Object> {
    Iterator<Object> iterator();
}

Iterator<Object> {
    boolean hasNext();
    Object next();
}

Each object being iterated can be either an Integer or another Iterable. We want to write a deep iterator that iterates
over all Integers at all levels in depth-first fashion. For example, given an input of

List(1, List(2, 3), List( List(), 4), 5)
The iterator should be able to iterate over 1, 2, 3, 4, 5 and in this order.


Solution:
There are some corner cases that need to be handled: empty list, nested empty list, nested list as the first item, etc.


 */


class Solution {
    public static void main(String[] args) {

        List toDeepIter = Arrays.asList(1,
                Arrays.asList( 2, 3),
                Arrays.asList(
                        new ArrayList(),
                        Arrays.asList( 4, 5)
                )
        );

        DeepIterator itr = new DeepIterator(toDeepIter);

        while (itr.hasNext()){
            System.out.println(itr.next()); // 1 , 2 , 3  , 4 , 5
        }
    }
}

public class DeepIterator implements Iterator<Integer> {
    private Stack<Iterator> iteratorStack = new Stack<Iterator>();
    private Integer top = null;

    public DeepIterator(Iterable iterable){
        this.iteratorStack.push(iterable.iterator());
    }

    @Override
    public boolean hasNext() {
        if(this.top != null) return true;

        while(!this.iteratorStack.isEmpty()) {
            Iterator tmpIterator = this.iteratorStack.peek();

            if(tmpIterator.hasNext()){
                Object tmp = tmpIterator.next();
                if(tmp instanceof Integer){
                    this.top = (Integer) tmp;
                    return true;
                } else if(tmp instanceof Iterable){
                    this.iteratorStack.push(((Iterable) tmp).iterator());
                } else {
                    throw new RuntimeException("Unsupported data type. ");
                }
            } else {
                this.iteratorStack.pop();
            }
        }
        return false;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if(hasNext()){
            Integer tmp = this.top;
            this.top = null;
            return tmp;
        }

        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This is not supported right now.");
    }
}