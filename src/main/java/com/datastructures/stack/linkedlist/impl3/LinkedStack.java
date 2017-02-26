package com.datastructures.stack.linkedlist.impl3;

/*

http://codereview.stackexchange.com/questions/62710/stack-implementation-using-a-linked-list

Good one

 */

 class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.print(data);
        System.out.print("  ");

    }
}

class LinkList {

    private Node first = null;

    public void insertFirst(int data) {
        Node n = new Node(data);
        n.next = first;
        first = n;
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }
}



class LinkListStack {

    LinkList li = new LinkList();

    public void push(int data) {
        li.insertFirst(data);
    }

    public void pop() {
        while(!li.isEmpty()){
            li.deleteFirst();
        }
    }

    public void displayStack() {
        System.out.println("  ");
        li.displayList();
    }
}


public class LinkedStack {

    public static void main(String[] args) {
        LinkListStack st = new LinkListStack();

        st.push(50);
        st.push(70);
        st.push(190);
        st.displayStack();
        st.pop();
        st.displayStack();

    }
}