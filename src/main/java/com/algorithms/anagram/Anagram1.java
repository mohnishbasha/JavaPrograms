package com.algorithms.anagram;

/*
Anagram:
http://www.java.achchuthan.org/2013/06/find-all-anagrams-of-word-in-java.html

Find all anagrams of a word in Java
dogs sgod gsod ogsd
dosg sgdo gsdo ogds
dsgo sdgo gdso osdg
dsog sdog gdos osgd
dgso sodg gods odgs
dgos sogd gosd odsg

 */

/*

So, when we came up with the permutations of “dogs” above, how did we do it? What were we implicitly thinking? Well,
it looks like what we did in each column was choose one letter to start with, and then we found all the possible
combinations for the string beginning with that letter. And once we picked a letter in the 2nd position, we then found
all the possible combinations that begin with that 2 letter sequence before we changed any of the letters in the first
2 positions. So, basically what we did was choose a letter and then peformed the permutation process starting at the
next position to the right before we come back and change the character on the left.

Finding the permutations with recursion
 Our description of the process that we followed sounds a lot like something that could be solved with recursion. How
 can we change our description so that it’s easier to write out in a recursive method? Let’s phrase it like this: In
 order to find all possible combinations for a given string, then start at a position x, then find and place all
 possible letters in position x. Every time we put a new letter in position x, we should then find all the possible
 combinations at position x+1 – this would be the recursive call that we make. How do we know when to print out a
 string? Well, when we are at a position x that is greater than the number of letters in the input string, then we
 know that we have found one valid combination/permutation of the string and then we can print it out and return to
 changing letters at positions less than x. This would be our base case – remember that we always must have a
 recursive case and a base case when using recursion.

 Which letters can we use in a given position?
 Another big part of this problem is figuring out which letters we can put in a given position. Using our sample string
  “dogs”, lets say that we are going through all the permutations where the first 2 letters are “gs”. Then, it should
  be clear that the letters in the 3rd or 4th position can only be either “d” or “o”, because “g” and “s” were already
  used. As part of our algorithm, we have to know which letters can be used in a given position – because we can’t reuse
   the letters that were used in the earlier positions. And in order to do this we can simply have an array of Boolean
   values that correspond to the positions of the letters in the input string – so if a certain character from the input
    string has already been used, then it’s position in the array would be set to “true”.


 */

public class Anagram1 {

    public static char[] charArray;

    public Anagram1(String word) {
        charArray = word.toCharArray(); // L,O,V,E
        doAnagram(charArray.length);    // 4
    }

    public void changeOrder(int newsize) {
        int j;
        int pointAt = charArray.length - newsize; // 1
        char temp = charArray[pointAt];

        for (j = pointAt + 1; j < charArray.length; j++) {
            charArray[j - 1] = charArray[j];
        }

        charArray[j - 1] = temp;

    }

    public void doAnagram(int newsize) {
        if (newsize == 1) {
            return;
        }
        for (int i = 0; i < newsize; i++) {
            doAnagram(newsize - 1);
            if (newsize == 2) {
                display();
            }
            changeOrder(newsize);
        }
    }

    public void display() {
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Anagram1 test1 = new Anagram1("Love");
        Anagram1 test2 = new Anagram1("Dogs");
        Anagram1 test3 = new Anagram1("Zental");



    }
}
