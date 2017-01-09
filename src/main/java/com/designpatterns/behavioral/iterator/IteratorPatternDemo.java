package com.designpatterns.behavioral.iterator;

/*
Use the NameRepository to get iterator and print names.

IteratorPatternDemo.java
 */

public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}