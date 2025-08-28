package com.empiricism.basic;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] input = { 1,2,3,4,5,6};
        System.out.println(getMedian(input));
        int[] input1 = { 1,2,3,4,5,6,7};
        System.out.println(getMedian(input1));
    }

    public static double getMedian(int[] input){
        int mid = input.length/2;
        if(input.length%2==0){
            // Gotcha: array count starts from 0
            return  ( (double) input[mid] + (double) input[mid-1])/2  ;
        }else{
            return input[mid];

        }


    }
}
