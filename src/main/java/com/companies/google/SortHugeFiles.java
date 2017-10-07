package com.companies.google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;


/*

- We have 2 large (multi TB) text files with lines having multiple fields, whitespace delimited.

        The first field is a unique key within each file, the subsequent fields are the payload.

        Some keys may be in both files, some keys may only exist in one of the two files.

        The 2 files are mostly (not exactly) sorted by the first field. Mostly sorted means that the location of each line is within N lines of where it would be if fully sorted by the first field.
        N=100,000. Each line length is <= 1k.

        Join the 2 files on the first field: find the lines with common first field between file1 and file2, and write out the common field and the 2 payloads.

        Example with N=2:


        file1 contents:
        key197 The quick
        key2189 rt gf wsd
        key328 jumps over
        key417 bb hh nn

        file2 contents:
        key2188 A B C
        key197 brown fox
        key328 the lazy dog
        key419 AA BB

        In this example the result would be:
        key197 The quick brown fox
        key328 jumps over the lazy dog
*/


/**
 * Created by i839511 on 9/28/17.
 */
public class SortHugeFiles {

    static class Record implements Comparable{
        public String key;
        public String value;
        Record(String line){
            key = line.substring(0,line.indexOf(' '));
            value = line.substring(line.indexOf(' '));
        }

        public boolean equals(Object r2)
        {
            Record target = (Record)r2;
            return (key.equals(target.key));
        }

        public int compareTo(Object r2)
        {
            Record target = (Record)r2;
            return (key.compareTo(target.key));
        }
    }

    static class ConstrainedHugeFileSorter
    {
        BufferedReader inReader ;
        TreeSet<Record>  sortedBuffer;
        boolean endReached = false;
        ConstrainedHugeFileSorter(String fileName,int constrainedLength) throws Exception
        {
            inReader = new BufferedReader(new FileReader(fileName));
            sortedBuffer = new TreeSet<>();
            for(int i=0;i<constrainedLength;i++){
                String line = inReader.readLine();
                if( inReader.readLine()!=null )
                    sortedBuffer.add(new Record(line));
                else
                {   endReached=true;
                    return; // handled corner case.
                }
            }

        }

        Record next(){
            return  sortedBuffer.first();
        }

        Record removeFirst() throws Exception{
            Record r = next();
            sortedBuffer.remove(r);
            if(r!=null && !endReached)
            {
                String line = inReader.readLine();
                if(line != null)
                    sortedBuffer.add(new Record (line));
                else
                    endReached=true;
            }
            return r;
        }

    }

    public static void main(String[] args) throws Exception {
        String firstFile = "firstFile.txt";
        String secondFile = "secondFile.txt";
        int constrainLength = 10000;

        ConstrainedHugeFileSorter first = new ConstrainedHugeFileSorter(firstFile,constrainLength);
        ConstrainedHugeFileSorter second = new ConstrainedHugeFileSorter(secondFile,constrainLength);

        while (first.next()!=null && second.next()!=null){
            Record f1 = first.next();
            Record f2= second.next();
            int compared=first.next().compareTo(second.next());
            if(compared < 0){
                // System.out.println(f1.key +":"+ f1.value + f2.value);
                first.removeFirst();
                //second.removeFirst();
            }else if (compared > 0){
                second.removeFirst();

            }else{
                System.out.println(f1.key +":"+ f1.value + f2.value);
                first.removeFirst();
                second.removeFirst();
            }

        }


    }
}
