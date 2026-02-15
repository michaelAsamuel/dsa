package com.empiricism.slidwin;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[]{1,2,1}));
//        System.out.println(totalFruit(new int[]{1,1,2,3,2,2}));
//        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));




    }
    static int totalFruit(int[] fruits) {

        int start=0, end =0, maxFruit=0, currCount=0;
        Map<Integer, Integer> count = new HashMap();
        Integer size =0;
        for(int i=0; i<fruits.length; i++){
            if(count.containsKey(fruits[i])) {
                count.put(fruits[i], count.get(fruits[i]) +1);
                currCount++;
                maxFruit= Math.max(maxFruit,currCount);
            }
            else if(count.size()<2) {
                count.put(fruits[i], 1);
                currCount++;
                maxFruit= Math.max(maxFruit,currCount);
            }
            else {

                while(count.size() ==2) {
                    size = count.put(fruits[start], count.get(fruits[start]) -1);
                    if(count.get(fruits[start])==0)
                        count.remove(fruits[start]);

                    currCount--;
                    start++;

                }
                count.put(fruits[i], 1);
                currCount++;
                maxFruit= Math.max(maxFruit,currCount);
            }
        }
        return Math.max(maxFruit,currCount);

    }
}
