package org.topics.garbagecollection;


/*
http://www.geeksforgeeks.org/output-of-java-programs-set-10-garbage-collection/
http://www.geeksforgeeks.org/garbage-collection-java/



 */
// Java program to demonstrate requesting
// JVM to run Garbage Collector
public class GC {
    public static void main(String[] args) throws InterruptedException {
        GC t1 = new GC();
        GC t2 = new GC();

        // Nullifying the reference variable
        t1 = null;

        // requesting JVM for running Garbage Collector
        System.gc();

        // Nullifying the reference variable
        t2 = null;

        // requesting JVM for running Garbage Collector
        Runtime.getRuntime().gc();

    }

    @Override
    // finalize method is called on object once
    // before garbage collecting it
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }

}

/*

Run on IDE
        Output:

        Garbage collector called
        Object garbage collected : Test@46d08f12
        Garbage collector called
        Object garbage collected : Test@481779b8

 */
