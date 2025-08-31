package com.empiricism.traversal.backtrack;

import java.util.*;

class BacktrackingTemplate {
    // Global result list to store all solutions
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return result;
    }

    // Backtracking function
    void backtrack(List<Integer> path, int[] nums, int start) {
        // Base case (or rather, record current state):
        // Every path is a valid subset, so add it
        result.add(new ArrayList<>(path));

        // Explore choices starting from "start"
        for (int i = start; i < nums.length; i++) {
            // Choose
            path.add(nums[i]);

            // Explore (go deeper)
            backtrack(path, nums, i + 1);

            // Un-choose (backtrack step)
            path.remove(path.size() - 1);
        }
    }

    // Test driver
    public static void main(String[] args) {
        BacktrackingTemplate bt = new BacktrackingTemplate();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = bt.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> s : subsets) {
            System.out.println(s);
        }
    }
}

