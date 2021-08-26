#Task 1. (5 points) A person stream
Create:
Person class with name and age fields
A collection of Persons;
Two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name, second one – by age
 
Then sort them using these comparators.
 
Use forEach method for printing information about all the persons. 
 
Try to use method reference if it is possible.
 
#Task 2. (10 points) Functional Interface Sandbox
 
Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
Add few default methods to it and use them.
Add few static methods to it and use them. 
 
#Task 3. (5 points) Custom Functional Interface
Write your own functional interface ThreeFunction (it takes three arguments and produce result).
Implement this with two different lambdas
Provide client code with usage of this lambdas
 
 
#Task 4. (20 points) Collection to stream
Create the following classes:
Author with fields: 
String name
short age
List<Book> books
Book with fields
String title
List<Author> authors
int numberOfPages
Create two arrays: Author[] authors and Book[] books. Their elements must use elements from the neighboring array.
Create a stream of books and then:
check if some/all book(s) have more than 200 pages;
find the books with max and min number of pages;
filter books with only single author;
sort the books by number of pages/title;
get list of all titles;
print them using forEach method;
get distinct list of all authors
Use peek method for debugging intermediate streams during execution the previous task.
Use parallel stream with subtask #3.
Analyze with mentor results of previous subtask execution, explain him the difference between stream and parallel stream.
Use the Optional type for determining the title of the biggest book of some author.

#Task 5. (20 points) Custom collector
Define a complex class A with a few fields with different types. This class will be an item in collection.
Define a few methods which calculates some stat over the fields of the A class.
Make stream from the collection of A’s instances.
Write custom collector to accumulate the information from elements of your stream.
Implement Collector interface
Don’t forget the final transformation
Try to use Characteristics for the optimization purpose.
Add tests for your collector.
Test your Collector with the parallel streams for significant amount of items in stream.
Look at the Collector interface and read about combine method if something is going wrong.

Penalties are easy: 
also -3 for each task if mentee ignores Java Code Conventions
-4 for each missed first-level feature
-2 for each missed second-level feature


//        Book[] books = new Book[]{new Book("1984", List.of(authors[0]), 555),
//                new Book("Одноэтажная Америка", List.of(authors[1], authors[2]), 456),
//                new Book("Записные книжки", List.of(authors[1]), 99),
//                new Book("Путешествие на Дальний Восток", List.of(authors[2]), 99),
//                new Book("Harry Potter and the philosopher's stone", List.of(authors[3]), 555),
//                new Book("Harry Potter and the chamber of secrets", List.of(authors[3]), 654),
//                new Book("Harry Potter and azkaban prisoner", List.of(authors[3]), 700),
//                new Book("Руслан и людмила", List.of(authors[3]), 700)};