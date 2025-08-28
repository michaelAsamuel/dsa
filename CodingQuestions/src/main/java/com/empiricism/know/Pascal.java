package com.empiricism.know;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {
    public static void main(String[] args) {
        //printPascalTriangle(6);
        //System.out.println(Arrays.toString(getNextRow( new int[]{1,2,1})));
        //printPascal(8);
        System.out.println( generate(5));
    }


    public static void printPascalTriangle(int num){
        int spaces = num;
        int k =1;
        for(int i=0; i <num; i++){
            for(int s=1 ; s< spaces; s++){
                System.out.print(" ");
            }
            k=1;
            for(int j=1; j<=i; j++){
                System.out.print(k + " ");
                k=k * (i-j)/(j);
            }
            spaces--;
            System.out.println();
        }
    }

    public static void printPascal(int n){
        int[] input = new int[]{1};
        int[] result;
        System.out.println( Arrays.toString(input));
        for(int i=1 ; i< n; i++){
            input = getNextRow(input);
            System.out.println( Arrays.toString(input));
        }

    }

    public static int[] getNextRow(int[] prev){
        int[] result = new int[prev.length+1];
        for(int i=0; i< result.length; i++){
            if(i==0){
                result[i] = prev[0];
            }else if(i== result.length -1){
                result[i] = prev[prev.length-1];
            }else{
                result[i] = prev[i-1] + prev[i];
            }

        }
        return result;

    }

    public static List<Integer> getNextList(List<Integer> prev){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<= prev.size(); i++){
            if(i==0 || i== prev.size()){
                result.add(1);
            }else{
                result.add( prev.get(i-1) + prev.get(i));
            }
        }
        return result;

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int input = numRows;
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        result.add(currRow);

        for(int i=1 ; i< numRows; i++){
            result.add(getNextList(result.get(i-1)));
        }
        return result;

    }



}
