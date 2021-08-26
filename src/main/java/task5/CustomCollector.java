package task5;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<Soldier, Stat, Stat> {

    @Override
    public Supplier<Stat> supplier() {
        return Stat::new;
    }

    @Override
    public BiConsumer<Stat, Soldier> accumulator() {
        return Stat::updateStat;
    }

    @Override
    public BinaryOperator<Stat> combiner() {
        return Stat::mergeStat;
    }

    @Override
    public Function<Stat, Stat> finisher() {
        return s->s;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
