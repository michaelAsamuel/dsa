package com.empiricism.arrayproblems;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Step 3: Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 4: Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 5: Remove the nth node from end
        second.next = second.next.next;

        // Step 6: Return the head of the modified list
        return dummy.next;


    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
