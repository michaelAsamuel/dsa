package com.empiricism.simple.easy.gs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 8, 7, 4};
        System.out.println( getMissingNumber(arr) );
    }

//    private static void getMissingNumber(int[] arr) {
//
//        //5 is missing element
//        int size= arr.length+1;
//        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        //convert the array into list
//        Integer sumOfArray = collect.stream().reduce((x, y) -> x + y).get();
//        int expectedSum= (size*(size+1))/2;
//        //total consucative sum
//        int missingEle= expectedSum-sumOfArray;
//        System.out.println("missing element is"+" "+missingEle);
//    }


     static int getMissingNumber(int[] arr) {
        int arrSum = 0, minNo=Integer.MAX_VALUE; //Arrays.stream(arr).sum();
        int n = arr.length+1 ;

        for(int i:arr){
            minNo=Math.min(minNo,i);
            arrSum+=i;
        }
        int expSum= (n*(n+1))/2;
         System.out.println(expSum);
        return arrSum - expSum;
    }

}




