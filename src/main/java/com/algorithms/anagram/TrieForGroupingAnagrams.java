package com.algorithms.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Pattern matching using Trie data structure.
 * @author Nilesh
 */

/*


    Order of the Algorithm

    Time Complexity is O(m.nlogn) where m is total number of words in given sequence and n is the average length of
    each word in given sequence.
    -    Space Complexity is Worst case : O(m*n)

 */

public class TrieForGroupingAnagrams {

    // we are only dealing with keys with chars 'a' to 'z'
    final static int ALPHABET_SIZE = 26;

    class TrieNode
    {

        ArrayList<Integer> anagramIndices;

        TrieNode[] children;

        TrieNode()
        {
            children = new TrieNode[ALPHABET_SIZE];
            this.anagramIndices = new ArrayList();
        }
    }

    TrieNode root;

    TrieForGroupingAnagrams()
    {
        this.root = new TrieNode();
    }

    private int getIndex(char ch)
    {
        return ch - 'a';
    }

    public void insertIntoTrie(String key, int index, HashMap anagramNodes)
    {
        // null keys are not allowed
        if (key == null) return;

        key = key.toLowerCase();

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while (charIndex < key.length())
        {
            int childIndex = getIndex(key.charAt(charIndex));

            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                System.out.println("Invalid Key");
                return;
            }

            if (currentNode.children[childIndex] == null)
            {
                currentNode.children[childIndex] = new TrieNode();
            }

            currentNode = currentNode.children[childIndex];

            charIndex  += 1;
        }

        if (charIndex == key.length())
        {
            currentNode.anagramIndices.add(index);
            anagramNodes.put(currentNode, currentNode.anagramIndices);
        }

        return;
    }

    public void printGroupedAnagrams(String[] sequence)
    {
        HashMap<TrieNode, ArrayList<Integer>> anagramNodes = new HashMap();
        for (int i = 0;  i < sequence.length; i++)
        {
            char[] charSequence = sequence[i].toCharArray();
            Arrays.sort(charSequence);

            insertIntoTrie(new String(charSequence), i, anagramNodes);
        }

        Iterator<ArrayList<Integer>> mapItr = anagramNodes.values().iterator();
        while (mapItr.hasNext())
        {
            ArrayList<Integer> currentAnagramList = mapItr.next();
            for (int j = 0; j < currentAnagramList.size(); j++)
            {
                int indexIntoSequence = currentAnagramList.get(j);
                System.out.print(" " + sequence[indexIntoSequence]);
            }
            System.out.println("");
        }
    }


    public static void main(String[] args)
    {
        TrieForGroupingAnagrams tr = new TrieForGroupingAnagrams();

        String[] sequence = {"god","act","tic","tac","dog","cat"};

        tr.printGroupedAnagrams(sequence);

    }
}