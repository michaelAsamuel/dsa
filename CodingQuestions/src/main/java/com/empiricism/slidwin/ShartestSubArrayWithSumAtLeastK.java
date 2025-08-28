package com.empiricism.slidwin;

public class ShartestSubArrayWithSumAtLeastK {
    public static void main(String[] args) {
//        System.out.println( shortestSubarray(new int[]{2,-1,2},3) );
//        System.out.println( shortestSubarray(new int[]{1},1) );
        System.out.println( shortestSubarray(new int[]{-28,81,-20,28,-29},89) );

//        System.out.println( shortestSubarray(new int[]{84,-37,32,40,95}, 167));

    }

    static int shortestSubarray(int[] nums, int k) {
            int currsum =0;
            int minlength=Integer.MAX_VALUE;
            int left =0, right =0;
            while(left <= right && right < nums.length){
                currsum +=nums[right];
                if(currsum<k){
                    right++;
                }else{
                    while(currsum >=k || nums[left] < 0){
                        if(minlength > right - left+1) minlength = right-left +1;
                        if(left== right) break;
                        currsum = currsum - nums[left];

                        left++;
                    }

                    right++;
                }
            }
            if(minlength == Integer.MAX_VALUE) return -1;

            return minlength;


        }

    public int shortestSubarrayPositive(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currSum += nums[right];

            while (currSum >= k) {
                minLen = Math.min(minLen, right - left + 1);
                currSum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }



}
