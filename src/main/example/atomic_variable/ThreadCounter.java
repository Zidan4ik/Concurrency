package main.example.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter extends Thread {
    //    private static int i = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
//            i++;
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadCounter thread = new ThreadCounter();
        ThreadCounter thread2 = new ThreadCounter();

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

//        System.out.println(i);
        System.out.println(atomicInteger);
    }
}
