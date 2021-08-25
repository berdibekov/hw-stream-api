package task5;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector {

    @Override
    public Supplier supplier() {
        return Stat::new;
    }

    @Override
    public BiConsumer<Stat,Soldier> accumulator() {
        return Stat::updateStat;
    }

    @Override
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
