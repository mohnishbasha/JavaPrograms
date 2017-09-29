package com.designpatterns.creational.singleton.impl2;

/**
 * Java Program to demonstrate where to use "volatile" keyword in Java.
 * In this example Singleton Instance is declared as volatile variable to ensure
 * every thread sees udated value for _instance.
 *
 *
 *
 *
 */

/**
     Reference: Singleton
     http://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

     How can one break Singleton ?
     http://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/

     The following can break Singleton:
     - Reflection
     - Use Enums

     - Serialization
     - implement readResolve() method - return the same instance

     - Clone-ing
     - override clone method to thrown CloneNotSupportedException

 */


public class SingleObject {

    //create an object of SingleObject
    private static volatile SingleObject _instance = new SingleObject();

    // make the constructor private so that this class cannot be
    // instantiated
    private SingleObject() {

    }

    //Get the only object available
    public static SingleObject getInstance(){

        // in case 2 threads access this first time.
        // we need to ensure the second thread doesn't need to wait
        //  hence double null check condition.

        if(_instance == null) {
            synchronized (SingleObject.class) {
                if (_instance == null) {
                    _instance = new SingleObject();
                }
            }
        }

        return _instance;
    }

    public void showMessage()
    {
        System.out.println("Hello World!");
    }
}