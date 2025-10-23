package com.empiricism.know;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycleFloyd(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;  // Moves 1 step
        ListNode fast = head;  // Moves 2 steps

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow by 1
            fast = fast.next.next;      // Move fast by 2

            if (slow == fast) {         // Cycle detected
                return true;
            }
        }

        return false;  // No cycle found
    }

    public boolean hasCycleHashset(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true; // cycle found
            }
            visited.add(current);
            current = current.next;
        }
        return false; // reached end, no cycle
    }

//    public boolean hasCycleHashset(int[] input) {
//        int p1 = 0;
//
//        while (current != null) {
//            if (visited.contains(current)) {
//                return true; // cycle found
//            }
//            visited.add(current);
//            current = current.next;
//        }
//        return false; // reached end, no cycle
//    }


    public static void main(String[] args) {
        // Create a linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle back to 2)
        ListNode headCycle = new ListNode(1);
        headCycle.next = new ListNode(2);
        headCycle.next.next = new ListNode(3);
        headCycle.next.next.next = new ListNode(4);
        headCycle.next.next.next.next = headCycle.next; // cycle here

        // Create a linked list without a cycle: 5 -> 6 -> 7 -> null
        ListNode headNoCycle = new ListNode(5);
        headNoCycle.next = new ListNode(6);
        headNoCycle.next.next = new ListNode(7);

        // Instantiate solutions
        LinkedListCycle solHash = new LinkedListCycle();


        System.out.println("=== Testing Cycle List ===");
        System.out.println("Floyd: " + solHash.hasCycleFloyd(headCycle)); // true
        System.out.println("HashSet: " + solHash.hasCycleHashset(headCycle)); // true


        System.out.println("\n=== Testing No Cycle List ===");
        System.out.println("Floyd: " + solHash.hasCycleFloyd(headNoCycle)); // false
        System.out.println("HashSet: " + solHash.hasCycleHashset(headNoCycle)); // false

    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
