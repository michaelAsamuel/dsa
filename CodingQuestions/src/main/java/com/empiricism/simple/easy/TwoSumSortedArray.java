package com.empiricism.simple.easy;

public class TwoSumSortedArray {

//    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left+1, right+1};
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[2];

    }
}
