package main.example.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter implements Runnable {
//    private int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCounter runnable = new ThreadCounter();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(runnable.atomicInteger);
    }
}
