package task5;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(value = AccessLevel.PRIVATE)
public class Stat {
    private Soldier oldest;
    private Soldier youngest;
    private double averageAge;
    private int allSoldiersNumber;
    @Getter(value = AccessLevel.PRIVATE)
    private long sumOfAges;

    public Stat mergeStat(Stat stat) {
        if (stat.getOldest().getAge() > oldest.getAge()) {
            this.oldest = stat.oldest;
        }
        if (stat.getYoungest().getAge() < youngest.getAge()) {
            this.youngest = stat.getYoungest();
        }
        sumOfAges += stat.sumOfAges;
        allSoldiersNumber += stat.allSoldiersNumber;
        averageAge = sumOfAges / (double) allSoldiersNumber;
        return this;
    }

    public void updateStat(Soldier soldier) {
        int currentMaxAge = oldest == null ? 0 : oldest.getAge();
        int currentMinAge = youngest == null ? 0 : youngest.getAge();

        if (soldier.getAge() > currentMaxAge) {
            oldest = soldier;
        }
        if (soldier.getAge() < currentMinAge || youngest == null) {
            youngest = soldier;
        }
        sumOfAges += soldier.getAge();
        allSoldiersNumber += 1;
        averageAge = sumOfAges / (double) allSoldiersNumber;
    }
}
