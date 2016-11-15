package com.algorithms.wordbreak;
/*

Reading also on:
http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/

http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem

Questions:

Given an input string and a dictionary of words, segment the input string into a space-separated
sequence of dictionary words if possible. For example, if the input string is "applepie" and
dictionary contains a standard set of English words, then we would return the string "apple pie" as output.

Example:
input string="applepie"

dict = ["apple", "pie"]


output = apple pie

Note that I’ve deliberately left some aspects of this problem vague or underspecified, giving the candidate an opportunity to flesh them out. Here are examples of questions a candidate might ask, and how I would answer them:

Q: What if the input string is already a word in the
   dictionary?
A: A single word is a special case of a space-separated
   sequence of words.

Q: Should I only consider segmentations into two words?
A: No, but start with that case if it's easier.

Q: What if the input string cannot be segmented into a
   sequence of words in the dictionary?
A: Then return null or something equivalent.

Q: What about stemming, spelling correction, etc.?
A: Just segment the exact input string into a sequence
   of exact words in the dictionary.

Q: What if there are multiple valid segmentations?
A: Just return any valid segmentation if there is one.

Q: I'm thinking of implementing the dictionary as a
   trie, suffix tree, Fibonacci heap, ...
A: You don't need to implement the dictionary. Just
   assume access to a reasonable implementation.

Q: What operations does the dictionary support?
A: Exact string lookup. That's all you need.

Q: How big is the dictionary?
A: Assume it's much bigger than the input string,
   but that it fits in memory.



 */


import java.util.Map;
import java.util.Set;

public class WordBreak {

    // FizzBizz Approach
    public String SegmentString(String input, Set<String> dict) {
        int len = input.length();

        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);

                if (dict.contains(suffix)) {
                    return prefix + " " + suffix;
                }
            }
        }
        return null;
    }

    // Using Recursive BackTracking

    /*

    Consider a pathological dictionary containing the words "a", "aa", "aaa", ..., i.e., words composed solely of
    the letter 'a'. What happens when the input string is a sequence of n-1 'a's followed by a 'b'?
    Hopefully the candidate can figure out that the recursive backtracking solution will explore every possible
    segmentation of this input string, which reduces the analysis to determine the number of possible segmentations.
    I leave it as an exercise to the reader (with this hint https://en.wikipedia.org/wiki/Power_set)
    to determine that this number is O(2^n).

     */

    public String SegmentStringR(String input, Set<String> dict) {

        if (dict.contains(input))
            return input;
        int len = input.length();

        for (int i = 1; i < len; i++) {

            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = SegmentString(suffix, dict);
                if (segSuffix != null) {
                    return prefix + " " + segSuffix;
                }
            }
        }
        return null;
    }

    // Using Memoization or Dynamic Programming

    /*

    An Efficient Solution

    If a candidate gets this far, I ask if it is possible to do better than O(2n). Most candidates realize this is a
    loaded question, and strong ones recognize the opportunity to apply dynamic programming or memoization. Here is a
    solution using memoization:

     */

    /*

    Again the candidate should be able to perform the worst-case analysis. The key insight is that SegmentString is
    only called on suffixes of the original input string, and that there are only O(n) suffixes. I leave as an exercise
    to the reader to determine that the worst-case running time of the memoized solution above is O(n2), assuming that
    the substring operation only requires constant time (a discussion which itself makes for an interesting tangent).

     */

    Map<String, String> memoized;

    public String SegmentStringD(String input, Set<String> dict) {

        if (dict.contains(input))
            return input;

        if (memoized.containsKey(input)) {
            return memoized.get(input);
        }

        int len = input.length();

        for (int i = 1; i < len; i++) {

            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {

                String suffix = input.substring(i, len);
                String segSuffix = SegmentString(suffix, dict);

                if (segSuffix != null) {
                    memoized.put(input, prefix + " " + segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
            memoized.put(input, null);
            return null;
        }
        return null;
    }
}



