package com.example.utils;

import com.example.entity.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Scribble {

    static {
        System.out.println("Static block called");
    }

    {
        System.out.println("Instance block called");
    }

    public Scribble() {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> pipeline = numbers
                .stream()
                .filter(n -> n%2==0)
                .map(n -> n*2)
                .sorted()
                .distinct()
                .toList();

        pipeline.forEach(System.out::println);

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println(result);

        List<Person> persons = Arrays.asList(
                new Person("Alice","New York", 85),
                new Person("Bob",  "Los Angeles", 75),
                new Person("Charlie", "New York", 90),
                new Person("David", "Chicago", 65),
                new Person("Eve", "Los Angeles", 95)
        );

        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 75);
        studentScores.put("Charlie", 90);
        studentScores.put("David", 65);
        studentScores.put("Eve", 95);

        Map<String, List<Person>> personsByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::address));

        // Print the grouped result
        personsByCity.forEach((city, personList) -> {
            System.out.println("City: " + city);
            personList.forEach(person -> System.out.println("  " + person));
        });

        // Partitioning persons by age
        Map<Boolean, List<Person>> partitionedByAge = persons.stream()
                .collect(Collectors.partitioningBy(person -> person.age() >= 70));

        List<String> filteredAndFormatted = studentScores.entrySet().stream()
                .filter(entry -> entry.getValue() > 80)
                .map(entry -> "Student:" + entry.getKey() + " Score:" + entry.getValue()) // Transform to formatted strings
                .toList();
        filteredAndFormatted.forEach(System.out::println);

        Map<String, Integer> filteredMap = studentScores.entrySet().stream()
                .filter(entry -> entry.getValue() > 80)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filteredMap.forEach((key, value) -> System.out.println(key + ": " + value));

        // Joining person names into a single string separated by commas
        String names = persons.stream()
                .map(Person::name)
                .collect(Collectors.joining(", "));

        // Second-highest age
        Set<String> uniqueNames = persons.stream()
                .map(Person::address)
                .collect(Collectors.toSet());

        Optional<Person> p = persons.stream().sorted(Comparator.comparing(Person::age).reversed()).skip(1).findFirst();
        p.ifPresentOrElse(System.out::println, () -> System.out.println("Not enough elements"));

    }
}
