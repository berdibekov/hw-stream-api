package task5;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        Set<Soldier> soldiers =
                Stream.
                        generate(getSoldierSupplier()).
                        limit(20000000).
                        collect(Collectors.toSet());
        soldiers.add(new Soldier("youngest", 1));
        soldiers.add(new Soldier("oldest", 100));

        Instant start = Instant.now();
        Stat stat = soldiers.stream().collect(new CustomCollector());
        Instant finish = Instant.now();
        System.out.println("sequential stream time = " + Duration.between(start, finish));

        Instant startParallel = Instant.now();
        Stat parallelStat = soldiers.parallelStream().collect(new CustomCollector());
        Instant finishParallel = Instant.now();
        System.out.println("parallel stream time = " + Duration.between(startParallel, finishParallel));

        System.out.println(stat);
        System.out.println(parallelStat);
        if (stat.equals(parallelStat)) {
            System.out.println("sequential and parallel stream results are the same");
        } else {
            System.err.println("sequential and parallel stream results are different");
        }
    }

    private static Supplier<Soldier> getSoldierSupplier() {
        return () -> new Soldier(generateString(5), generateNumber());
    }

    private static String generateString(int maxLength) {
        Random r = new Random();
        int length = r.nextInt(maxLength) + 1;
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            text[i] = c;
        }
        return new String(text) + "\r\n";
    }

    private static int generateNumber() {
        Random r = new Random();
        return r.nextInt(80) + 20;
    }
}
