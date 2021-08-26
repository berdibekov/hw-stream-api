package task3;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Task3 {
    @Data
    @AllArgsConstructor
    static
    class Point {
        private int x;
        private int y;
        private int z;
    }

    public static void main(String[] args) {
        System.out.println("First lambda result:");
        ThreeFunction<Integer, Integer, Integer, String> threeFunction =
                (a, b, c) -> String.format("%d + %d + %d", a, b, c);
        System.out.println(threeFunction.apply(10, 20, 30));
        System.out.println("Second lambda result:");
        ThreeFunction<Integer, Integer, Integer, Point> pointCreator = Point::new;
        System.out.println(pointCreator.apply(1, 2, 3));

    }
}
