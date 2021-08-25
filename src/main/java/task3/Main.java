package task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        class Point{
            private int x;
            private int y;
            private  int z;
        }
        ThreeFunction<Integer, Integer, Integer, String> threeFunction = (a, b, c) -> String.format("%d + %d + %d", a, b, c);
        System.out.println(threeFunction.apply(10, 20, 30));

        ThreeFunction<Integer, Integer, Integer, Point> pointCreator = Point::new;
        System.out.println(pointCreator.apply(1,2,3));

    }
}
