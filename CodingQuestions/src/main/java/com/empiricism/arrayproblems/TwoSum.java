package com.empiricism.arrayproblems;
//https://leetcode.com/problems/two-sum/

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        // What me worry! Solution us guaranteed :)
        return new int[1];
    }

    public static void main(String[] args) {

    }
}
