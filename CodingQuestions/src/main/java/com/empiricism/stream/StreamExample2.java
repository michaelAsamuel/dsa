package com.empiricism.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample2 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "IT", 65000)
        );

        Map<String, List<String>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println(result.toString());

    }
}
