package com.careercup.ch01.arrays;

/**
 * Page 95
 *
 * Implement an algorigthm to determine if a string ahs all unique characters.
 * What if you cannot use additional datastructures
 */
public class UniqueChars {


    /*
    Assume character is ASCII, else we need to increase the storage size.
    Great to point this out to the interviewer.
    O(n) - Time complexity, Space Complexity

     */
    public static boolean isUniqueChars2(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /*
    We can use the space complexity a little bit by using a bit vector.
    We will assume in the lower code that the string is only lower case 'a' to 'z'.

     */
    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for ( int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }




}
