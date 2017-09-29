package com.algorithms.problems.salesforce;

/*

You have a string aaabbdcccccf, transform it the following way => a3b2d1c5f1
ie: aabbaa -> a2b2a2 not a4b2

 */


public class StringPatterCount {


    public static void stringPattern(String str) {

        char[] letters = str.toLowerCase().toCharArray();

        int counter =1;
        StringBuilder sb = new StringBuilder();

        System.out.println("Print length:"+letters.length);

        for(int i=0;i<letters.length;i++){
            if(letters.length == i+1){
                sb.append(letters[i]).append(counter);
                break;
            }
            if(letters[i]==letters[i+1]){
                counter=counter+1;
            }else{
                sb.append(letters[i]).append(counter);
                counter=1;
            }
        }
        System.out.println(sb);
    }

    public void stringpatterns(String str)
    {

        String newstr = "";
        char[] s = str.toCharArray();
        int count = 1,i=1;

        for (int j = 0; j < s.length; j++)
        {
            if ( i< s.length && s[i] == s[i - 1])
            {
                count++;
            }
            else
            {
                newstr = newstr + s[i - 1] + count;
                count = 1;
            }
            i++;
        }

        System.out.println("Output: " + newstr);
    }
}
