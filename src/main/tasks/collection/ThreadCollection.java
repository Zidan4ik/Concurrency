package main.tasks.collection;

import java.util.ArrayList;
import java.util.List;

public class ThreadCollection extends Thread{
    private static List<Integer> integers = new ArrayList<>();

    @Override
    public void run() {
        synchronized (integers){
            for (int i = 0; i <10_000; i++) {
                integers.add((int) (Math.random() * (20))+1);
            }
        }
    }
    public void showSize(){
        System.out.println(integers.size());
    }
}
