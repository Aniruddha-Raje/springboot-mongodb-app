package com.example.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionHelpers {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of("foo", "one", "bar", "two");
    }
}
