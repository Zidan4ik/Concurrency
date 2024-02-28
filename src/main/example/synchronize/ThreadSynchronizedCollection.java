package main.example.synchronize;

import java.util.*;

public class ThreadSynchronizedCollection {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(i);
        }
        List<Integer> integersSynchro = Collections.synchronizedList(integers);


        Runnable runnable = () -> {
            synchronized (integersSynchro) {
                Iterator<Integer> iterator = integersSynchro.iterator();
                while (iterator.hasNext())
                    System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            integersSynchro.remove(10);
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(integersSynchro);
    }
}
