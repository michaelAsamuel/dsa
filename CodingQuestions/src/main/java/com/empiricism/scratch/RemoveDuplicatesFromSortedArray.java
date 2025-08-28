package com.empiricism.scratch;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        int[] input = {1,1,2};
        int[] input = {2,1,1};
        System.out.println( removeDuplicates(input));

    }
    public static int removeDuplicates(int[] nums) {
        int count =0;
        for(int i=0; i< nums.length-1; i++){
            if(nums[i] == nums[i+1])
                count++;
        }
        int[] deduplicated = new int[nums.length-count];
        for (int i=0, j=0; i < deduplicated.length; i++,j++){
            deduplicated[i] = nums[j];
            while( j<nums.length-1 && nums[j]==nums[j+1] ){
                j++;
            }
        }
        System.out.println(Arrays.toString(deduplicated));
        return deduplicated.length;
    }
}
