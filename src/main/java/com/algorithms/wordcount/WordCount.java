package org.algorithms.wordcount;

import java.io.*;
import java.util.*;

public class WordCount {


    public static int wordcount(String word) {

        if (word == null || word.isEmpty()) {
            return 0;
        }

        int count = 1;
        char ch[] = new char[word.length()];

        for (int i = 1; i < word.length(); i++) {
            ch[i] = word.charAt(i);
            if ((ch[i] != ' ')&& (ch[i-1] == ' '))
            {
                count++;
            }
        }

        return count;
    }

    public static int wordcount1(String word) {

        int counter=1;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] a = s.toCharArray();

        for(int i=0;i<a.length;i++){
            if (a[i] == ' '){
                counter++;
            }

        }
        System.out.println("number of words:"+counter);
        return counter;
    }

    public static void main(String[] args) {
        String str = "  an b  c   d";
        //String str = " c        d";
        System.out.println("String: " + str);
        System.out.println("Word Count: " + countWords(str));
    }

    public static int countWords(String string) {
        if (null == string) { return -1; }

        int count = 0;
        int len = string.length();

        char lastChar = string.charAt(0);
        for (int i=0; i<len; i++) {
            if (string.charAt(i) == ' ' && lastChar != ' ') {
                ++count;
                lastChar = ' ';
            }
            lastChar = string.charAt(i);
        }
        if (lastChar != ' ') {
            ++count;
        }
        return count;
    }
}