package com.algorithms.datastructures.list.sortedcircularlist;

/*
    https://www.careercup.com/question?id=5750341430673408

    Add node in the middle to sorted circurlar list.

 */
public class SortedCircularList
{
    static final class Node
    {
        private Node next;
        private Integer data;

        Node(Integer data)
        {
            this.data = data;
        }
    }

    //sentinel node.
    private final Node head;

    public SortedCircularList()
    {
        head = new Node(null);
        head.next = head;
    }

    public void add(Node n)
    {
        if(head.next==head)
        {
            head.next = n;
            n.next = head;
            return;
        }

        //find the right pos.
        Node prev = head.next;
        Node cur = head.next.next;
        while(cur!=head && cur.data<=n.data)
        {
            prev = cur;
            cur = cur.next;
        }

        n.next = prev.next;
        prev.next = n;
        if(n.data<prev.data)
        {
            int temp = n.data;
            n.data = prev.data;
            prev.data = temp;
        }
    }

    public void print()
    {
        Node n = head.next;
        while(n!=head)
        {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("******");

    }

    public static void main(String ...args)
    {
        SortedCircularList list = new SortedCircularList();
        list.add(new Node(4));
        list.add(new Node(10));
        list.add(new Node(14));
        list.print();


        //Adding a node in between.
        list.add(new Node(0));
        list.print();
        list.add(new Node(11));
        list.print();
    }

}