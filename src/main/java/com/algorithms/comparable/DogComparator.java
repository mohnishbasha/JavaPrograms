package com.algorithms.comparable;

/*
3. When to use Which?

        In brief, a class that implements Comparable will be comparable, which means it instances can be compared with
        each other.

        A class that implements Comparator will be used in mainly two situations: 1) It can be passed to a sort method,
        such as Collections.sort() or Arrays.sort(), to allow precise control over the sort order and 2) It can also be
        used to control the order of certain data structures, such as sorted sets (e.g. TreeSet) or sorted maps (e.g.,
        TreeMap).

        For example, to create a TreeSet. We can either pass the constructor a comparator or make the object class
        comparable.



*/

import java.util.Comparator;
import java.util.TreeSet;

// Approach 1 - TreeSet(Comparator comparator)
class Dog {
    int size;

    Dog(int s) {
        size = s;
    }
}

class SizeComparator1 implements Comparator<Dog> {

    public int compare(Dog d1, Dog d2) {
        return d1.size - d2.size;
    }
}

public class DogComparator {
    public static void main(String[] args) {
        TreeSet<Dog> d = new TreeSet<Dog>(new SizeComparator1()); // pass comparator
        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(1));
    }
}
