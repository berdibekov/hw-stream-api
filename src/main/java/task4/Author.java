package task4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Author {
    private String name;
    private short age;
    private List<Book> books;

    public Author(String name, short age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books.stream().map(Book::getTitle).collect(Collectors.toList()) +
                '}';
    }
}
