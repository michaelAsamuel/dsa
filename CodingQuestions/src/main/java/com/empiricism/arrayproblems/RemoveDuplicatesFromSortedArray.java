package com.empiricism.arrayproblems;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    /**
     * We need to remove duplicates In-Place so no additional array is allowed
     * Final array is guaranteed to be smaller (single characters not followed by count)
     * Trailing digits can be anything
     *
     Approach: since we do not care what the last digits are after the duplicates.
     Just make sure the left side is unique.
     2 Pointers : i -> distinct digits : determines where we overwrite
     j -> Current digit
     */
    public int RemoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
