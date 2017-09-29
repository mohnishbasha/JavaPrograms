package org.topics.garbagecollection;

// Java code illustrating gc(), freeMemory()
// and totalMemory() methods
/*
http://www.geeksforgeeks.org/find-max-memory-free-memory-total-memory-java/

 */
public class MemoryDemo
{
    public static void main(String arg[])
    {
        Runtime gfg = Runtime.getRuntime();
        long memory1, memory2;
        Integer integer[] = new Integer[1000];

        // checking the total memeory
        System.out.println("Total memory is: "
                + gfg.totalMemory());

        // checking free memory
        memory1 = gfg.freeMemory();
        System.out.println("Initial free memory: "
                + memory1);

        // calling the garbage collector on demand
        gfg.gc();

        memory1 = gfg.freeMemory();

        System.out.println("Free memory after garbage "
                + "collection: " + memory1);

        // allocating integers
        for (int i = 0; i < 1000; i++)
            integer[i] = new Integer(i);

        memory2 = gfg.freeMemory();
        System.out.println("Free memory after allocation: "
                + memory2);

        System.out.println("Memeory used by allocation: " +
                (memory1 - memory2));

        // discard integers
        for (int i = 0; i < 1000; i++)
            integer[i] = null;

        gfg.gc();

        memory2 = gfg.freeMemory();
        System.out.println("Free memeory after  "
                + "collecting discarded Integers: " + memory2);
    }
}

/* Run on IDE
        Output:

        Total memory is: 128974848
        Initial free memory: 126929976
        Free memory after garbage collection: 128632384
        Free memory after allocation: 127950744
        Memory used by allocation: 681640
        Free memory after collecting discarded Integers: 128643696

*/