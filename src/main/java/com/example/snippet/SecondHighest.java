package com.example.snippet;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
class Employee {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

@Slf4j
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
            log.info("Employee with the second highest salary:" + secondHighestSalaryEmployee);
        } else {
            log.info("No employee found.");
        }
    }
}
