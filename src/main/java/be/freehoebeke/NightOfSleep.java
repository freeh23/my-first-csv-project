package be.freehoebeke;

import java.time.LocalDate;
import java.time.LocalTime;

public class NightOfSleep {
    private final LocalDate date;
    private final LocalTime goToSleepHour;
    private final LocalTime wakeUpHour;
    private final LocalTime amountOfSleep;


    public NightOfSleep(LocalDate date, LocalTime goToSleepHour, LocalTime wakeUpHour, LocalTime amountOfSleep) {
        this.date = date;
        this.goToSleepHour = goToSleepHour;
        this.wakeUpHour = wakeUpHour;
        this.amountOfSleep = amountOfSleep;
    }

    @Override
    public String toString() {
        return "NightOfSleep{" +
                "date=" + date +
                ", goToSleepHour=" + goToSleepHour +
                ", wakeUpHour=" + wakeUpHour +
                ", amountOfSleep=" + amountOfSleep +
                '}';
    }
}
