package main.tasks.collection;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        ThreadCollection threadCollection = new ThreadCollection();
        ThreadCollection threadCollection2 = new ThreadCollection();
        threadCollection.start();
        threadCollection2.start();
        threadCollection.join();
        threadCollection2.join();

        threadCollection.showSize();
    }
}
