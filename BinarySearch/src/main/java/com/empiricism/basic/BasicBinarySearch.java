package com.empiricism.basic;

public class BasicBinarySearch {

    public static void main(String[] args){
        int[] intArray = { 1,2,3,5,7,9,11,20};
        System.out.println(binarySearch(intArray, 7));
        System.out.println(binarySearch(intArray, 6));

        System.out.println(binarySearch(intArray, 0));
        System.out.println(binarySearch(intArray, 1));
        System.out.println(binarySearch(intArray, 20));
        System.out.println(binarySearch(intArray, 21));
    }



    // sorted Array
    public static int binarySearch(int[] numbers, int target){
        int low=0;
        int high = numbers.length -1;

        while(low <= high){
            // Binary search
            int midIndex = (low + high) /2;
            int midNumber = numbers[midIndex];

            // Validate condition
            if( target == midNumber){
                return midIndex;
            } else if (target > midNumber) {    // Adjust for binary search
                low = midIndex+1;
            }else{
                high = midIndex-1;
            }
        }
        return -1;
    }

}

