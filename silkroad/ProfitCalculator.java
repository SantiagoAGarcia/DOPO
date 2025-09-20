import java.util.*;

/**
 * Calculadora de profit máximo en SilkRoad.
 * Asigna cada tienda al robot que le dé mayor beneficio.
 * 
 * El profit de una tienda se calcula como:
 *     tenges - distancia(robot, tienda)
 * 
 * Si no hay robots o tiendas, el profit es 0.
 * 
 * Mantiene el profit total y referencias
 * al último robot y tienda que dieron mayor beneficio.
 * 
 * @author Buitrago - Garcia
 * @version 2.2
 */
public class ProfitCalculator {
    private Robot bestRobot;
    private Store bestStore;
    private int maxProfit;

    public ProfitCalculator() {
        maxProfit = 0;
        bestRobot = null;
        bestStore = null;
    }

    public int calculateMaxProfit(List<Robot> robots, List<Store> stores) {
        maxProfit = 0;

        if (robots.isEmpty() || stores.isEmpty()) {
            return maxProfit;
        }

        for (Store s : stores) {
            int bestProfit = 0;
            Robot chosen = null;

            for (Robot r : robots) {
                int distancia = Math.abs(r.getPosition().getX() - s.getPosition().getX());
                int profit = s.getTenges() - distancia;

                if (profit > bestProfit) {
                    bestProfit = profit;
                    chosen = r;
                }
            }

            if (chosen != null) {
                maxProfit += bestProfit;
                bestRobot = chosen;
                bestStore = s;
            }
        }

        return maxProfit;
    }

    public int getMaxProfit() {
        return maxProfit;
    }

    public Robot getBestRobot() {
        return bestRobot;
    }

    public Store getBestStore() {
        return bestStore;
    }
}