package task4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public Book(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors.stream().map(Author::getName).collect(Collectors.toList()) +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
