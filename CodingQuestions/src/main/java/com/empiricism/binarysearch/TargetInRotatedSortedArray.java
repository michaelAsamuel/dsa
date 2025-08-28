package com.empiricism.binarysearch;

public class TargetInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input ={4,5,6,7,0,1,2};
        System.out.println(search(input, 0));

        int[] input1 ={1};
        System.out.println(search(input, 3));
        System.out.println(search(input1, 0));

    }


    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Check which side is sorted
            if (nums[left] <= nums[mid]) { // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1; // Search right
                }
            } else { // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }

        return -1; // Not found
    }

}
