package com.companies.google;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FilesMerge {

    public void lookupFiles(String file1, String file2, int N) // N = 1 to 100,000
    {
        BufferedReader br1 = null;
        FileReader fr1 = null;

        BufferedReader br2 = null;
        FileReader fr2 = null;
        int lineCount = 0;

        HashMap<String, String> nMap = new HashMap<String, String>(N); // capacity
        try {

            // load file1
            fr1 = new FileReader(file1);
            br1 = new BufferedReader(fr1);

            // load file2
            fr2 = new FileReader(file2);
            br2 = new BufferedReader(fr2);
            String f1, f2 = null; // current line pointers for file1, file2

            while ( (f1 = br1.readLine())  != null || (f2 = br2.readLine()) != null) {

                while(lineCount < N) {

                    if(f1 != null) {
                        String[] words = f1.split(" "); // space delimited
                        String key = words[0];
                        String payload = f1.substring(key.length(), f1.length());

                        nMap.put(key, payload);

                    }

                    if(f2 != null) {
                        String[] words = f2.split(" "); // space delimited
                        String key = words[0];
                        String payload = f2.substring(key.length(), f1.length());

                        if(nMap.get(key) != null ) {
                            StringBuilder value = new StringBuilder (nMap.get(key));
                            value.append(payload);
                            System.out.println(key + " " + value.toString());

                        }
                    }
                    lineCount = lineCount + 1; // process this until 100,000


                }

                // reset lineCount and flush hashmap.
                lineCount = 0;
                nMap.clear();


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br1 != null) {
                    br1.close();
                }
                if (fr1 != null) {
                    br1.close();
                }
                if (br2 != null) {
                    br1.close();
                }
                if (fr2 != null) {
                    br1.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}



