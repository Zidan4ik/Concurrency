package main.tasks.show_time;

public class TDaemon implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}