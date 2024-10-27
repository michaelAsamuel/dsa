package com.empiricism.review.debi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 8, 7, 4};
        getMissingNumber(arr);
    }

    private static void getMissingNumber(int[] arr) {

        //5 is missing element
        int size= arr.length+1;
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //convert the array into list
        Integer sumOfArray = collect.stream().reduce((x, y) -> x + y).get();
        int expectedSum= (size*(size+1))/2;
        //total consucative sum
        int missingEle= expectedSum-sumOfArray;
        System.out.println("missing element is"+" "+missingEle);
    }


}




