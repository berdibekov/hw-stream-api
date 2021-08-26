package task5;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomCollectorTest {

    @Test
    void CustomCollector_shouldReturnStat_whenInvokeInStream() {
        Soldier youngestSoldier = new Soldier("youngest", 1);
        Soldier oldestSoldier = new Soldier("oldest", 100);
        CustomCollector customCollector = new CustomCollector();
        Set<Soldier> soldiers = generateSoldiers();
        soldiers.add(youngestSoldier);
        soldiers.add(oldestSoldier);
        Stat stat = soldiers.stream().collect(customCollector);

        assertEquals(youngestSoldier, stat.getYoungest());
        assertEquals(oldestSoldier, stat.getOldest());
    }

    private Set<Soldier> generateSoldiers() {
        return Stream.
                generate(getSoldierSupplier()).
                limit(20000000).
                collect(Collectors.toSet());
    }

    @Test
    void CustomCollector_shouldReturnSameStatForSequentialAndParallelStreams() {
        CustomCollector customCollector = new CustomCollector();
        Set<Soldier> soldiers = generateSoldiers();
        soldiers.add(new Soldier("youngest", 1));
        soldiers.add(new Soldier("oldest", 100));
        Stat stat = soldiers.stream().collect(customCollector);
        Stat parallelStat = soldiers.parallelStream().collect(customCollector);

        assertEquals(stat, parallelStat);
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
        return new Random().nextInt(80) + 20;
    }
}