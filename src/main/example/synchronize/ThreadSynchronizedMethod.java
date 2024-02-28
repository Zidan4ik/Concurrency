package main.example.synchronize;

public class ThreadSynchronizedMethod implements Runnable {
    private static int counter = 0;

//    @Override
//    public void run() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                counter = counter + i;
//                System.out.println(Thread.currentThread().getName() + " : " + counter);
//            }
//        }
//    }

    @Override
     synchronized public void run() {
        for (int i = 0; i < 5; i++) {
            counter = counter + 1;
            System.out.println(Thread.currentThread().getName() + " : " + counter);
        }
    }


    public static void main(String[] args) {
        ThreadSynchronizedMethod runnable = new ThreadSynchronizedMethod();

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread.start();
        thread2.start();
        thread3.start();
    }
}
