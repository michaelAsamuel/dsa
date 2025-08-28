package com.empiricism.slidwin;

public class MaxSumSubarray {
    public static void main(String[] args) {
        System.out.println( (maxSumArray(new int[]{1,4,7,2,5,9,11,2,0},4)));
    }

    static int maxSumArray(int[] num, int target){
        int maxsum=0, currsum=0;
        for(int i=0 ; i< target; i++ ){
          currsum += num[i];
        }
        maxsum=currsum;
        int i=1;
        for(int j=target; j< num.length; j++){
            currsum = currsum - num[i-1] + num[j];
            if(maxsum < currsum){
                maxsum = currsum;
            }
        }
        return maxsum;
    }
}
