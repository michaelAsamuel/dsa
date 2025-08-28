package com.empiricism.slidwin;
//https://leetcode.com/problems/maximum-average-subarray-i/submissions/1689239569/
// Runtime: 99+ Memory: 87+
public class MaxAverageSubArray {
    static double findMaxAverage(int[] nums, int k) {
        int maxsum = 0, currsum = 0;

        // Step 1: Compute the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            currsum += nums[i];
        }
        maxsum = currsum;

        // Step 2: Sliding window
        int i = 1;
        for (int j = k; j < nums.length; j++) {
            currsum = currsum - nums[i - 1] + nums[j];
            if (currsum > maxsum) {
                maxsum = currsum;
            }
            i++;
        }

        // Step 3: Return average
        // Point to Ponder: Why did we not maintain max average when we have to return the max average?
        return (double) maxsum / k;

    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }
}
