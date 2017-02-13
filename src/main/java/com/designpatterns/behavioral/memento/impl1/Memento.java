package com.designpatterns.behavioral.memento.impl1;

/*
Step 1
Create Memento class.

 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}