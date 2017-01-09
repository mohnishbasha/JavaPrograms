package com.designpatterns.structural.filter.impl1;


/*
Step 1
Create a class on which criteria is to be applied.

 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
}