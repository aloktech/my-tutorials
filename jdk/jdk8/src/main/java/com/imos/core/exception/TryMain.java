package com.imos.core.exception;

public class TryMain {

    public static void main(String[] args) {

        System.out.println(Try.execute(() -> "Success").getValue());
        System.out.println(Try.execute(() -> {
            throw new Exception("");
        }).getValue());
    }
}
