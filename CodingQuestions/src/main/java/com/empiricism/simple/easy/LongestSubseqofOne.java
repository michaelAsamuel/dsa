package com.empiricism.simple.easy;

public class LongestSubseqofOne {
    public static void main(String[] args) {
        //int[] input = {1,1,0,1};
        int[] input = {0,1,1,1,0,1,1,0,1};
//        int[] input = {1,1,1};
        System.out.println(longestSubarray(input));
    }



    public static int longestSubarray(int[] nums) {
        int maxLength = 0;
        int currLength =0;
        int prevlength = 0;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                     hasZero=true;
                     maxLength = Math.max(maxLength, currLength+prevlength);
                     System.out.println("curr length: "+currLength);
                     prevlength=currLength;
                     currLength=0;

            }else{
                currLength++;
            }


        }
        if(hasZero){
            return Math.max(maxLength, currLength+prevlength);
        }
        return Math.max(maxLength, currLength-1);

    }
//    public static int longestSubarray(int[] nums) {
//
//        int left=0;
//        int zeroCount=0;
//        int maxLength=0;
//
//        for(int right=0; right<nums.length; right++){
//
//
//            if(nums[right] ==0){
//                zeroCount++;
//            }
//
//            while(zeroCount >1){
//                if(nums[left] ==0){
//                    zeroCount--;
//                }
//                left++;
//            }
//            maxLength =Math.max(maxLength,(right-left));
//
//
//        }
//
//        return maxLength;
//    }



}
