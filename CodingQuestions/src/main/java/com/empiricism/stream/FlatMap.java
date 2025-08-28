package com.empiricism.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        simpleFaltten();
    }

    /*
    Takes a List of Lists and  flattens it
     */
    public static void simpleFaltten(){
        List<List<Integer>> input = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );

        // Using flatMap to flatten the list of lists into a single list
        List<Integer> flattenedList = input.stream()
                .flatMap(List::stream)  // Flattening each list
                .collect(Collectors.toList());  // Collecting into a List

        // Printing the flattened list
        System.out.println(flattenedList);
    }
}
