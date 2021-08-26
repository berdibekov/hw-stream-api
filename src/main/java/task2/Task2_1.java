package task2;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2_1 {
    public static void main(String[] args) {
//        Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
//        Заимплементил только основные.

        Predicate<String> isNumeric = t->t.chars().allMatch(Character::isDigit);

        Consumer<Integer> factorialGenerator = number ->
                Stream.
                        iterate(1, n -> n * (n + 1)).
                        limit(3).
                        forEachOrdered(n -> System.out.print(n + ","));

        Function<String, Set<String>> uniqueWordsParser = s ->
                Arrays.
                        stream(s.trim().split(" ")).
                        collect(Collectors.toSet());

        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();

        UnaryOperator<String> stringReverser = string -> new StringBuilder(string).reverse().toString();

        BinaryOperator<Integer> supplier = (a, b) -> a * b;

        System.out.println(isNumeric.test("554"));
        factorialGenerator.accept(3);
        System.out.println(uniqueWordsParser.apply("hello my friend"));
        System.out.println(random.get());
        System.out.println(stringReverser.apply("Hello world"));
        System.out.println(supplier.apply(9, 9));
    }
}
