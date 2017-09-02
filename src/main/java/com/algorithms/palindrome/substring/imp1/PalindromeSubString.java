package com.algorithms.palindrome.substring.imp1;


/*
http://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
Given a string, the task is to count all palindrome substring in a given string. Length of palindrome substring is
greater then or equal to 2.

Examples:

Input : str = "abaab"
Output: 3
Explanation :
All palindrome substring are :
 "aba" , "aa" , "baab"

Input : str = "abbaeae"
Output: 4
Explanation :
All palindrome substring are :
"bb" , "abba" ,"aea","eae"


The above problem can be recursively defined.

Initial Values : i = 0, j = n-1;
Given string 'str'

CountPS(i, j)

   // If length of string is 2 then we
   // check both character are same or not
   If (j == i+1)
      return str[i] == str[j]

   Else If str[i..j] is PALINDROME
      // increment count by 1 and check for
      // rest palindromic substring (i, j-1), (i+1, j)
      // remove common palindrome substring (i+1, j-1)
      return  countPS(i+1, j) + countPS(i, j-1) + 1 -
                                   countPS(i+1, j-1);

    Else // if NOT PALINDROME
       // We check for rest palindromic substrings (i, j-1)
       // and (i+1, j)
       // remove common palindrome substring (i+1 , j-1)
       return  countPS(i+1, j) + countPS(i, j-1) -
                             countPS(i+1 , j-1);

 */
public class PalindromeSubString {
    // Dynamic Programming based approach

    // Return a total number of palindrome substring of
    // length greater then equal to 2
    static int CountPS(char str[], int n)
    {
        // creat empty 2-D matrix that counts all palindrome
        // substring. dp[i][j] stores counts of palindromic
        // substrings in st[i..j]
        int dp[][] = new int[n][n];

        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];

        // palindrome of single lenght
        for (int i= 0; i< n; i++)
            P[i][i] = true;

        // palindrome of length 2
        for (int i=0; i<n-1; i++)
        {
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }

        // Palindromes of length more then 2. This loop is similar
        // to Matrix Chain Multiplication. We start with a gap of
        // length 2 and fill DP table in a way that gap between
        // starting and ending indexes increases one by one by
        // outer loop.
        for (int gap=2 ; gap<n; gap++)
        {
            // Pick starting point for current gap
            for (int i=0; i<n-gap; i++)
            {
                // Set ending point
                int j = gap + i;

                // If current string is palindrome
                if (str[i] == str[j] && P[i+1][j-1] )
                    P[i][j] = true;

                // Add current palindrome substring ( + 1)
                // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palinrome substrings (- dp[i+1][j-1])
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }

        // return total palindromic substrings
        return dp[0][n-1];
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "abaab";
        System.out.println(CountPS(str.toCharArray(), str.length()));
    }
}


/*

Output:
        3
        Time complexity O(n2)
        Auxiliary Space O(n2)

*/
