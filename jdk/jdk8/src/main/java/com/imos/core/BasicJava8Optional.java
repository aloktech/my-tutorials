package com.imos.core;

import java.util.Optional;

public class BasicJava8Optional {

    public static void main(String[] args) {

        Optional.of("Alok").ifPresent(System.out::println);
        Optional.of("Alok").map(String::toLowerCase).filter("alok"::equals).ifPresent(System.out::println);
        System.out.println(Optional.of("Alok").map(String::toUpperCase).filter("ALOK"::equals).orElse(null));
        System.out.println(Optional.of("Alok").map(String::toUpperCase).filter("alok"::equals).orElse(null));
        System.out.println(Optional.of("Alok")
                .flatMap(name -> name.chars().boxed().filter(value -> value == 65).findFirst())
                .map(value -> (char) value.intValue()).orElse(null));
    }
}
