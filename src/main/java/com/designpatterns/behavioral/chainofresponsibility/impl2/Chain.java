package com.designpatterns.behavioral.chainofresponsibility.impl2;


public interface Chain {

    public void setNextChain(Chain nextChain);
    public void calculate(Numbers request);
}
