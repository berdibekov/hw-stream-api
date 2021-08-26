package task2;

public class Task2_2 {
//    Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
//    Add few default methods to it and use them.
//    Add few static methods to it and use them.

    public static void main(String[] args) {
        CustomInterface<Integer, Integer, Integer, Integer, String> customInterface =
                new CustomInterface<>() {
                    @Override
                    public String apply(Integer first, Integer second, Integer third, Integer fourth) {
                        return first + "," + second + "," + third + "," + fourth;
                    }
                };

        CustomInterface<String, String, String, String, String> customInterface2 =
                (a, b, c, d) -> a.trim() + " " + b.trim() + " " + c.trim() + " " + d.trim();

        System.out.println(customInterface.apply(1, 2, 3, 4));
        System.out.println(customInterface2.apply("i   wona", "some ", "fruites", " oh"));

        customInterface.printAllArguments(1, 2, 3, 4);
        System.out.println(customInterface2.isAllArgumentsEquals("a", "a", "a", "a"));

        CustomInterface.createIntegerSum().printAllArguments("a", "a", "a", "a");
    }

    @FunctionalInterface
    interface CustomInterface<A, B, C, D, F> {
        F apply(A first, B second, C third, D fourth);

        default void printAllArguments(A a, B b, C c, D d) {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }

        default boolean isAllArgumentsEquals(A a, B b, C c, D d) {
            return a.equals(b) &&
                    b.equals(c) &&
                    c.equals(d);
        }

        static CustomInterface<String, String, String, String, String> createIntegerSum() {
            return (a, b, c, d) -> a.toUpperCase() + " " + b.toLowerCase() + " " + c.trim() + " " + d.trim();
        }
    }
}
