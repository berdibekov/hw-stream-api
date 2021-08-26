package task1;

import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
//        Create:
//        Person class with name and age fields
//                A collection of Persons;
//        Two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name, second one – by age

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
