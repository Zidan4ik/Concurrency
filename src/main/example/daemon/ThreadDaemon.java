package main.example.daemon;

public class ThreadDaemon extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isDaemon())
                    System.out.println("daemon thread is working...");
                if (!Thread.currentThread().isDaemon())
                    System.out.println("thread is working...");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDaemon daemon = new ThreadDaemon();
        ThreadDaemon thread = new ThreadDaemon();
        daemon.setDaemon(true);
        thread.setDaemon(false);

        daemon.start();
        thread.start();

        Thread.sleep(4000);

        /* the code bellow illustrates to us how the program will work after using them */
        // thread.interrupt();
        // daemon.interrupt();
    }
}
