package com.imos.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BasicJava8Time {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        System.out.println();
        Period period = Period.between(LocalDate.now(), LocalDate.now().plusWeeks(5));
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
        System.out.println(period.get(ChronoUnit.DAYS));
        System.out.println(period.get(ChronoUnit.MONTHS));
        System.out.println(period.get(ChronoUnit.YEARS));
//        System.out.println(period.get(ChronoUnit.DECADES));
//        System.out.println(period.get(ChronoUnit.HALF_DAYS));
//        System.out.println(period.get(ChronoUnit.HOURS));
//        System.out.println(period.get(ChronoUnit.WEEKS));
        System.out.println();
        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(25));
        System.out.println(duration.toNanos());
        System.out.println(duration.toMillis());
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(duration.toDays());
    }
}
