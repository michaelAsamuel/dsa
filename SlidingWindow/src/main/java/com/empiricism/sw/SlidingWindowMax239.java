package com.empiricism.sw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax239 {

    public static void main(String[] args){
        int[] inputs = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(getSlidingWindowMax(inputs, 3)));
    }

    public static int[] getSlidingWindowMax(int[] input, int k){
        // Queue to hold candidate values
        Deque<Integer> candidates = new ArrayDeque<>();
        // List to hold answer
        int[] ans = new int[input.length -k +1];
        int currentIndex = 0;
        for(int i =0; i < input.length; i++){
            // remove indexes not in window
            if(!candidates.isEmpty() && candidates.peek() == i -k){
                candidates.poll();

            }


            // Remove values that are less than current Value from tail
            while(!candidates.isEmpty() && input[candidates.peekLast()] < input[i]){
                candidates.pollLast();
            }

            // Add candidate
            candidates.offer(i);

            // Update answer
            if(i >= k -1){
                ans[currentIndex++] =input[candidates.peek()];
            }

        }


        return ans;
    }
}
