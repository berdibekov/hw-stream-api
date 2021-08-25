package task4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class Main {
    public static void main(String[] args) {

//        2.	Create two arrays: Author[] authors and Book[] books. Their elements must use elements from the neighboring array.

        Author[] authors = generateAuthors();
        Book[] books = generateBooks();
        addAuthorsToBooks(authors, books);
        addBooksToAuthors(authors, books);

//        3.	Create a stream of books and then:
//        I.	check if some/all book(s) have more than 200 pages;
        boolean isAnyMore200 = Arrays.
                stream(books).
                mapToInt(Book::getNumberOfPages).
                anyMatch(number -> number > 200);
        boolean isAllMore200 = Arrays.
                stream(books).
                mapToInt(Book::getNumberOfPages).
                allMatch(number -> number > 200);
        System.out.println("I.\tcheck if some/all book(s) have more than 200 pages;");
        System.out.println("any? : " + isAnyMore200);
        System.out.println("all? : " + isAllMore200);
        System.out.println();

//        II.	find the books with max and min number of pages;

        IntSummaryStatistics statistics = Arrays.stream(books).mapToInt(Book::getNumberOfPages).summaryStatistics();
        System.out.println("II.\tfind the books with max and min number of pages;");
        System.out.println("min pages :");
        Arrays.stream(books).
                filter(b -> b.getNumberOfPages() == statistics.getMin()).
                forEach(System.out::println);
        System.out.println("max pages :");
        Arrays.stream(books).
                filter(b -> b.getNumberOfPages() == statistics.getMax()).
                forEach(System.out::println);
        System.out.println();

//        III.	filter books with only single author;

        System.out.println("III. Books with only single author :");
        Arrays.stream(books).
                filter(book -> book.getAuthors().size() == 1).
                forEach(System.out::println);
        System.out.println();
//        IV.	sort the books by number of pages/title;

        System.out.println("IV.\tsort the books by number of pages/title;");
        System.out.println("sort by pages:");
        Arrays.stream(books).
                sorted(Comparator.comparingInt(Book::getNumberOfPages)).
                forEach(System.out::println);
        System.out.println("sort by title");
        Arrays.stream(books).
                sorted(Comparator.comparing(Book::getTitle)).
                forEach(System.out::println);
        System.out.println();

//        V.	get list of all titles;

        System.out.println("V.\tget list of all titles;");
        List<String> titles = Arrays.stream(books).
                map(Book::getTitle).
                collect(Collectors.toList());

//        VI.	print them using forEach method;
        titles.forEach(System.out::println);
        System.out.println("VI.\tprint them using forEach method;");
        System.out.println();

//        VII.	get distinct list of all authors
        System.out.println("VII.\tget distinct list of all authors");
        List<String> distinctAuthors = Arrays.
                stream(books).
                flatMap(a -> a.getAuthors().stream()).
                map(Author::getName).
                distinct().
                collect(Collectors.toList());

        distinctAuthors.forEach(System.out::println);
        System.out.println();

//      4.	Use peek method for debugging intermediate streams during execution the previous task.
        System.out.println("4.\tUse peek method for debugging intermediate streams during execution the previous task.");
        // I
        Arrays.
                stream(books).
                mapToInt(Book::getNumberOfPages).
                peek(System.out::println).
                allMatch(number -> number > 200);
        // II
        Arrays.stream(books).mapToInt(Book::getNumberOfPages).peek(System.out::println).summaryStatistics();

//        5.	Use parallel stream with subtask #3.
        // Все тоже самое только после Arrays.stream(books) добавляется parallel - Arrays.stream(books).parallel() ...

//        7.	Use the Optional type for determining the title of the biggest book of some author.
        System.out.println("7.\tUse the Optional type for determining the title of the biggest book of some author.");
        Predicate<Book> joanRollingAuthorChecker =
                book -> book.getAuthors().
                        stream().
                        map(Author::getName).
                        anyMatch(name -> name.equals("Joan Rolling"));
        Arrays.stream(books).
                filter(joanRollingAuthorChecker).
                max(comparing(Book::getNumberOfPages)).
                ifPresentOrElse(Main::printMaxBook, () -> System.out.println("Can`t find max book title"));
    }

    private static void printMaxBook(Book max) {
        System.out.println("max book title is :" + max.getTitle());
    }

    private static void addBooksToAuthors(Author[] authors, Book[] books) {
        authors[0].setBooks(List.of(books[0]));
        authors[1].setBooks(List.of(books[1], books[2]));
        authors[2].setBooks(List.of(books[1], books[3]));
        authors[3].setBooks(List.of(books[4], books[5], books[6]));
        authors[4].setBooks(List.of(books[7]));
    }

    private static void addAuthorsToBooks(Author[] authors, Book[] books) {
        books[0].setAuthors(List.of(authors[0]));
        books[1].setAuthors(List.of(authors[1], authors[2]));
        books[2].setAuthors(List.of(authors[1]));
        books[3].setAuthors(List.of(authors[2]));
        books[4].setAuthors(List.of(authors[3]));
        books[5].setAuthors(List.of(authors[3]));
        books[6].setAuthors(List.of(authors[3]));
        books[7].setAuthors(List.of(authors[4]));
    }

    private static Book[] generateBooks() {
        return new Book[]{
                new Book("1984", 555),
                new Book("Одноэтажная Америка", 456),
                new Book("Записные книжки", 99),
                new Book("Путешествие на Дальний Восток", 99),
                new Book("Harry Potter and the philosopher's stone", 555),
                new Book("Harry Potter and the chamber of secrets", 654),
                new Book("Harry Potter and azkaban prisoner", 700),
                new Book("Руслан и людмила", 700)};
    }

    private static Author[] generateAuthors() {
        return new Author[]{
                new Author("George Orwell", (short) 71),
                new Author("Ильф", (short) 100),
                new Author("Петров", (short) 112),
                new Author("Joan Rolling", (short) 60),
                new Author("Пушкин", (short) 300)
        };
    }
}
