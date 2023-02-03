package com.imos.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BasicJava8Stream {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alok", "Ranjan", "Meher", "Pintu", "alok", "ranJan", "mEHEr");

        names.forEach(System.out::println);
        System.out.println();

        System.out.println(names.stream().filter(name -> name.length() > 4).count());
        System.out.println();

        names.stream().filter(name -> !name.isEmpty()).map(String::toUpperCase).forEach(System.out::println);
        System.out.println();

        names.stream().map(String::length).filter(length -> length > 4).forEach(System.out::println);
        System.out.println();

        names.stream().map(String::toLowerCase).filter("alok"::equals).findFirst().ifPresent(System.out::println);
        System.out.println();

        names.stream().map(String::toLowerCase).filter("alok"::equals).forEach(System.out::println);
        System.out.println();

        names.stream().map(String::toLowerCase).filter("alok"::equals).findAny().ifPresent(System.out::println);
        System.out.println();

        System.out.println(names.stream().map(String::toLowerCase).anyMatch("alok"::equals));
        System.out.println();

        System.out.println(names.stream().map(String::toLowerCase).allMatch("alok"::equals));
        System.out.println();

        names.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
        System.out.println();

        names.stream().min(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
        System.out.println();

        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .flatMap(name -> name.chars().boxed())
                .map(value -> (char) value.intValue())
                .collect(Collectors.groupingBy(character -> character))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()))
                .forEach((value, size) -> System.out.println(value + " : " + size));
        System.out.println();

        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .flatMap(name -> name.chars().mapToObj(value -> (char) value))
                .collect(Collectors.toMap(value -> value, value -> 1, Integer::sum, TreeMap::new))
                .forEach((value, size) -> System.out.println(value + " : " + size));
        System.out.println();

        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toMap(value -> value, String::length, (size1, size2) -> size1, TreeMap::new))
                .forEach((value, size) -> System.out.println(value + " : " + size));
        System.out.println();

        System.out.println(names.stream().collect(Collectors.joining(",")));
        System.out.println();

        System.out.println(names.stream().collect(Collectors.joining(",", "\"", "\"")));
        System.out.println();
    }
}
