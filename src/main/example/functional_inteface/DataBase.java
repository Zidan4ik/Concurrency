package main.example.functional_inteface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataBase {
    private List<Person> persons;

    public DataBase() {
        persons = new ArrayList<>();
    }
    public void add(Person person){
        persons.add(person);
    }
    public void showGreaterThan(int num){
        Predicate<Integer> predicate = n->n>num;
        Consumer<Person> consumer = person -> System.out.println(person);
        for (Person person:persons){
            if(predicate.filter(person.getAge())){
                consumer.show(person);
            }
        }
    }
    public List<Person> createPersons(){
        Supplier<List<Person>> supplier = ()->List.of(
                new Person("Roma","Pravnyk",20,"Ukraine"),
                new Person("Denys","Kysilechnyk",16,"USA"),
                new Person("Vasya","Taison",22,"Ukraine"),
                new Person("Kolya","Jura",21,"USA")
                );
        persons = new ArrayList<>(supplier.create());
        return persons;
    }
    public int countAmountFromCountry(String country){
        Function<Person,String> getCountry = p->p.getCountry();
        Set<String> countries = new HashSet<>();
        for (Person person:persons){
            if(person.getCountry()!=null){
                countries.add(getCountry.count(person));
            }
        }
        return countries.size();
    }
}

interface Predicate<T>{
    boolean filter(int num);
}
interface Consumer<T>{
    void show(Person person);
}
interface Supplier<T>{
    T create();
}
interface Function<T,R>{
    R count(T country);
}