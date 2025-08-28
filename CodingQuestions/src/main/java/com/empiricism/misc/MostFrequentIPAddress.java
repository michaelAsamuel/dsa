package com.empiricism.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostFrequentIPAddress {
    public static void main(String[] args) {
        String[] logs =new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-20"};
        String[] logs1 =new String[]{"10.0.0.127 - GET 2020-08-24", "10.0.0.10 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-20"};
        System.out.println(getMostFrequent(logs));
        System.out.println(getMostFrequent(logs1));
    }

    public static String getMostFrequent(String[] logs) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : logs) {
            String[] ip = s.split(" ");
            freqMap.put(ip[0], freqMap.getOrDefault(ip[0],0)+1);
        }
        int maxCount=0;
        String result = "";
        for(Map.Entry<String, Integer> e : freqMap.entrySet()){
            if(e.getValue()> maxCount){
                result=e.getKey();
                maxCount=e.getValue();
            }else if(e.getValue() == maxCount){
                result=result+","+e.getKey();
            }
        }
        return result;
    }

//    public static String getMostFrequent(String[] logs)
//    {
//        int count =0;
//        String res="";
//        HashMap<String ,Integer> map = new HashMap<>();
//        for(String val:logs)
//        {
//            String arr[]=val.split("- GET");
//            map.put(arr[0], map.get(arr[0]) ==null?1:map.get(arr[0])+1);
//        }
//
//        Set<String> se=new HashSet<>();
//        for(String val:logs)
//        {
//            String arr[]=val.split("- GET");
//            if(se.add(arr[0])){
//                if(map.get(arr[0])>=count)
//                {
//                    count=map.get(arr[0]);
//                    res=res +arr[0] +" ";
//                }
//            }
//
//
//        }
//        return res;
//    }

}
