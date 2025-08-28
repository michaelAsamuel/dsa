package com.empiricism.dp;

public class MaximumSubarray {

    public int maxSubArrayChatGpt(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currentMax = nums[0];  // dp[i]
        int globalMax = nums[0];   // max(dp[i]) over all i

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;

    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currentMax = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(currentMax > 0){
                currentMax += nums[i];
            }else{
                currentMax = nums[i];
            }
            max = Math.max(max, currentMax);
            System.out.println(max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);

    }

}
