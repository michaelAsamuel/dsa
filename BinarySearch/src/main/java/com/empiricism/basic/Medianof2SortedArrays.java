package com.empiricism.basic;



public class Medianof2SortedArrays {

    public static void main(String[] args){
        int[] num1 = {1,3,};
        int[] num2 ={2,5,6};
//        int[] num1 = {1,3};
//        int[] num2 ={2};
//        int[] num1 = {1,2};
//        int[] num2 ={};
//        int[]  num1 = {1,2};
//        int[] num2 = {3,4};

//        int[]  num1 = {1,2, 5, 7, 9, 11, 15};
//        int[] num2 = {3,4,6, 8, 9,11, 12};
        System.out.println(solveWithBasicBinarySearch(num1, num2 ));

    }


    // Observation: Constraint-> Median = index of s1 + index of s2
    // Edge cases All Elements from 1 Array balance from other
    public static double solveWithBasicBinarySearch(int[] s1, int[] s2){

        if(s1.length < s2.length){
            return medianHelper(s1 , s2);
        }else{
            return medianHelper( s2 , s1);
        }
    }

    private static double medianHelper(int[] small, int[] large){



        //Edge case where all are from 1 array

        int low = 0;
        int high =small.length-1;
        int mid1 = (low + high)/2;

        // id combimed length is an odd take the middle.

        // Median and corresponding mid of second array
        int median = ((small.length + large.length)/2) +1;
        int mid2 = median - mid1-1;
        // for even: sum middle two and div by 2
        boolean isEven = ((small.length + large.length)%2 ==0);

        /*++
        1. Either mid1 or mid2 be the largest number on the left side of the median
        2. It follows that either mid+1 or mid2+1 will be the smallest on the right side of the median
        3. We have selected the correct mid point value when the largest element on left of median is less than the smallest element on right
         */

        int left1 =0, right1=0, left2=0, right2=0;

        while( low <= high ){
            mid1 = (low + high)/2;
            mid2 = median - mid1 -2;


            left1 = (small[mid1]);
            right1 = (mid1 == small.length-1 ? Integer.MAX_VALUE : small[mid1 +1]);

            left2 = (large[mid2]);
            right2 = (mid2 == large.length -1 ? Integer.MAX_VALUE : large[mid2 +1]);

            if(Math.max(left2, left1) <= Math.min(right2, right1)) {
                // We have found the median
                // Median calculated outside loop
                break;
            }else if(left1 > right2){
                high = mid1 -1;
            }else{
                low = mid1 +1;
            }


        }

        System.out.println(Math.max(left2, left1));
        System.out.println(Math.min(right2, right1));
        if((small.length + large.length)%2 ==1){
            return (double) Math.max(left2, left1);
        }else{
            double max = Math.max(left2, left1);
            double left3 = 0.00;
            if(left2> left1){
                left3 = Math.max (left1,(mid2-1 <= 0 ? Integer.MIN_VALUE : large[mid2-1]));
            }else{
                left3 = Math.max(left2, (mid1-1 <= 0 ? Integer.MIN_VALUE : small[mid1-1]));

            }
            return (double) (max + left3)/2;
        }

    }

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Ensure nums1 is the smaller array for binary search on smaller size
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int x = nums1.length;
            int y = nums2.length;

            int low = 0, high = x;           while (low <= high) {

                // Binary search is being performed on smaller array
                int partitionX = (low + high) / 2;

                // No of elements in partitionY = Median - no of elements in partition x
                int partitionY = (x + y + 1) / 2 - partitionX;

                // Same condition as in Binary search edge case handling if entire array is on left or right of median
                int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

                int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

                // Success condition
                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                    // Check Odd/even and calculate
                    if ((x + y) % 2 == 0) {
                        return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                    } else {
                        return (double)Math.max(maxLeftX, maxLeftY);
                    }
                } else if (maxLeftX > minRightY) {  // adjust for binary search
                    high = partitionX - 1; // move left
                } else {
                    low = partitionX + 1; // move right
                }
            }

            throw new IllegalArgumentException("Input arrays are not sorted.");
        }
    }



}


