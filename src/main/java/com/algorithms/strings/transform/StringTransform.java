package com.algorithms.strings.transform;

/**
 *
 * You have a string aaabbdcccccf, transform it the following way => a3b2d1c5f1
 *  ie: aabbaa -> a2b2a2 not a4b2
 *
 */

public class StringTransform {

    public static void stringPattern(String str) {

        char[] a = str.toLowerCase().toCharArray();
        StringBuilder result = new StringBuilder();
        int counter = 1;

        System.out.println("Print length: "+a.length);

        for(int i=0; i < a.length; i++) {

            if( a.length == i + 1 ) {
                result.append(a[i]).append(counter);
                break;
            }

            if( a[i] == a[i+1]) {
                counter = counter+1;
            } else {
                result.append(a[i]).append(counter);
                counter = 1;
            }
        }
        System.out.println(result);
    }


    public static void main(String [] args) {
        String s = "aabbaa";
        StringTransform.stringPattern(s);

        s = "abbccc";
        StringTransform.stringPattern(s);

        s = "aabbbbbaaccccdeee";
        StringTransform.stringPattern(s);

        s = "aaaaabcdeeee";
        StringTransform.stringPattern(s);
    }

}
