package com.algorithms.palindrome.substring.impl2;

/*
http://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/

Find all distinct palindromic sub-strings of a given string
Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.

Examples:

Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b


Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k

*/

/*

Step 1: Finding all palindromes using modified Manacher’s algorithm:
Considering each character as a pivot, expand on both sides to find the length of both even and odd length palindromes
centered at the pivot character under consideration and store the length in the 2 arrays (odd & even).
Time complexity for this step is O(n^2)

Step 2: Inserting all the found palindromes in a HashMap:
Insert all the palindromes found from the previous step into a HashMap. Also insert all the individual characters from
the string into the HashMap (to generate distinct single letter palindromic sub-strings).


Time complexity of this step is O(n^3) assuming that the hash insert search takes O(1) time. Note that there can be at
 most O(n^2) palindrome sub-strings of a string. In below C++ code ordered hashmap is used where the time complexity of
  insert and search is O(Logn). In C++, ordered hashmap is implemented using Red Black Tree.


Step 3: Printing the distinct palindromes and number of such distinct palindromes:
The last step is to print all values stored in the HashMap (only distinct elements will be hashed due to the property of
 HashMap). The size of the map gives the number of distinct palindromic continuous sub-strings.


 */

// Java program to find all distinct palindrome
// sub-strings of a given string
import java.util.Map;
import java.util.TreeMap;

public class DistinctPalindromeSubstrings
{
    // Function to print all distinct palindrome
    // sub-strings of s
    public static void palindromeSubStrs(String s)
    {
        //map<string, int> m;
        TreeMap<String , Integer> m = new TreeMap<>();
        int n = s.length();

        // table for storing results (2 rows for odd-
        // and even-length palindromes
        int[][] R = new int[2][n+1];

        // Find all sub-string palindromes from the
        // given input string insert 'guards' to
        // iterate easily over s
        s = "@" + s + "#";

        for (int j = 0; j <= 1; j++)
        {
            int rp = 0;   // length of 'palindrome radius'
            R[j][0] = 0;

            int i = 1;
            while (i <= n)
            {
                //  Attempt to expand palindrome centered
                // at i
                while (s.charAt(i - rp - 1) == s.charAt(i +
                        j + rp))
                    rp++;  // Incrementing the length of
                // palindromic radius as and
                // when we find vaid palindrome

                // Assigning the found palindromic length
                // to odd/even length array
                R[j][i] = rp;
                int k = 1;
                while ((R[j][i - k] != rp - k) && (k < rp))
                {
                    R[j][i + k] = Math.min(R[j][i - k],
                            rp - k);
                    k++;
                }
                rp = Math.max(rp - k,0);
                i += k;
            }
        }

        // remove 'guards'
        s = s.substring(1, s.length()-1);

        // Put all obtained palindromes in a hash map to
        // find only distinct palindromess
        m.put(s.substring(0,1), 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j <= 1; j++)
                for (int rp = R[j][i]; rp > 0; rp--)
                    m.put(s.substring(i - rp - 1,  i - rp - 1
                            + 2 * rp + j), 1);
            m.put(s.substring(i, i + 1), 1);
        }

        // printing all distinct palindromes from
        // hash map
        System.out.println("Below are " + (m.size())
                + " palindrome sub-strings");

        for (Map.Entry<String, Integer> ii:m.entrySet())
            System.out.println(ii.getKey());
    }

    // Driver program
    public static void main(String args[])
    {
        palindromeSubStrs("abaaa");
    }
}