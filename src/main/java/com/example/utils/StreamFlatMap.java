package com.example.utils;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream()) // Flattening step
                .toList();

        System.out.println("Flattened list: " + flattenedList);
        // Prints: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
