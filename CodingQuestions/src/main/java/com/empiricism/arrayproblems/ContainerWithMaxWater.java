package com.empiricism.arrayproblems;
//https://leetcode.com/problems/string-compression/description/
public class ContainerWithMaxWater {
    public int maxArea(int[] height) {

        int left = 0;                      // Start from the left end
        int right = height.length - 1;     // Start from the right end
        int maxArea = 0;

        while (left < right) {
            // Calculate the current area
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            // Update max area if current is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;    // Try to find a taller line on the left
            } else {
                right--;   // Try to find a taller line on the right
            }
        }

        return maxArea;

    }
}
