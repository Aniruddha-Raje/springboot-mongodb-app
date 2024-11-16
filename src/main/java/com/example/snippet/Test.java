package com.example.snippet;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<City> list = Arrays.asList(
                new City("aa", 100),
                new City("bb", 200),
                new City("cc", 300),
                new City("cc", 400),
                new City("aa", 250)
        );

        list.stream()
                .filter(city -> city.population() > 100)
                .sorted(Comparator.comparingInt((City::population)).reversed()).skip(1).findFirst();

        list.stream().collect(Collectors.groupingBy(City::name));

        list.stream().collect(Collectors.toMap(City::name, City::population));

        list.stream().distinct();

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("orange", 2);

        map.forEach((k,v) -> {

        });
    }
}
