package com.designpatterns.behavioral.chainofresponsibility.impl2;

/*
https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm


https://www.youtube.com/watch?v=jDX6x8qmjbA

This pattern sends data to an object, if that object cant use the data, it sends it to another object that may be able
to use the data.

Chain objects help each other solve a problem.
- Behavioral Pattern

In this pattern, normally each receiver contains reference to another receiver. If one object cannot handle the request
then it passes the same to the next receiver and so on.

 */

public class TestCalcChain {

    public static void main(String[] args) {
        Chain calc1 = new AddNumbers();
        Chain calc2 = new SubstractNumbers();
        Chain calc3 = new MultiplyNumbers();
        Chain calc4 = new DivideNumbers();

        calc1.setNextChain(calc2);
        calc2.setNextChain(calc3);
        calc3.setNextChain(calc4);

        Numbers request = new Numbers(4, 2, "add");
        calc1.calculate(request);


        Numbers request2 = new Numbers(4, 2, "sub");
        calc1.calculate(request2);


        Numbers request3 = new Numbers(4, 2, "mul");
        calc1.calculate(request3);


        Numbers request4 = new Numbers(4, 2, "div");
        calc1.calculate(request4);

        Numbers request5 = new Numbers(4, 2, "pow");
        calc1.calculate(request5);

    }
}
