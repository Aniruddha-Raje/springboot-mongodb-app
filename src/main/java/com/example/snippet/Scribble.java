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

        //without methods reference
        list.stream().collect(Collectors.groupingBy(city -> city.name()));

        //Both partitioningBy and groupingBy will return a Map
        Map<String, List<City>> map = list.stream().collect(Collectors.groupingBy(City::name));
        log.info("\n\nmap => " + map);

        Map<Boolean,List<City>> partitions = list.stream().collect(Collectors.partitioningBy(e -> e.population() < 250));
        log.info("\n\npartitions => " + partitions);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 1);
        map1.put("orange", 2);

        //old way
        for(Map.Entry<String,Integer> entry: map1.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //new way
        map1.forEach((key, value) -> {
            System.out.println("k => " + key + "v => " + value);
            System.out.println("better way");
        });

        Set<String> set =  new HashSet<>();
        set.add("apple");
        set.remove("orange");
        set.contains("apple");
    }
}