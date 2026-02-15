package com.empiricism;

import java.util.HashMap;
import java.util.Map;

public class scratch {
    public static void main(String[] args) {
        String[][] input = {
                {"Alice", "Maths", "90"},
                {"Bob", "Maths", "85"},
                {"Alice", "English", "95"},
                {"Charlie", "Maths", "78"},
                {"Bob", "English", "80"},
                {"Charlie", "English", "82"},
                {"Bob", "Physics", "80"}
        };
        Map<String, Integer> tmp = new HashMap<>();
        tmp.put("ram", 20000);
        tmp.put("ram", 30000);
        tmp.put("shyam", 30000);
        System.out.println(tmp.get("ram"));
        System.out.println(tmp.get("shyam"));
    }
}
