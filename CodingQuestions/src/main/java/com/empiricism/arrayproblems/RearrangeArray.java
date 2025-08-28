package com.empiricism.arrayproblems;

public class RearrangeArray {
    static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(rearrangeArray(new int[]{3,1,-2,-5,2,-4}));
    }

}
