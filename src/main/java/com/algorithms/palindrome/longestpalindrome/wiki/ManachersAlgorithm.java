package com.algorithms.palindrome.longestpalindrome.wiki;


import java.util.Arrays;

/*
https://en.wikipedia.org/wiki/Longest_palindromic_substring

In computer science, the longest palindromic substring or longest symmetric factor problem is the problem of finding a
maximum-length contiguous substring of a given string that is also a palindrome. For example, the longest palindromic
substring of "bananas" is "anana". The longest palindromic substring is not guaranteed to be unique; for example, in
the string "abracadabra", there is no palindromic substring with length greater than three, but there are two
palindromic substrings with length three, namely, "aca" and "ada". In some applications it may be necessary to
return all maximal palindromic substrings (that is, all substrings that are themselves palindromes and cannot be
extended to larger palindromic substrings) rather than returning only one substring or returning the maximum length
of a palindromic substring.

Manacher (1975) found a linear time algorithm for listing all the palindromes that appear at the start of a given
string. However, as observed e.g., by Apostolico, Breslauer & Galil (1995), the same algorithm can also be used to
find all maximal palindromic substrings anywhere within the input string, again in linear time. Therefore, it
 provides a linear time solution to the longest palindromic substring problem. Alternative linear time solutions
 were provided by Jeuring (1994), and by Gusfield (1997), who described a solution based on suffix trees. Efficient
 parallel algorithms are also known for the problem.[1]

The longest palindromic substring problem should not be confused with the different problem of finding the longest
palindromic subsequence.

Implementation[edit]
Let:

s be a string of N characters

s2 be a derived string of s, comprising N * 2 + 1 elements, with each element corresponding to one of the following:
the N characters in s, the N-1 boundaries among characters, and the boundaries before and after the first and last
character respectively

A boundary in s2 is equal to any other boundary in s2 with respect to element matching in palindromic length
determination

p be an array of palindromic span for each element in s2, from center to either outermost element, where each boundary
 is counted towards the length of a palindrome (e.g. a palindrome that is three elements long has a palindromic span
 of 1)

c be the position of the center of the palindrome currently known to include a boundary closest to the right end of s2
(i.e., the length of the palindrome = p[c]*2+1)

r be the position of the right-most boundary of this palindrome (i.e., r = c + p[c])

i be the position of an element (i.e., a character or boundary) in s2 whose palindromic span is being determined, with
i always to the right of c

i2 be the mirrored position of i around c (e.g., {i, i2} = {6, 4}, {7, 3}, {8, 2},… when c = 5 (i.e., i2 = c * 2 - i)


 */
public class ManachersAlgorithm {

    public static String findLongestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";

        char[] s2 = addBoundaries(s.toCharArray());
        int[] p = new int[s2.length];
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i<s2.length; i++) {
            if (i>r) {
                p[i] = 0; m = i-1; n = i+1;
            } else {
                int i2 = c*2-i;
                if (p[i2]<(r-i-1)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below.
                } else {
                    p[i] = r-i;
                    n = r+1; m = i*2-n;
                }
            }
            while (m>=0 && n<s2.length && s2[m]==s2[n]) {
                p[i]++; m--; n++;
            }
            if ((i+p[i])>r) {
                c = i; r = i+p[i];
            }
        }
        int len = 0; c = 0;
        for (int i = 1; i<s2.length; i++) {
            if (len<p[i]) {
                len = p[i]; c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
        return String.valueOf(removeBoundaries(ss));
    }

    private static char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }
}
