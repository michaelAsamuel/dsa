package com.empiricism.sw;

public class baseAlgo {
    public static void main(String[] args){
        int[] input  = {1,2,3,4,5,6,7,8,9,11,12,31,44,22,20,55};
        System.out.println(slidingWindow(input,3));
        int[] input1  = {1,2,3,4,5,6};
        int[] input2  = {2,2,2};
        int[] input3  = {9,7,7,9,7,7,9};

//        System.out.println(getMaxCardPoints(input1, 3));
//        System.out.println(getMaxCardPoints(input2, 2));
//        System.out.println(getMaxCardPoints(input3, 7));


    }

    // Find max sum of k consecutive elements
    public static int slidingWindow(int[] elements, int k){
        int result=0;
        int windowSum=0;
        //1.  Get total of 1st window
        for(int i=0; i < k; i++){
            windowSum += elements[i];
            result = windowSum;
        }
        //2. for each new window compute the windowSum
        // 3. Replace result if window sum is higher
        for(int i =1; i< elements.length-k+1; i++){
            windowSum = windowSum - elements[i-1] + elements[i+k-1];
            if(windowSum > result)
                result = windowSum;

        }
        return result;
    }

    public static int getMaxCardPoints(int[] input, int noOfcards){
        int rightIndex =input.length -1;
        int leftIndex= noOfcards-1;
        int maxScore=0;
        int groupScore=0;
        for (int i=0; i < noOfcards; i++){
            groupScore += input[i];
        }
        maxScore=groupScore;
        for(int i=input.length-1; i > input.length - noOfcards-1; i--){
            groupScore =   groupScore - input[leftIndex] + input[rightIndex];
            leftIndex--;
            rightIndex--;
            if(groupScore > maxScore){
                maxScore=groupScore;
            }
        }

        return maxScore;
    }

}
