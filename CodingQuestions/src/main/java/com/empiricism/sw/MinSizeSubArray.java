package com.empiricism.sw;

// Variable sliding window
public class MinSizeSubArray {


    static int minSubArrayLen(int target, int[] nums) {
        // Runtime: 99.6  Memory 30 //
        int result =Integer.MAX_VALUE, curr=0, start=0;
        for(int i=0; i< nums.length; i++){
            // expand the window
            curr += nums[i];

            while(curr >= target ){ // shrink the window
                result= Math.min(result, i-start+1);
                curr -= nums[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

    }
}
