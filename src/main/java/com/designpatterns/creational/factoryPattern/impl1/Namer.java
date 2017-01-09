package com.designpatterns.creational.factoryPattern.impl1;

class Namer {
	// a simple class to take a string apart into two names
	protected String last; // store last name here
	protected String first; // store first name here

	public String getFirst() {
		return first; // return first name
	}

	public String getLast() {
		return last; // return last name
	}
}