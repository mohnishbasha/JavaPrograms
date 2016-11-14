package com.tier1app;

/*
    Here is a sample code which simulates deadlock condition in-between two threads:


 */

public class DeadLockSimulator {

    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();


    private static class FirstThread extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Threadolding lock 1...");
                try { Thread.sleep(10); } catch (Exception e) {}
                System.out.println("Threadaiting for lock 2...");
                synchronized (Lock2) {
                    System.out.println("Threadolding lock 1 & 2...");
                }
            }
        }
    }

    private static class SecondThread extends Thread {
        public void run() {
            synchronized (Lock2) {
                System.out.println("Threadolding lock 2...");
                try { Thread.sleep(10); } catch (Exception e) {}
                System.out.println("Threadaiting for lock 1...");
                synchronized (Lock1) {
                    System.out.println("Threadolding lock 1 & 2...");
                }
            }
        }
    }

    public static void main(String args[]) {

        new FirstThread().start();
        new SecondThread().start();
    }
}