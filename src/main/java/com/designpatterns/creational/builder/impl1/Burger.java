package com.designpatterns.creational.builder.impl1;


public abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}
