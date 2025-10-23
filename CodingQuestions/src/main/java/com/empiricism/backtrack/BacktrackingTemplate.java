package com.empiricism.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingTemplate {

    public void backtrack(List<Integer> path, boolean[] used, int[] nums) {
        // Base case: if path is a complete solution
        if (path.size() == nums.length) {
            System.out.println(path);  // Print or save the result
            return;
        }

        // Try each possible option
        for (int i = 0; i < nums.length; i++) {
            // Skip if the number is already used
            if (used[i]) continue;

            // Choose
            path.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(path, used, nums);

            // Un-choose (backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        BacktrackingTemplate solver = new BacktrackingTemplate();
        int[] nums = {1, 2, 3};
        solver.backtrack(new ArrayList<>(), new boolean[nums.length], nums);
    }
}

