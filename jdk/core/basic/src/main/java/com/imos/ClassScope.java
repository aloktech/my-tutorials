package com.imos;

public class ClassScope {

    int num = 10;

    public static void main(String[] args) throws InterruptedException {
        new ClassScope().test();
    }

    public void test() throws InterruptedException {
        int num = 15;
        Runnable runnable = new Runnable() {
            int num = 20;

            @Override
            public void run() {
                int num = 30;
                System.out.println(this.num);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
    }
}
