package com.empiricism.arrayproblems;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentWithHighestMarks {

    public static void main(String[] args) {
        String[][] input = {
                {"Alice", "90"}, {"Bob", "85"}, {"Alice", "95"},
                {"Charlie", "78"}, {"Bob", "80"}, {"Charlie", "82"}
        };

        System.out.println(getStudentWithHighestMarksUsingStreams(input));
        System.out.println(getStudentWithHighestMarks(input));
    }

    private static int getStudentWithHighestMarksUsingStreams(String[][] input) {
        // Convert the input array to a list of pairs (name, score)
        List<String[]> dataList = Arrays.asList(input);

        // Group the data by student name, then collect the scores as integers and compute the average
        Map<String, List<Integer>> groupedScores = dataList.stream()
                .collect(Collectors.groupingBy(
                        arr -> arr[0], // Group by student name
                        Collectors.mapping(
                                arr -> Integer.parseInt(arr[1]), // Convert scores to integers
                                Collectors.toList() // Collect the scores in a list
                        )
                ));

        // Find the student with the highest average score
        Optional<AbstractMap.SimpleEntry<String, Double>> topStudent = groupedScores.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(),
                        entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0) // Default to 0 if no scores exist
                ))
                .max(Comparator.comparingDouble(Map.Entry::getValue)); // Find the max based on the average

        // Round the average down and print it
        if (topStudent.isPresent()) {
            int roundedAverage = (int) Math.floor(topStudent.get().getValue());
            return roundedAverage;
        }else{
            return -1;
        }
    }

    private static int getStudentWithHighestMarks(String[][] input) {

    // Step 1: Store total scores and count of scores for each student
    Map<String, int[]> studentScores = new HashMap<>();

    for (String[] entry : input) {
        String name = entry[0];
        int score = Integer.parseInt(entry[1]);

        studentScores.putIfAbsent(name, new int[2]); // Initialize array with total and count

        studentScores.get(name)[0] += score;  // Add score to total
        studentScores.get(name)[1] += 1;      // Increment count
    }

    // Step 2: Calculate average and track the highest average
    int maxAverage = Integer.MIN_VALUE;

    for (Map.Entry<String, int[]> entry : studentScores.entrySet()) {
        int total = entry.getValue()[0];
        int count = entry.getValue()[1];

        // Calculate the average, rounded down (integer division will automatically floor the value)
        int average = total / count;

        // Track the maximum average
        maxAverage = Math.max(maxAverage, average);
    }

    // Step 3: Output the highest average
        return maxAverage;
}


}
