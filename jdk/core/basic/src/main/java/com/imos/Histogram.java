package com.imos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAdder;

public class Histogram {

    public static void main(String[] args) {
        Map<String, LongAdder> nameHistogramMap = new TreeMap<>();
        List<String> names = Arrays.asList("Alok", "alok", "Ranjan", "ranJAN", "alOK");
        names.forEach(name -> {
            nameHistogramMap.computeIfPresent(name.toLowerCase(), (s, longAdder) -> {
                longAdder.increment();
                return longAdder;
            });
            nameHistogramMap.computeIfAbsent(name.toLowerCase(), s -> {
                LongAdder longAdder = new LongAdder();
                longAdder.increment();
                return longAdder;
            });
        });

        nameHistogramMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
