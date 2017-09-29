package com.companies.ge;

import java.util.LinkedList;

public class StringLeftRightShift {

    LinkedList<Character> bc = new  LinkedList<Character>();

    StringLeftRightShift(String  str)
    {
        char[] chars= str.toCharArray();
        for(char c : chars){
            bc.add(c);
        }
    }


    void leftShift(){
        char first = bc.remove(0);
        bc.add(first);

    }

    void rightShift(){
        char last = bc.remove(bc.size()-1);
        bc.addFirst(last);
    }

    public static void main(String arg[]){
        StringLeftRightShift cl = new StringLeftRightShift("hai");
        cl.leftShift();
        cl.leftShift();
        cl.rightShift();

        System.out.println(cl.bc);
    }

}



