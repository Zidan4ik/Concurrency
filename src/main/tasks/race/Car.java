package main.tasks.race;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static main.tasks.race.Race.totalTime;

public class Car extends Thread {
    private Race race;
    private int id;
    private Semaphore tunnel;
    private static AtomicInteger countInCollection = new AtomicInteger(0);

    public Car(Race race, int id, Semaphore tunnel) {
        this.race = race;
        this.id = id;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        try {
            double timeReady = Math.round((Math.random() * 5000) + 1000);
            System.out.println("Гравець " + id + " почав підготовку");
            sleep((long) timeReady);
            System.out.println("Гравець " + id + " закінчив підготовку, час: " + timeReady / 1000);
            race.readyCar();

            System.out.println("Гравець " + id + " стартував!");

            double timeFirstCycle = Math.round((Math.random() * 5_000) + 3000);
            sleep((long) timeFirstCycle);
            System.out.println("Гравець " + id + " проїхав перше коло за " + timeFirstCycle / 1000 + " секунду");

            double timeAheadTunnel = System.currentTimeMillis();
            tunnel.acquire();
            double timeInTunnel = System.currentTimeMillis();
            double time2 = Math.round((timeInTunnel - timeAheadTunnel) / 1000);

            System.out.println("Гравець " + id + " в'їхав в тунель. Час в очікуванні: " + time2);
            double timeTunnel = Math.round((Math.random() * 10_000) + 4000);
            sleep((long) timeTunnel);
            System.out.println("Гравець " + id + " виїхав в тунель, затрачений час: " + timeTunnel / 1000);
            tunnel.release();

            double timeLastCycle = Math.round((Math.random() * 6_000) + 2000);
            sleep((long) timeLastCycle);
            System.out.println("Гравець " + id + " проїхав останнє коло за " + timeLastCycle / 1000 + " секунду");
            race.finishCar();

            TimeCar time = new TimeCar(id, timeFirstCycle + timeTunnel + timeLastCycle + time2);
            totalTime.add(time);

            if (countInCollection.incrementAndGet() == race.getPlayers()) {
                race.showTable();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
