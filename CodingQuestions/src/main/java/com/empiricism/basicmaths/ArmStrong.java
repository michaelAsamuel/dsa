package com.empiricism.basicmaths;

public class ArmStrong {

    public static void main(String[] args) {
        System.out.println( checkArmstrong(371));
        System.out.println( checkArmstrong(31));
    }

    static boolean checkArmstrong(int num){
        int result =0;
        int num1=num;
        while(num1>0){
            result += Math.pow(num1%10,3);
            num1 = num1/10;
        }
        return result == num;
    }
}
