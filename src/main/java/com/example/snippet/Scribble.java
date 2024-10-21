package com.example.snippet;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Scribble {
    public static void main(String[] args) {

        List<City> list = Arrays.asList(
                new City("aa", 100),
                new City("bb", 200),
                new City("cc", 300),
                new City("cc", 400),
                new City("aa", 250)
        );

        Optional<City> emp = list.stream()
                .filter(e -> e.population() > 200)
                .sorted(Comparator.comparingDouble(City::population).reversed())
                .skip(1)
                .findFirst();
        log.info("emp => " + emp);

        Map<String, List<City>> map = list.stream().collect(Collectors.groupingBy(City::name));
        log.info("\n\nmap => " + map);

        Map<Boolean,List<City>> partitions = list.stream().collect(Collectors.partitioningBy(e -> e.population() < 250));
        log.info("\n\npartitions => " + partitions);
    }
}