package com.example.snippet;

import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        // Example 1: Function<T, R> - takes one argument of type T, returns a result of type R
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));

        // Example 2: Consumer<T> - takes one argument of type T, returns void (used for operations with side effects)
        Consumer<String> printString = str -> System.out.println("Consumed: " + str);
        printString.accept("Hello, Consumer!");

        // Example 3: Predicate<T> - takes one argument of type T, returns boolean (for conditional checks)
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // Example 4: Supplier<T> - takes no arguments, returns a result of type T
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());

        // Example 5: UnaryOperator<T> - a specialized Function where input and output types are the same
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // Example 6: BinaryOperator<T> - a specialized BiFunction where input and output types are the same
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Product of 5 and 3: " + multiply.apply(5, 3));

        // Example 7: BiFunction<T, U, R> - takes two arguments of types T and U, returns a result of type R
        BiFunction<Integer, Integer, String> sumString = (a, b) -> "Sum is " + (a + b);
        System.out.println(sumString.apply(5, 3));

        // Example 8: BiConsumer<T, U> - takes two arguments of types T and U, returns void
        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println(name + " is " + age + " years old.");
        printNameAndAge.accept("Alice", 30);

        // Example 9: BiPredicate<T, U> - takes two arguments of types T and U, returns boolean
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println("Is the sum of 5 and 3 even? " + isSumEven.test(5, 3));
    }
}
