package com.example.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class SecondHighest {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 80000));
        employees.add(new Employee("Bob", 75000));
        employees.add(new Employee("Charlie", 90000));
        employees.add(new Employee("David", 72000));
        employees.add(new Employee("Eve", 95000));

        Employee secondHighestSalaryEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);

        if (secondHighestSalaryEmployee != null) {
            System.out.println("Employee with the second highest salary:" + secondHighestSalaryEmployee);
        } else {
            System.out.println("No employee found.");
        }
    }
}
