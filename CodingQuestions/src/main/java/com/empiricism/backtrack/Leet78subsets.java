package com.empiricism.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Leet78subsets {
    public static void main(String[] args) {

    }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(0, nums, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
            result.add(new ArrayList<>(current));
            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                backtrack(i + 1, nums, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }

    public List<List<Integer>> subsetsCasc(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        return result;
    }

}
