package com.algorithms.array.commonprefix;

/*
Read:
http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/

Must Read:
http://www.geeksforgeeks.org/longest-common-prefix-set-1-word-by-word-matching/

http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/




Problem

Write a function to find the longest common prefix string amongst an array of strings.

Analysis
`
To solve this problem, we need to find the two loop conditions. One is the length of the shortest string.
The other is iteration over every element of the string array.


 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }

        if(strs.length==1)
            return strs[0];

        int minLen = strs.length+1;

        for(String str: strs){
            if(minLen > str.length()){
                minLen = str.length();
            }
        }

        for(int i=0; i < minLen; i++) {
            for(int j=0; j < strs.length-1; j++) {

                String s1 = strs[j];
                String s2 = strs[j+1];
                if(s1.charAt(i)!=s2.charAt(i)) {
                    return s1.substring(0, i); // i dont understanding this step -- use C++ code below
                }
            }
        }

        return strs[0].substring(0, minLen);
    }

    /*
    Simple Algorithm Will Go Like This:

    Algorithm: Longest Common Prefix ( LCP)
    1.Take a String From Array Whose length is Minimum else you might get exception if tries to access array element
    outside range.why this will work because if there exist a common prefix then it will be the desired answer .

    Example like in case of "shash" ,"shank","shashank" LCP will be "sha"
            for this string "ab", "abc", "def" ,"defgh", "sha" LCP will be NULL

    2.Keep Comparing reamining string character by character with 1st selected string  if mismatch occurs at any position i then append 1st string to output string.


      Time Complexity O(N*M-1)=O( Where N is Length of 1st Smallest String
            and M is Number of remaining string in string array so it will run
            upto length of array-1
            Space Complexity O(1)

    */

    public String findLongPrefix (String [] str)
    {
        StringBuilder sb = new StringBuilder();

        char [] firstStr = str[0].toCharArray();

        for(int i = 0; i < str[0].length(); i++ ) {

            boolean found = true;

            for(String st: str) {
                if(st.charAt(i) != firstStr[i]) {
                    found = false;
                    break;
                }
            }

            if(found) {
                sb.append(firstStr[i]);
            } else
                break;

        }

        return sb.toString();
    }


    public static void main(String[] args) {


        String[] arr = {"ab", "abc", "def" ,"defgh"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println("LCP 1: " + lcp.longestCommonPrefix(arr) );
        System.out.println("LCP 2: " + lcp.findLongPrefix(arr) );


    }




}


/*


Given a set of strings, find the longest common prefix.

Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
We strongly recommend you to minimize your browser and try this yourself first.

We start with an example. Suppose there are two strings- “geeksforgeeks” and “geeks”. What is the longest common prefix in both of them? It is “geeks”.

Now let us introduce another word “geek”. So now what is the longest common prefix in these three words ? It is “geek”

We can see that the longest common prefix holds the associative property, i.e-

LCP(string1, string2, string3)
         = LCP (LCP (string1, string2), string3)

Like here

LCP (“geeksforgeeks”, “geeks”, “geek”)
     =  LCP (LCP (“geeksforgeeks”, “geeks”), “geek”)
     =  LCP (“geeks”, “geek”) = “geek”
So we can make use of the above associative property to find the LCP of the given strings. We one by one calculate the LCP of each of the given string with the LCP so far. The final result will be our longest common prefix of all the strings.

Note that it is possible that the given strings have no common prefix. This happens when the first character of all the strings are not same.

We show the algorithm with the input strings- “geeksforgeeks”, “geeks”, “geek”, “geezer” by the below figure.




//  A C++ Program to find the longest common prefix

        #include<bits/stdc++.h>
        using namespace std;

        // A Utility Function to find the common prefix between
        // strings- str1 and str2

        string commonPrefixUtil(string str1, string str2)
        {
            string result;
            int n1 = str1.length(), n2 = str2.length();

            // Compare str1 and str2
            for (int i=0, j=0; i<=n1-1&&j<=n2-1; i++,j++)
            {
                if (str1[i] != str2[j])
                    break;
                result.push_back(str1[i]);
            }

            return (result);
        }

        // A Function that returns the longest common prefix
        // from the array of strings
        string commonPrefix (string arr[], int n)
        {
            string prefix =  arr[0];

            for (int i=1; i<=n-1; i++)
                prefix = commonPrefixUtil(prefix, arr[i]);

            return (prefix);
        }

        // Driver program to test above function
        int main()
        {
            string arr[] = {"geeksforgeeks", "geeks",
                            "geek", "geezer"};
            int n = sizeof(arr) / sizeof(arr[0]);

            string ans = commonPrefix(arr, n);

            if (ans.length())
                printf ("The longest common prefix is - %s",
                         ans.c_str());
            else
                printf("There is no common prefix");

            return (0);
        }



 */