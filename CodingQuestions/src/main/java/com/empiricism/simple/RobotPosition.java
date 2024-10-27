package com.empiricism.simple;

import java.util.Arrays;

public class RobotPosition {
    public static void main(String[] args) {
        System.out.println("::::: "+transformInstruction2("DOWN UP 12xRIGHT DOWN 3xLEFT"));
        System.out.println(Arrays.toString(getCoordinates("U, R, D, L", new int[]{0, 0})));
        System.out.println(Arrays.toString(getCoordinates("u, u, u", new int[]{0, 0})));
    }

    public static int[] getCoordinates(String s, int[] xy){
        char[] instructions= s.toLowerCase().toCharArray();
        int x=xy[0];
        int y=xy[1];
        for(char c: instructions){
            if(c =='u') y++;
            if(c =='d') y--;
            if(c =='l') x--;
            if(c == 'r') x++;
        }
        return new int[]{x,y};
    }
    private static String transformInstruction(String s){
        String[] input = s.split("\\s");
        StringBuilder output = new StringBuilder();
        char temp ='0';
        for(String s1: input){
            System.out.println(s1);
            int cnt = 0;

            if(Character.isDigit(s1.charAt(0))){
                cnt= s1.charAt(0) -'0';
                System.out.println(cnt);
                temp=s1.charAt(2);
                while(cnt > 0){
                    output.append(s1.charAt(2));
                    cnt--;
                }
            }else{
                cnt =0;
                temp=s1.charAt(0);
                output.append(s1.charAt(0));

            }


        }
        return output.toString().toLowerCase();

    }
    private static String transformInstruction2(String s){
        String[] input = s.split("\\s");
        StringBuilder output = new StringBuilder();
        char temp ='0';
        for(String s1: input){
            System.out.println(s1);
            int cnt = 0;
            if(s1.contains("x")){
                String cnts = s1.substring(0, s1.indexOf("x"));
                 cnt = Integer.valueOf(cnts);
                System.out.println(cnt);
                temp=s1.charAt(2);
                while(cnt > 0){
                    output.append(s1.charAt(s1.indexOf("x")+1));
                    cnt--;
                }
            }else{
                cnt =0;
                temp=s1.charAt(0);
                output.append(s1.charAt(0));

            }


        }
        return output.toString().toLowerCase();

    }


}
