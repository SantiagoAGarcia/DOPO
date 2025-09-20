/**
 * Barra de seguimiento de profit en SilkRoad.
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class ProfitBar {
    private int currentProfit;
    private int maxProfit;
    private Rectangle bar;
    private String label;

    public ProfitBar(int maxProfit) {
        this.maxProfit = maxProfit;
        this.currentProfit = 0;
        this.bar = null;
        this.label = "";
    }

    public void updateProfit(int profit) {
        this.currentProfit = profit;
    }

    public int getCurrentProfit() {
        return currentProfit;
    }

    public int getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(int maxProfit) {
        this.maxProfit = maxProfit;
    }

    public void reset() {
        this.currentProfit = 0;
        this.maxProfit = 0;
    }
}