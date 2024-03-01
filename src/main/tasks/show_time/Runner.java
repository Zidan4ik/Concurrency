package main.tasks.show_time;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<String> names = List.of("Roma","Denys","Maxim","Masha","Christyna");
        show(names);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведіть індекс: ");
        int index = scanner.nextInt();

        Callable callable = new Callable() {
            @Override
            public String call() throws Exception {
                TDaemon runnable = new TDaemon();
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                try {
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return names.get(index);
            }
        };
        String call = (String) callable.call();
        System.out.println("\nКористувач: "+call);
    }
    public static void show(List list){
        System.out.println("Список імен: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +" ");
        }
    }
}
