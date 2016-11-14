package com.algorithms.problems.salesforce;

import java.util.Scanner;

public class SubstringCount {

    public static void main(String[] args){

        System.out.println("\nEnter String and find:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String find = sc.nextLine();

        substring(str,find);

    }

    private static void substring(String str, String find) {

        int s=0,count=0;

        for(int i=0;i<str.length();i++) {

            if(s!=find.length() && str.charAt(i)==find.charAt(s))
                s++;
            else if(s > 0) {
                s=0;
            }

            if(s==find.length()) {
                count++;
                s=0;
            }
        }
        System.out.println("\nCount is : "+count);

    }
}