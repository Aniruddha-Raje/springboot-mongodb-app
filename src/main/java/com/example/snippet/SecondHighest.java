package com.example.snippet;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Getter
class Employee implements Comparable<Employee> {
    private final String name;
    private final int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override public int compareTo(Employee e) {
        //return Integer.compare(this.salary, e.salary);
        return name.compareTo(e.getName());
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

        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst();

        Employee secondHighestSalaryEmployee = employees.stream()
                //.sorted((s1, s2) -> s2.getSalary() - s1.getSalary())
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed())
                .skip(1)
                .findFirst()
                .orElse(null);

        if (secondHighestSalaryEmployee != null) {
            log.info("Employee with the second highest salary:" + secondHighestSalaryEmployee);
        } else {
            log.info("No employee found.");
        }

        //old way
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });

        //new way
        List<Employee> l = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).toList();
        System.out.println(l);

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 30);
        map.put("orange", 20);

        Map<String, Integer> sortedMap = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, // Merge function in case of key collision
                    LinkedHashMap::new // Maintain insertion order
            ));

        System.out.println("\nAfter sorting by value:");
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
