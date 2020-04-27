package com.algorithms.strings.frequency;

/*

Frequency of a substring in a string
Given a input string and a substring. Find the frequency of occurrences of
substring in given string.

Examples:

Input : man (pattern)
        dhimanman (string)
Output : 2

Input : nn (pattern)
        Banana (String)
Output : 0

Input : man (pattern)
        dhimanman (string)
Output : 2

Input : aa (pattern)
        aaaaa (String)
Output : 4

 */
public class KMP_CountFrequency {

    /*
    A simple solution is to match characters one by one.
    And whenever we see a complete match, we increment count.
    Below is simple solution based on Naive pattern searching.

    Time Complexity : O(M * N)

     */
    static int countFreq(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
    }

    /*
    https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
    KMP (Knuth Morris Pratt) Pattern Searching



     */

    int KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);

        int i = 0;  // index for txt[]
        int res = 0;
        int next_i = 0;

        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                // When we find pattern first time,
                // we iterate again to check if there
                // exists more pattern
                j = lps[j-1];
                res++;

                // We start i to check for more than once
                // appearance of pattern, we will reset i
                // to previous start+1
                if (lps[j]!=0)
                    i = ++next_i;
                j = 0;
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        return res;
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];

                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    /* Driver program to test above function */
    static public void main(String[] args) {
        String txt = "dhimanman";
        String pat = "man";
        System.out.println(countFreq(pat, txt));


        // KMP
        String txt1 = "geeksforgeeks";
        String pat1 = "eeks";
        int ans = new KMP_CountFrequency().KMPSearch(pat1,txt1);
        System.out.println(ans);
    }

}
