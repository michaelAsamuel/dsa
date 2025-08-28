package com.empiricism.simple.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
            // Create a hashmap to store number and its index
            HashMap<Integer, Integer> map = new HashMap<>();

            // Loop through the array
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                // Check if the complement exists in the map
                if (map.containsKey(complement)) {
                    // If found, return the indices
                    return new int[] { map.get(complement), i };
                }

                // Store the current number with its index
                map.put(nums[i], i);
            }

            // If no solution found, throw an exception
            throw new IllegalArgumentException("No two sum solution");

    }


    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1: " + Arrays.toString(solution.twoSum(nums1, target1))); // Expected: [0, 1]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test Case 2: " + Arrays.toString(solution.twoSum(nums2, target2))); // Expected: [1, 2]

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Test Case 3: " + Arrays.toString(solution.twoSum(nums3, target3))); // Expected: [0, 1]

        // Test Case 4 (Edge case - larger array)
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target4 = 17;
        System.out.println("Test Case 4: " + Arrays.toString(solution.twoSum(nums4, target4))); // Expected: [7, 8]

        // Uncomment below to see exception handling
        /*
        int[] nums5 = {1, 2, 3};
        int target5 = 10;
        System.out.println("Test Case 5: " + Arrays.toString(solution.twoSum(nums5, target5))); // Expected: Exception
        */
    }

}
