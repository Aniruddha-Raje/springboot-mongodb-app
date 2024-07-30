package com.example.utils;

import lombok.Getter;
import java.util.*;
import java.util.stream.Collectors;

public class Scribble {
    public static void main(String[] args) {

        List<Emp> list = Arrays.asList(
                new Emp("aa", 100),
                new Emp("bb", 200),
                new Emp("cc", 300)
        );

        Optional<Emp> emp = list.stream()
                .filter(e -> e.getSal() > 100)
                .sorted(Comparator.comparingDouble(Emp::getSal).reversed())
                .skip(1)
                .findFirst();

        Map<String, List<Emp>> map = list.stream().collect(Collectors.groupingBy(e -> e.getName()));

        Map<Boolean,List<Emp>> partitions = list.stream().collect(Collectors.partitioningBy(e -> e.getSal() < 200));

    }
}

@Getter
class Emp {
    String name;
    int sal;

    public Emp(String name, Integer sal) {
        this.name = name;
        this.sal = sal;
    }
}