package com.datastructures.linkedlist.reverse;


/*
https://www.programcreek.com/2014/05/leetcode-reverse-nodes-in-k-group-java/

Given a linked list, reverse the nodes of a linked list k at a time and return its
modified list. If the number of nodes is not a multiple of k then left-out nodes in the
end should remain as it is. You may not alter the values in the nodes, only nodes
itself may be changed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5


 */

class ListNode {
    ListNode next, prev;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}

public class ReverseNodesKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || k==1)
            return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        int i=0;

        ListNode p = head;

        while(p!=null){
            i++;
            if(i%k==0){
                prev = reverse(prev, p.next);
                p = prev.next;
            }else{
                p = p.next;
            }
        }

        return temp.next;
    }

    public ListNode reverse(ListNode prev, ListNode next){
        ListNode last = prev.next;
        ListNode curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }
}
