package main.example.atomic_variable;


import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadAtomicBoolean {

    public static void main(final String[] args) throws InterruptedException {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " is working... And he is waiting, while Thread-2 to finish..." +
                            "current atomicBoolean = " + atomicBoolean.get());
                    if (atomicBoolean.compareAndSet(true, false)) {
                        System.out.println("fished work");
                        break;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " starts work! " + atomicBoolean.get());
                System.out.println(Thread.currentThread().getName() + " is going to change atomicBoolean to true...");
                atomicBoolean.set(true);
                System.out.println(Thread.currentThread().getName() + "... atomicBoolean: " + atomicBoolean.get());
            }
        });

        thread1.start();
        thread2.start();

    }
}
