package main.tasks.race;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {
    private int players;
    private static int readyCar = 0;
    private static int finishCar = 0;
    static List<TimeCar> totalTime = new ArrayList<>();

    public Race(int players) {
        this.players = players;
    }

    public void readyCar() {
        try {
            synchronized (this) {
                readyCar++;
                if (readyCar != players) {
                    wait();
                } else {
                    start();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() throws InterruptedException {
        readyCar = 0;
        notifyAll();
        System.out.println("Всі машини підготувались до гонки");
        Thread.sleep(1000);
        System.out.println("Старт!!!");
    }

    public void finishCar() {
        try {
            synchronized (this) {
                finishCar++;
                if (finishCar != players) {
                    wait();
                }else{
                    finish();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void finish() throws InterruptedException {
        finishCar=0;
        notifyAll();
        System.out.println("\n\nГонка закінчена. Результати: ");
        Thread.sleep(2000);
    }

    public void showTable(){
        Collections.sort(totalTime,(x,y)->x.time.compareTo(y.time));
        for(TimeCar car:totalTime){
            System.out.println("Гравець "+car.id + " Час: "+car.time/1000+" ");
        }
    }

    public int getPlayers() {
        return players;
    }

}
