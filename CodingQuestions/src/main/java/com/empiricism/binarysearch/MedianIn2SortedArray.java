package com.empiricism.binarysearch;

public class MedianIn2SortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low =0;
        int high = x;


        while( low <= high){
            int midX =     ( low + high) / 2;
            int midY = (x+y+1) /2  - midX;

            // Computing maxleft and min right
            // maxLeftX = nums1[midX-1];
            // minRightX = nums1[midX];
            int maxLeftX = (midX==0)? Integer.MIN_VALUE:  nums1[midX-1];
            int minRightX = (midX== x)? Integer.MAX_VALUE: nums1[midX];

            int maxLeftY = (midY==0)? Integer.MIN_VALUE: nums2[midY-1];
            int minRightY =  (midY== y)? Integer.MAX_VALUE: nums2[midY];

            if(maxLeftX <= minRightY && maxLeftY < minRightX){ // correct success
                if((x+y)%2 ==0){
                    return (double) (Math.max(maxLeftY , maxLeftX) + Math.min(minRightX, minRightY))/2;
                }else{
                    return (double) Math.max(maxLeftX, maxLeftY);

                }


            }else if (maxLeftX > minRightY){
                high = midX -1;

            } else {
                low = midX +1;
            }




        }
        return -1;


    }

    public static double findMedianSortedArrays2Pomiter(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int mid1 = (total - 1) / 2;
        int mid2 = total / 2;

        int i = 0, j = 0, count = 0;
        int curr = 0, prev = 0;

        while (count <= mid2) {
            prev = curr;
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
            count++;
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }

}
