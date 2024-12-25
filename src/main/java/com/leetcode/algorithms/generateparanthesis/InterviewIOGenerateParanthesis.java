package com.leetcode.algorithms.generateparanthesis;

import java.util.*;

public class InterviewIOGenerateParanthesis {

    public static List<String> generateParentheses(int n) {

        List<String> validAnswers = new ArrayList<>();
        char[] currentString = new char[2 * n];

        recurse(n, n, 0, currentString, validAnswers);
        return validAnswers;
    }

    private static void recurse(int forwardParensNeeded, int backwardsParensNeeded, int currentIndex, 
                            char[] currentString, List<String> validAnswers) {
        if (forwardParensNeeded == 0 && backwardsParensNeeded == 0) {
            validAnswers.add(new String(currentString));
            return;
        }

        if (forwardParensNeeded > 0) {
            currentString[currentIndex] = '(';
            recurse(forwardParensNeeded - 1, backwardsParensNeeded, currentIndex + 1, 
                    currentString, validAnswers);
        }

        if (backwardsParensNeeded > 0 && forwardParensNeeded < backwardsParensNeeded) {
            currentString[currentIndex] = ')';
            recurse(forwardParensNeeded, backwardsParensNeeded - 1, currentIndex + 1, 
                    currentString, validAnswers);
        }
    }

    // driver program
    public static void main (String[] args)
    {
        int n = 3;
        generateParentheses(n);
    }

}
    