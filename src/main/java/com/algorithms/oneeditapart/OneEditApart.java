package com.algorithms.oneeditapart;


/*

The problem is very simple: write a function which returns true if two strings are exactly one edit apart.
It serves as a good warmup because it provides the candidate a way to demonstrate their knowledge of their language of
choice and also gives insight into how cleanly they can think and express themselves when reasoning about correctness.

boolean oneEditApart(String s1, String s2);
This method should only return true if the strings are exactly one edit apart, where an edit is a single replace,
insert, or delete in either string.

oneEditApart("cut", "cute") => true;  // single insert
oneEditApart("boot", "bot") => true;  // single delete
oneEditApart("cat", "cut") => true;  // single replace
oneEditApart("cat", "dog") => false;  // multiple replace
oneEditApart("foo", "foobar") => false;  // multiple insert

*/


public class OneEditApart {


    /*
        The simplest algorithm is to walk the two strings together and count the number of differences.
        A basic simplification is to realize that insertions in the shorter string is the same as a delete in the longer
         string. By knowing which is the longer string, one case is removed, thus simplifying the algorithm
         significantly.

        A C-style solution in java might look like:
    */

    boolean oneEditApart(final String s1, final String s2) {
        final String longer;
        final String shorter;

        if (s1.length() > s2.length()) {
            longer = s1;
            shorter = s2;
        } else {
            longer = s2;
            shorter = s1;
        }

        if (longer.length() - shorter.length() > 1) {
            return false;
        }

        boolean has_difference = false;
        for (int i = 0, j = 0; i < shorter.length(); ++i, ++j) {

            if (shorter.charAt(i) != longer.charAt(j)) {

                if (has_difference) {
                    return false;
                }

                has_difference = true;
                if (longer.length() > shorter.length()) {
                    // skip a character in the shorter string
                    --i;
                }
            }
        }

        // There is a difference in the middle of the string or there is a
        // trailing character at the end of the longer string.
        return has_difference || longer.length() != shorter.length();
    }


}
