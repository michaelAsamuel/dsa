package com.empiricism.hard;

public class RainWater {

    public static void main(String[] args) {
       int[]  input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapRainWater(input));

    }
        public static int trapRainWater(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int trappedWater = 0;

            while (left < right) {
                if (height[left] < height[right]) { // right side wall exists
                    if (height[left] >= leftMax) { // Water will flow out on left
                        leftMax = height[left];
                    } else { // left wall exists
                        trappedWater += leftMax - height[left];
                    }
                    left++;
                } else { // left side wall exists
                    if (height[right] >= rightMax) { // water will flow out on right
                        rightMax = height[right];
                    } else { // right wall exists
                        trappedWater += rightMax - height[right];
                    }
                    right--;
                }
            }
            return trappedWater;
        }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update left max
                } else {
                    totalWater += leftMax - height[left];  // Water is trapped
                }
                left++;
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update right max
                } else {
                    totalWater += rightMax - height[right];  // Water is trapped
                }
                right--;
            }
        }

        return totalWater;
    }


}
