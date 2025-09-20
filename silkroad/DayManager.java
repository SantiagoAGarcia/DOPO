/**
 * Maneja los días de la simulación SilkRoad.
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class DayManager {
    private int currentDay;
    private int totalDays;

    public DayManager(int totalDays) {
        this.currentDay = 1;
        this.totalDays = totalDays;
    }

    public void nextDay() {
        currentDay++;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public boolean isFinished() {
        return currentDay > totalDays;
    }
}