package main.tasks.race;


import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        Race race = new Race(count);
        Semaphore tunnel = new Semaphore(3);
        for (int i = 1; i <=10; i++) {
            Car car = new Car(race,i,tunnel);
            car.start();
        }
    }
}
