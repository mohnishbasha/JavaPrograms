package com.designpatterns.creational.abstractfactory.impl1;

/*
Step4
Create concrete classes implementing the same interface.
 */
public class Red implements Color {

    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}