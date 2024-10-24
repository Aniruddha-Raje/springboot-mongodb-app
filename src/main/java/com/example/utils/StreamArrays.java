package com.example.utils;

import java.util.*;

public class StreamArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,4,6,5);

        List<Integer> unique = list.stream().distinct().toList();

        int sumOfAll = list.stream().reduce(0,(sum, current) -> sum + current);

        List<Integer> evenNumbers = list.stream().filter(current -> current %2 == 0).toList();

        List<Integer> numberSquare = list.stream().map(current -> current*2).toList();

        Optional<Integer> secondHigest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        OptionalInt max = list.stream().mapToInt(num -> num).max();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> pipeline = numbers
                .stream()
                .filter(n -> n%2==0)
                .map(n -> n*2)
                .sorted()
                .distinct()
                .toList();

        pipeline.forEach(System.out::println);

    }
}
