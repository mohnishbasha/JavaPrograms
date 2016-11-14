package com.algorithms.problems.salesforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPrintSequence {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        PrintNumber one = new PrintNumber("1");
        PrintNumber two = new PrintNumber("2", one);
        PrintNumber three = new PrintNumber("3", two);
        one.parent = three;
        threadPool.execute(one);
        threadPool.execute(two);
        threadPool.execute(three);
    }

}

class PrintNumber implements Runnable {
    public String number;
    public Runnable parent;
    public PrintNumber(String number ){
        this.number = number;
    }

    public PrintNumber(String number , Runnable parent){
        this.number = number;
        this.parent = parent;
    }
    public void run(){
        while (true) {
            try {
                System.out.println(number);
                synchronized (this) {
                    notify();
                }

                synchronized (parent) {
                    parent.wait();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalMonitorStateException ex) {
                ex.printStackTrace();
            }

        }
    }
}
