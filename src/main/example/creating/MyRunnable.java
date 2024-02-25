package main.example.creating;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello, my name is "+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        MyRunnable throwable = new MyRunnable();
        Thread thread = new Thread(throwable);
        Thread thread2 = new Thread(throwable);
        Thread thread3 = new Thread(throwable);

        thread.start();
        thread2.start();
        thread3.start();
    }
}
