package com.empiricism.binarysearch;

public class FindTargetInArray {

        public int search(int[] nums, int target) {
            // 0. Left & Right define range
            int left = 0, right = nums.length - 1;

            // 1. exit condition
            while (left <= right) {
                // 2. Mid point
                int mid = left + (right - left) / 2;  // Calculate mid to avoid overflow

                if (nums[mid] == target) {
                    return mid;  // 3. If target is found, return the index
                }
                else if (nums[mid] < target) { // 4. condition for adjusting range
                    left = mid + 1;  // If target is greater, discard the left half
                } else {
                    right = mid - 1;  // If target is smaller, discard the right half
                }
            }
            return -1;  // If target is not found, return -1
        }

}
