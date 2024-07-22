package com.example.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "olleh";

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean areAnagram = Arrays.equals(arr1, arr2);
    }
}
