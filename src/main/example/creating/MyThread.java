package main.example.creating;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello, my name is "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
