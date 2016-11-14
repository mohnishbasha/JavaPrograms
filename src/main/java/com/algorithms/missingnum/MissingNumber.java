package com.algorithms.missingnum;

/*

How to find a missing element between two linked lists in O(n)?
 */

/*

I have two Singly Linked Lists of Integer. One of them is a subset of another (the order of numbers is different).
What is the best way (regarding performance) to find a number which the first list does contain and the second one
does not?

My thought is first to sort them (using merge sort) and then just compare element by element. So, it takes
O(nlogn+mlogm+n), but a better O(n) soltuion should exist.

Another Question:
A bag has balls numbered from 1 to 100
However, one ball is missing - how to find the missing ball.
 */

/*
Solution:

This is O(n) solution both in Time and Space.

Logic

Lets say the original Linked List has size N we'll call it LL1 and second Linked List as LL2.

=> Prepare a Hasmap of size N, key would be the numbers in the LL1 and value would be frequency in LL2

 HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
=> Start traversing LL1 and set the frequency to 0 for all the Numbers
By the time all values in LL1 is iterated, you have all the Numbers present in HashMap with frequency = 0

 map.put(key, 0);
=> Now start looping through the LL2, pick the numbers using them as key and increment the value by 1.
By the time all values in LL2 is iterated, you have all the common numbers present in both LL1 and LL1 inside
HashMap havingfrequency > 0

  map.put(key, map.get(key) + 1);
=> Now start traversing the hasmap, searching for value = 0, when found, print the key as this number present only in
LL1 and not in LL2

for (map.Entry<Integer,Integer> entry : map.entrySet())
{
    if(entry.getValue() == 0)
        System.out.println(entry.getKey());//This is a loner
}
2 Iterations and O(n) memory with O(n) time.


 */