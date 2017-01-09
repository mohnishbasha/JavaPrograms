package com.designpatterns.creational.factoryPattern.impl1;

class NameFactory {
	// returns an instance of LastFirst or FirstFirst
	// depending on whether a comma is found
	public Namer getNamer(String entry) {
	int i = entry.indexOf(","); //comma determines name
	
	if (i>0)
	return new LastFirst(entry); //return one class
	else
	return new FirstFirst(entry); //or the other
	}
}
