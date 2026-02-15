package com.empiricism.stream;

import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
//
//class Employee {
//    int id;
//    String name;
//    String department;
//    double salary;
//
//    public Employee(int id, String name, String department, double salary) {
//        this.id = id;
//        this.name = name;
//        this.department = department;
//        this.salary = salary;
//    }
//
//    String getDepartment(){
//        return this.department;
//    }
//
//    double getSalary(){
//        return this.salary;
//    }
//
//    String getName(){
//        return name;
//    }
//    @Override
//    public String toString() {
//        return name + " (" + salary + ")";
//    }
//}
class Employee1 {
    private String name;
    private String department;
    private int salary;

    public Employee1(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }
}

public class StreamExample1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee( "Alice", "HR", 5000),
                new Employee( "Bob", "IT", 7000),
                new Employee( "Charlie", "Finance", 6000),
                new Employee( "David", "HR", 4000),
                new Employee( "Eve", "IT", 8000),
                new Employee( "Frank", "Finance", 5500)
        );

        // 1. Find the employee with the highest salary in each department
        Map<String, Employee> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get
                        )
                ));

        System.out.println("1. Highest Salary in Each Department:");
        highestSalaryByDept.forEach((dept, emp) ->
                System.out.println(dept + ": " + emp.getName() + " (" + emp.getSalary() + ")"));

        // 2. Calculate the average salary of employees
        double averageSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("\n2. Average Salary: " + averageSalary);

        // 3. List employees earning above average salary, sorted by salary (descending)
        List<String> aboveAverageEmployees = employees.stream()
                .filter(emp -> emp.getSalary() > averageSalary)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\n3. Employees Above Average Salary:");
        aboveAverageEmployees.forEach(System.out::println);

        // 4. Group employees by department
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\n4. Employees Grouped by Department:");
        employeesByDept.forEach((dept, emps) ->
                System.out.println(dept + ": " + emps));

        //5. Max Salary
        System.out.println(
        employees.stream().mapToDouble(Employee::getSalary).max().orElse(0)
        );
        System.out.println(
                employees.stream().
                        max(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary).
                        orElse(0)
        );

    }
}

