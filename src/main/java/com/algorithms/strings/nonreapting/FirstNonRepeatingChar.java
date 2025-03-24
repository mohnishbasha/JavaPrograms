package com.algorithms.strings.nonreapting;

/*

Find a 1st non-repeated char in the string for e.g. if string is "Salesforce is the best company
to work for” returns 'l'

 */

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {


    public static Character firstNonRepeating(String s)
    {
        if(s == null || s.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        if(s.length() == 1) {
            return s.charAt(0);
        }

        //strip white space
        s = s.replace(" ", "");
        s = s.toLowerCase();

        char[] split = s.toCharArray();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap();

        for(char c : split)
        {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for(Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue()==1)
                return entry.getKey();
        }

        return null;

    }


    public static void main(String[] args) {

        String s = "Salesforce is the best company\n" +
                "to work for";
        System.out.print(FirstNonRepeatingCharClaude.firstNonRepeating(s));

    }


}
