package com.datastructures.queue.linkedlist.impl3;

/*
http://ankurm.com/java-implementation-of-queue-using-linked-list/

 */

import java.io.*;
class node
{
    int data;
    node next;
    public node(int x)
    {
        data=x;
        next=null;
    }
}
class Queuemain
{
    node f=null,l=null;

    public boolean isEmpty()
    {
        if (f==null || l==null)
            return true;
        else
            return false;
    }
    public void enqueue(int x)
    {
        if (isEmpty()==true)
        {
            node p=new node (x);
            f=l=p;
        }
        else
        {
            node p=new node (x);
            l.next=p;
            l=p;
        }
    }
    public int dequeue()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            int x=f.data;
            f=f.next;
            return x;
        }
    }
    public int peek()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            return(f.data);
        }
    }
    public void display()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
        }
        else
        {
            node temp=f;
            while (temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
}
public class QueueUsingLL
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int ch,x;
        Queuemain que=new Queuemain();
        do
        {
            System.out.println("##MENU##");
            System.out.println("1.Insert data in queue");
            System.out.println("2.Remove data from queue");
            System.out.println("3.Peek Element in queue");
            System.out.println("4.Display queue");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(obj.readLine());
            switch(ch)
            {
                case 1:System.out.println("Enter data to be inserted");
                    x=Integer.parseInt(obj.readLine());
                    que.enqueue(x);
                    break;
                case 2:System.out.println("Removed data:"+que.dequeue());
                    break;
                case 3:System.out.println("Peeked data:"+que.peek());
                    break;
                case 4:que.display();
                    break;
            }
        }while(ch!=5);
    }
}