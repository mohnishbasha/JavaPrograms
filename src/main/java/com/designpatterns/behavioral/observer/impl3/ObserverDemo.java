package com.designpatterns.behavioral.observer.impl3;


import java.util.ArrayList;
import java.util.List;

class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAll();
    }

    public void attach(Observer o){
        observers.add(o);
    }

    public void notifyAll1() { // override notifyAll
        for(Observer observer: observers){
            observer.update();
        }
    }
}

interface Observer{
    public Subject subject = null;
    public void update();
}

class HexaObject implements Observer {

    public HexaObject(Subject subject) {
        //this.subject = subject;
        this.subject.attach(this);
    }

    public void update(){
        System.out.println(" Hexa observer value"+ Integer.toHexString(subject.getState()));
    }
}

class OctalObject implements Observer{

    public OctalObject(Subject subject) {
        //this.subject = subject;
        this.subject.attach(this);
    }

    public void update(){
        System.out.println(" Octal observer value"+ Integer.toOctalString(subject.getState()));
    }
}

class BinaryObject implements Observer{

    public BinaryObject(Subject subject) {
        //this.subject = subject;
        this.subject.attach(this);
    }

    public void update(){
        System.out.println(" Binary observer value"+ Integer.toBinaryString(subject.getState()));
    }
}


public class ObserverDemo{
    public static void main(String[] args){
        Subject subject = new Subject();

        new HexaObject(subject);
        new OctalObject(subject);
        new BinaryObject(subject);

        System.out.println("Set state to 5");
        subject.setState(5);
    }
}
