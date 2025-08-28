package com.empiricism.simple.easy;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] x = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(x));
    }
    public static int maxArea(int[] height) {
        int left =0;
        int right= height.length-1;
        int waterContained=0;
        int maxContained=0;

        while(left < right){
            if(height[left] > height[right]){
                waterContained = height[right] * (right-left);
                right--;
            }else{
                waterContained = height[left] * (right-left);

                left++;
            }
            if(maxContained < waterContained)
                maxContained= waterContained;

        }
        return maxContained;

    }
}
