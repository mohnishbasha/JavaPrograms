package com.designpatterns.creational.abstractfactory.impl1;

/*
Step 2
Create concrete classes implementing the same interface.
 */

public class Rectangle implements Shape {

    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}