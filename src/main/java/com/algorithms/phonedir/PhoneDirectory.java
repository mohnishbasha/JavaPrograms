package com.algorithms.phonedir;

/*
http://www.geeksforgeeks.org/implement-a-phone-directory/

Implement a Phone Directory
Given a list of contacts which exist in a phone directory. The task is to implement search query for the phone directory.
 The search query on a string ‘str’ displays all the contacts which prefix as ‘str’. One special property of the search
 function is that, when a user searches for a contact from the contact list then suggestions (Contacts with prefix as
 the string entered so for) are shown after user enters each character.

Note : Contacts in the list consist of only lower case alphabets.

Example:
Input : contacts [] = {“gforgeeks” , “geeksquiz” }
        Query String = “gekk”

Output : Suggestions based on "g" are
         geeksquiz
         gforgeeks

         Suggestions based on "ge" are
         geeksquiz

         No Results Found for "gek"

         No Results Found for "gekk"

We strongly recommend you to minimize your browser and try this yourself first.

Phone Directory can be efficiently implemented using Trie Data Structure.
We insert all the contacts into Trie.

Generally search query on a Trie is to determine whether the string is present or not in the trie,
but in this case we are asked to find all the strings with each prefix of ‘str’. This is equivalent to doing a DFS
traversal on a graph. From a Trie node, visit adjacent Trie nodes and do this recursively until there are no more adjacent.

 This recursive function will take 2 arguments one as Trie Node which points to the current Trie Node being visited and
 other as the string which stores the string found so far with prefix as ‘str’.

Each Trie Node stores a boolean variable ‘isLast’ which is true if the node represents end of a contact(word).

// This function displays all words with given
// prefix.  "node" represents last node when
// path from root follows characters of "prefix".

displayContacts (TreiNode node, string prefix)
	If (node.isLast is true)
		display prefix

        // finding adjacent nodes
	for each character ‘i’ in lower case Alphabets
		if (node.child[i] != NULL)
			displayContacts(node.child[i], prefix+i)

User will enter the string character by character and we need to display suggestions with the prefix formed after every
 entered character.

So one approach to find the prefix starting with the string formed is to check if the prefix exists in the Trie, if yes
then call the displayContacts() function. In this approach after every entered character we check if the string exists
in the Trie.

Instead of checking again and again, we can maintain a pointer prevNode‘ that points to the TrieNode which corresponds
to the last entered character by the user, now we need to check the child node for the ‘prevNode’ when user enters
another character to check if it exists in the Trie. If the new prefix is not in the Trie, then all the string which are
 formed by entering characters after ‘prefix’ can’t be found in Trie too. So we break the loop that is being used to
 generate prefixes one by one and print “No Result Found” for all remaining characters.


 */

/*

Output:
Suggestions based on "g" are
geeksquiz
gforgeeks

Suggestions based on "ge" are
geeksquiz

No Results Found for "gek"

No Results Found for "gekk"

 */

// Java Program to Implement a Phone
// Directory Using Trie Data Structure
import java.util.*;

class TrieNode
{
    // Each Trie Node contains a Map 'child'
    // where each alphabet points to a Trie
    // Node.
    HashMap<Character,TrieNode> child;

    // 'isLast' is true if the node represents
    // end of a contact
    boolean isLast;

    // Default Constructor
    public TrieNode()
    {
        child = new HashMap<Character,TrieNode>();

        // Initialize all the Trie nodes with NULL
        for (char i = 'a'; i <= 'z'; i++)
            child.put(i,null);

        isLast = false;
    }
}

class Trie
{
    TrieNode root;

    // Insert all the Contacts into the Trie
    public void insertIntoTrie(String contacts[])
    {
        root = new TrieNode();
        int n = contacts.length;
        for (int i = 0; i < n; i++)
        {
            insert(contacts[i]);
        }
    }

    // Insert a Contact into the Trie
    public void insert(String s)
    {
        int len = s.length();

        // 'itr' is used to iterate the Trie Nodes
        TrieNode itr = root;
        for (int i = 0; i < len; i++)
        {
            // Check if the s[i] is already present in
            // Trie
            TrieNode nextNode = itr.child.get(s.charAt(i));
            if (nextNode == null)
            {
                // If not found then create a new TrieNode
                nextNode = new TrieNode();

                // Insert into the HashMap
                itr.child.put(s.charAt(i),nextNode);
            }

            // Move the iterator('itr') ,to point to next
            // Trie Node
            itr = nextNode;

            // If its the last character of the string 's'
            // then mark 'isLast' as true
            if (i == len - 1)
                itr.isLast = true;
        }
    }

    // This function simply displays all dictionary words
    // going through current node.  String 'prefix'
    // represents string corresponding to the path from
    // root to curNode.
    public void displayContactsUtil(TrieNode curNode,
                                    String prefix)
    {

        // Check if the string 'prefix' ends at this Node
        // If yes then display the string found so far
        if (curNode.isLast)
            System.out.println(prefix);

        // Find all the adjacent Nodes to the current
        // Node and then call the function recursively
        // This is similar to performing DFS on a graph
        for (char i = 'a'; i <= 'z'; i++)
        {
            TrieNode nextNode = curNode.child.get(i);
            if (nextNode != null)
            {
                displayContactsUtil(nextNode, prefix + i);
            }
        }
    }

    // Display suggestions after every character enter by
    // the user for a given string 'str'
    void displayContacts(String str)
    {
        TrieNode prevNode = root;

        // 'flag' denotes whether the string entered
        // so far is present in the Contact List

        String prefix = "";
        int len = str.length();

        // Display the contact List for string formed
        // after entering every character
        int i;
        for (i = 0; i < len; i++)
        {
            // 'str' stores the string entered so far
            prefix += str.charAt(i);

            // Get the last character entered
            char lastChar = prefix.charAt(i);

            // Find the Node corresponding to the last
            // character of 'str' which is pointed by
            // prevNode of the Trie
            TrieNode curNode = prevNode.child.get(lastChar);

            // If nothing found, then break the loop as
            // no more prefixes are going to be present.
            if (curNode == null)
            {
                System.out.println("\nNo Results Found for \""
                        + prefix + "\"");
                i++;
                break;
            }

            // If present in trie then display all
            // the contacts with given prefix.
            System.out.println("\nSuggestions based on \""
                    + prefix + "\" are");
            displayContactsUtil(curNode, prefix);

            // Change prevNode for next prefix
            prevNode = curNode;
        }

        for ( ; i < len; i++)
        {
            prefix += str.charAt(i);
            System.out.println("\nNo Results Found for \""
                    + prefix + "\"");
        }
    }
}

// Driver code
class PhoneDirectory
{
    public static void main(String args[])
    {
        Trie trie = new Trie();

        String contacts [] = {"gforgeeks", "geeksquiz"};

        trie.insertIntoTrie(contacts);

        String query = "gekk";

        // Note that the user will enter 'g' then 'e' so
        // first display all the strings with prefix as 'g'
        // and then all the strings with prefix as 'ge'
        trie.displayContacts(query);
    }
}