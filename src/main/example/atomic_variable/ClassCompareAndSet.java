package main.example.atomic_variable;

import java.util.concurrent.atomic.AtomicBoolean;

public class ClassCompareAndSet {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (atomicBoolean) {
                    System.out.println("before T1:" + atomicBoolean.get());
                    if (atomicBoolean.compareAndSet(false, true))
                        System.out.println("T1: " + atomicBoolean.get());
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (atomicBoolean) {
                    System.out.println("before T2:" + atomicBoolean.get());
                    if (atomicBoolean.compareAndSet(true, false))
                        System.out.println("T2: " + atomicBoolean.get());
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);


        thread.start();
        thread2.start();


    }
}
