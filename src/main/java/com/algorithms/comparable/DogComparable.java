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

// Approach 2 - Implement Comparable

import java.util.TreeSet;

class Dog1 implements Comparable<Dog>{
    int size;

    Dog1(int s) {
        size = s;
    }

    public int compareTo(Dog o) {
        return o.size - this.size;
    }
}

public class DogComparable {
    public static void main(String[] args) {
        TreeSet<Dog1> d = new TreeSet<Dog1>();
        d.add(new Dog1(1));
        d.add(new Dog1(2));
        d.add(new Dog1(1));
    }
}
