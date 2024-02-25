package main.example.creating;

public class MyThread2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("My name is thread1");
            }
        });

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("My name is thread2");
            }
        };

        Thread thread3 = new Thread(()->{ //
            System.out.println("My name is thread3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
