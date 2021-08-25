package task1;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(new Person("Ilyas",30),
                new Person("Ivan",18),
                new Person("Andrey",40),
                new Person("Sam",60));

        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        System.out.println("Sort by name");
        persons.
                stream().
                sorted(nameComparator).
                forEach(System.out::println);
        System.out.println("Sort by age");
        persons.
                stream().
                sorted(ageComparator).
                forEach(System.out::println);
    }



}
