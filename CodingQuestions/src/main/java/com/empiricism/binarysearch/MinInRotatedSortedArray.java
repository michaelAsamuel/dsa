package com.empiricism.binarysearch;

public class MinInRotatedSortedArray {
    static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) { // Success left == right
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum is in right half
            } else {
                right = mid;    // Minimum is in left half (including mid)
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println( findMin(new int[]{3,4,5,6,2}));
    }
}
