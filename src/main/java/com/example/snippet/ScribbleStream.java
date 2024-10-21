package com.example.snippet;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ScribbleStream {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,3,5,2,7,6);

        Set<Integer> set =  list.stream().filter(e -> e > 2).map(e -> e*2).collect(Collectors.toSet());
        log.info("set => " + set.toString());

    }
}
