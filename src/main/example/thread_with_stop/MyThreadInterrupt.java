package main.example.thread_with_stop;

public class MyThreadInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("sleep interrupted");
                break;
            }
            System.out.println(i + " batches have been moved ("+Thread.currentThread().getName()+")");
        }
        System.out.println("End of moving");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread r = new Thread(new MyThreadInterrupt());
        Thread r2 = new Thread(new MyThreadInterrupt());
        r.start();
        Thread.sleep(5500);
        r2.start();

        r2.interrupt();
        r.interrupt();
    }
}
