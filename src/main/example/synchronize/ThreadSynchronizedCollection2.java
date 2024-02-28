package main.example.synchronize;

import java.util.ArrayList;

public class ThreadSynchronizedCollection2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            integers.add(i);
        }
        ArrayList<Integer> array = new ArrayList<>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                array.addAll(integers);
            }
        };


            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        System.out.println(array);
        }

    }

