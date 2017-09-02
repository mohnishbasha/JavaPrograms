package com.algorithms.palindrome;


//Part 1: A palindrome is a sequence of characters that is the same backwards or forward.
//Write a function that tests a string passed in for whether it is a palindrome or not.
//Test strings: aa, aba, zboba, zamanaplanacanalpanamaxbobx

//Part 2: Write a function that finds and returns all the palindrome(s) in a string.
//'momyyydad' -> ['mom', 'yy', 'yyy', 'yy', 'dad']

// TODO

import java.io.*;
import java.util.*;

class FindSubstringPalindromes
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("aa: " + isPalindrome("aa"));
        System.out.println("aba: " + isPalindrome("aba"));
        System.out.println("zboba: " + isPalindrome("zboba"));
        System.out.println("zamanaplanacanalpanamaxbobx: " + isPalindrome("zamanaplanacanalpanamaxbobx"));
    }

    public static boolean isPalindrome(String str) {

        StringBuilder reverse = new StringBuilder();
        int len = str.length();

        for(int i = len - 1; i >= 0; i--) {
            reverse = reverse.append( str.charAt(i));
        }

        if(str.equals(reverse.toString())) {
            return true;
        } else
        {
            return false;
        }

    } // O(n

    //'momyyydad' -> ['mom', 'yy', 'yyy', 'yy', 'dad']
    // m - omyyydad
    // mo - myyyydad
    // - o - myydad - Queue - o
    // - om - yyydad
    // -- m - yyydad - Queue - m, o

    // mom - yyydad -- mom is palindrome
    // momy - yydad

    /*
    public static String[] findPalindromes(String str) {


        List<String> palindromeList = new ArrayList<String>();
        Stack st = new Stack()

        for(int i = 0; i < str.length(); i++) {

            char a = str.charAt(i);
            st.push(a);



            for(int j = i + 1; j <= str.length(); j++ ) {

                StringBuilder sb = new StringBuilder();
                char b = str.charAt(j);

                while(!st.empty()) {
                    char k  = (char)st.pop();

                    sb.append(k);

                }

                sb.append(b);

                if(isPalindrome(sb.toString())) {
                    palindromeList.add(sb.toString());
                }


                st.push(b);
            } // m o m y y y d a d


            // st.clear();

        }



    }
    */
}