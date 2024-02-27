package main.example.thread_with_stop;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyThreadAtomicBoolean implements Runnable {
    private Thread thread;
    private AtomicBoolean running = new AtomicBoolean(true);

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running.set(false);
    }

    private AtomicBoolean getRunning() {
        return running;
    }

    @Override
    public void run() {

        while (getRunning().get()) {
            try {
                Thread.sleep(2000);
                System.out.println("My name is "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("finish");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadAtomicBoolean myThreadAtomicBoolean = new MyThreadAtomicBoolean();
        myThreadAtomicBoolean.start();

        Thread.sleep(5000);
        myThreadAtomicBoolean.stop();
    }

}
