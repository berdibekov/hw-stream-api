package task5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private Soldier oldest;
    private Soldier youngest;
    private double averageAge;

    public Stat mergeStat(Stat stat) {
        if (stat.getOldest().getAge() > oldest.getAge()) {
            this.oldest = stat.oldest;
        }
        if (stat.getYoungest().getAge() > youngest.getAge()) {
            this.youngest = stat.getYoungest();
        }
        averageAge = (averageAge + stat.averageAge) / 2;
        return this;
    }

    public void updateStat(Soldier soldier) {
        int currentMaxAge = oldest == null ? 0 : oldest.getAge();
        if (soldier.getAge() > currentMaxAge) {
            oldest = soldier;
        }
        if (soldier.getAge() < currentMaxAge || youngest == null) {
            youngest = soldier;
        }
        if (averageAge > 0) {
            averageAge = (averageAge + soldier.getAge()) / 2;
        } else {
            averageAge = soldier.getAge();
        }
    }
}
