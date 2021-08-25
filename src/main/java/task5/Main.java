package task5;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Collector<Soldier,Stat, Stat> stringBuilderCollector =  Collector.of(
                Stat::new, // метод инициализации аккумулятора
                Stat::updateStat, // метод обработки каждого элемента
                Stat::mergeStat
        );

        List<Soldier> soldiers = Stream.generate(() -> new Soldier("", 1, 1)).limit(100).collect(Collectors.toList());
        System.out.println(soldiers.stream().
                sorted().
                collect(stringBuilderCollector));
    }
}
