package com.datastructures.linkedlist.reversemn;

/*
https://www.programcreek.com/2014/06/leetcode-reverse-linked-list-ii-java/

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL

 */

class ListNode {

    ListNode next, prev;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}

public class ReverseBetweenMN {

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
