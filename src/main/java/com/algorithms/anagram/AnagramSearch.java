package com.algorithms.anagram;

import java.util.HashMap;

/*
Reference:
http://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/

IDeserve:
https://www.youtube.com/watch?v=h4MCwdfZZas

Anagram: Any permutation of a string

 */

public class AnagramSearch {

    public static boolean foundAnagram(HashMap<Integer,Integer> patternHash, HashMap<Integer,Integer>  textHash)
    {
        for(Integer key: patternHash.keySet())
        {
            if(textHash.containsKey(key))
            {
                if(textHash.get(key) != patternHash.get(key))
                    return false;
                // else returns true
            }
            else return false;
        }

        return true;
    }

    public static boolean anagramSubstringSearch(String pattern, String text)
    {
        HashMap<Integer,Integer> patternHash = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer>  textHash    = new HashMap<Integer,Integer>();

        for(int i=0; i<pattern.length();i++)
        {
            int patCh = (int)pattern.charAt(i);
            int txtCh = (int)text.charAt(i);
            if(!patternHash.containsKey(patCh))
            {
                patternHash.put(patCh, 1);
            }
            else
            {
                int temp = patternHash.get(patCh);
                patternHash.put(patCh, ++temp);
            }

            if(!textHash.containsKey(txtCh))
            {
                textHash.put(txtCh, 1);
            }
            else
            {
                int temp = textHash.get(txtCh);
                textHash.put(txtCh, ++temp);
            }

        }


        int start = 0;
        int end = pattern.length()-1;

        while(true)
        {
            if(foundAnagram(patternHash,  textHash))
            {
                return true;
            }
            start++;
            end++;
            if(end >= text.length())
                return false;

            // remove the char at beginning
            int txtCh = (int)text.charAt(start -1);
            if(textHash.containsKey(txtCh))
            {
                int count = textHash.get(txtCh);
                if(count==1)
                    textHash.remove(txtCh);
                else
                    textHash.put(txtCh, count-1);
            }

            // insert the char at the end
            txtCh = (int)text.charAt(end);
            if(!textHash.containsKey(txtCh))
            {
                textHash.put(txtCh, 1);
            }
            else
            {
                int temp = textHash.get(txtCh);
                textHash.put(txtCh, ++temp);
            }

        }
    }


    public static void main(String args[])
    {
        AnagramSearch object = new AnagramSearch();

        System.out.println(anagramSubstringSearch("xyiz", "afdgzyxksldfm"));
        System.out.println(anagramSubstringSearch("veer", "ideserve"));

    }

}