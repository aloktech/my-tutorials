package com.imos;

public class ThreadClass {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("The statement is executed in inner Thread");
                System.out.println("The inner Thread Name: " + Thread.currentThread().getName());
            }
        };

        System.out.println("The statement is executed in outer Thread");
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("The outer Thread Name: " +Thread.currentThread().getName());
        thread.join();

    }
}
