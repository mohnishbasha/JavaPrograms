package com.designpatterns.creational.factoryPattern.impl1;

class FirstFirst extends Namer { // split first last
	
	public FirstFirst(String s) {
	int i = s.lastIndexOf(" "); //find sep space
	if (i > 0) {
	//left is first name
	first = s.substring(0, i).trim();
	//right is last name
	last =s.substring(i+1).trim();
	}
	else {
	first = ""; // put all in last name
	last = s; // if no space
	}
	}
}
