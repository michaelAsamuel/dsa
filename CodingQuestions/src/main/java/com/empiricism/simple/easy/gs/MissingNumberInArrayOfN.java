package com.empiricism.simple.easy.gs;
//Find the missing integer in an array of size n
//ex : arr=[1,3,2,6,8,7,4] and n=8
public class MissingNumberInArrayOfN {
    public static void main(String[] args) {
        int[] input = {1,3,2,6,8,7,4};
        System.out.println("Method 1: "+getMissing(input, 8));
        System.out.println(getMissingBySum(input, 8));
    }

    public static int getMissing(int[] input, int asize){
        Integer[] temp = new Integer[asize];
        int min = input[0];

        for(int i=0; i < input.length; i++){
            min = Math.min(min, input[i]);
        }
        int missing =min;

        for(int i=0; i < input.length; i++){
            temp[input[i] - min] = 1;
        }
        for(int i=0; i < input.length; i++){
            if(temp[i] == null || temp[i] != 1) {
                missing = i + min;
            }
        }
        return missing;
    }

    public static int getMissingBySum(int[] input, int asize){
        int sum =0;
        for(int i=0; i < input.length; i++){
            sum += input[i];
        }
        return (asize* (1+asize)/2)-sum;

    }



}
