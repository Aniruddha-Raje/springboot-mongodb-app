package com.example.utils;

import com.example.entity.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Scribble {

    private static final System.Logger logger = System.getLogger(Scribble.class.getName());

    static {
        System.out.println("Static block called");
    }

    {
        System.out.println("Instance block called");
    }

    Scribble() {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Alice","New York", 85),
                new Person("Bob",  "Los Angeles", 75),
                new Person("Charlie", "New York", 90),
                new Person("David", "Chicago", 65),
                new Person("Eve", "Los Angeles", 95)
        );

        //GroupBy address
        Map<String, List<Person>> personsByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::address));

        // Print the grouped result
        personsByCity.forEach((city, personList) -> {
            System.out.println("City: " + city);
            personList.forEach(person -> System.out.println("  " + person));
        });

        // partitioningBy - returns Map
        Map<Boolean, List<Person>> partitionedByAge = persons.stream()
                .collect(Collectors.partitioningBy(person -> person.age() >= 70));

        //Formatting
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 75);
        studentScores.put("Charlie", 90);
        studentScores.put("David", 65);
        studentScores.put("Eve", 95);

        List<String> filteredAndFormatted = studentScores.entrySet().stream()
                .filter(entry -> entry.getValue() > 80)
                .map(entry -> "Student:" + entry.getKey() + " Score:" + entry.getValue())
                .toList();
        filteredAndFormatted.forEach(System.out::println);

        Map<String, Integer> filteredMap = studentScores.entrySet().stream()
                .filter(entry -> entry.getValue() > 80)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filteredMap.forEach((key, value) -> System.out.println(key + ": " + value));

        // Joining person names into a single string separated by commas
        String names = persons.stream()
                .map(e -> e.name())
                .collect(Collectors.joining(", "));

        // Second-highest age
        Set<String> uniqueNames = persons.stream()
                .map(Person::address)
                .collect(Collectors.toSet());

        Optional<Person> p = persons.stream().sorted(Comparator.comparing(Person::age).reversed()).skip(1).findFirst();
        p.ifPresentOrElse(System.out::println, () -> System.out.println("Not enough elements"));

    }
}
