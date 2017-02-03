package com.algorithms.strings;


import java.util.Stack;

public class StringReversalStack {

    public static String reverse(String str) throws NullPointerException{
        if(str==null){
            throw new NullPointerException("str cannot be null");
        }

        Stack stack = new Stack();
        stack.setSize(str.length());

        for(char c:str.toCharArray()){
            stack.push(c);
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}