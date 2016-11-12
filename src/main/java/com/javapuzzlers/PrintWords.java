package com.javapuzzlers;

/**
 * Created by i835811 on 11/12/16.
 */
public class PrintWords {

    public static void main(String[] args) {
        System.out.println(Words.FIRST + " " + Words.SECOND + " " + Words.THIRD);
        System.out.println(Words1.FIRST + " " + Words1.SECOND + " " + Words1.THIRD);
    }
}

class Words {

    private Words() {}; // not initializable

    // public static final String FIRST = "the";
    // public static final String SECOND = null;
    // public static final String THIRD = "set";

    public static final String FIRST = "physics";
    public static final String SECOND = "chemistry";
    public static final String THIRD = "biology";

}

class Words1 {

    private Words1() {}; // not initializable

    public static final String FIRST = "the";
    public static final String SECOND = null;
    public static final String THIRD = "set";

}
