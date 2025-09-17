package com.empiricism.arrayproblems;

//https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicateNumber {

        static int findDuplicate(int[] nums) {
            // Phase 1: Finding the intersection point of the two runners.
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];         // move one step
                fast = nums[nums[fast]];   // move two steps
            } while (slow != fast);

            // Phase 2: Finding the entrance to the cycle.
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{3,3,3,3,3}));

    }


}
