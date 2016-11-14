package org.designpatterns.creational.singleton;

public class SingletonPrintSpooler {

	private static SingletonPrintSpooler spooler;
	
	private SingletonPrintSpooler() {
		
	}
	public static synchronized SingletonPrintSpooler getSpooler() {
		if(spooler == null)
			spooler = new SingletonPrintSpooler();
		return spooler;
		
	}
	
	public void print(String s) {
		System.out.println(s);
	}
}
