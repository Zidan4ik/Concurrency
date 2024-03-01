package main.tasks.abc;

public class ThreadABC extends Thread {
    public static Object object = new Object();
    public static boolean flagA = true;
    public static boolean flagB = false;
    public static boolean flagC = false;
    private static int cycle = 3;

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                synchronized (object) {
                    try {
                        while (!flagA) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("A");
                    flagA = false;
                    flagB = true;
                    object.notifyAll();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                synchronized (object) {

                    try {
                        while (!flagB) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("B");
                    flagB = false;
                    flagC = true;
                    object.notifyAll();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                synchronized (object) {
                    try {
                        while (!flagC) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("C");
                    flagC = false;
                    flagA = true;
                    object.notifyAll();
                }
            }
        }
    }
}
