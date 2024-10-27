package com.empiricism.sw;

//862. Shortest Subarray with Sum at Least K
public class ShortestSubarray862 {

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{2,4,6,10,2,1}, 12));

    }
    public static int shortestSubarray(int[] nums, int k) {
        int result = nums.length+1;
        int winSum = 0;
        int startIndex =0;
        for(int i=0; i< nums.length; i++){
           winSum += nums[i];
           if(winSum >= k){
               while(nums[startIndex]< winSum -k ){
                   winSum -= nums[startIndex];
                   startIndex++;
               }
               result = Math.min(result, 1 + i - startIndex );
               winSum -= nums[startIndex];
               startIndex++;
           }
        }
        return result;

    }
}
