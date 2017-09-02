package com.designpatterns.behavioral.chainofresponsibility.impl2;


public class Numbers {

    private int number1;
    private int number2;

    private String calculationType;

    public  Numbers(int number1, int number2, String calculationType) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculationType = calculationType;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getCalculationType() {
        return calculationType;
    }
}
