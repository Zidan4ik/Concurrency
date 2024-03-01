package main.example.functional_inteface;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        List<Person> persons = dataBase.createPersons();
//        for (Person person:persons) System.out.println(person);
//        dataBase.showGreaterThan(19);
        int ukraine = dataBase.countAmountFromCountry("Ukraine");
        System.out.println(ukraine);

    }
}
