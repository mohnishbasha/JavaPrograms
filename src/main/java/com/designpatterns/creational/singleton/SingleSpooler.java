package org.designpatterns.creational.singleton;

class SingletonException extends RuntimeException {

	public SingletonException() {
        super();
	}

	public SingletonException(String s) {
        super(s);
	}
}

class Spooler {

	static boolean instance_flag = false;

	public Spooler() throws SingletonException {

		if(instance_flag)
			throw new SingletonException("Only one allowed");
		else
			instance_flag=true;

        System.out.println("Printer Opened");
	}
}



public class SingleSpooler {

	public static void main(String args[]) {

		Spooler pr1, pr2;
		System.out.println("Opening one spooler");

        try {
			pr1  = new Spooler();
		}
		catch(SingletonException e) {
			System.out.println(e.getMessage());
		}

		try {
			pr2  = new Spooler();
		}

		catch(SingletonException e) {
			System.out.println(e.getMessage());
		}
	}
}
