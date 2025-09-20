import java.util.*;

/**
 * Clase principal de la simulación SilkRoad extendida.
 * Administra robots, tiendas, el cálculo de profits y el flujo de los días.
 * 
 * @author Buitrago - Garcia
 * @version 2.0 Extended
 */
public class SilkRoad {
    private List<Store> stores;
    private List<Robot> robots;
    private ProfitBar profitBar;
    private DayManager dayManager;
    private MessageHandler messageHandler;
    private boolean ok;
    private Map<Integer, Integer> robotVisitCounts; // Para requisito 12
    private Map<Integer, Integer> robotEarnings; // Para requisito 13
    private List<Integer> optimalPath; // Para requisito 10

    public SilkRoad(int totalDays) {
        stores = new ArrayList<>();
        robots = new ArrayList<>();
        profitBar = new ProfitBar(0);
        dayManager = new DayManager(totalDays);
        messageHandler = new MessageHandler(true);
        robotVisitCounts = new HashMap<>();
        robotEarnings = new HashMap<>();
        optimalPath = new ArrayList<>();
        ok = true;
    }

    // Método para crear/inicializar el sistema
    public void create() {
        messageHandler.showMessage("SilkRoad simulation initialized.");
    }

    public Store placeStore(int id, int position, int tenges) {
        Store store = new Store(id, position, tenges);
        stores.add(store);
        messageHandler.showMessage("Store " + id + " placed at position " + position + " with " + tenges + " tenges.");
        return store; // Devolver el objeto Store creado
    }

    public void removeStore(int id) {
        for (Store s : stores) {
            if (s.getId() == id) {
                s.remove();
                messageHandler.showMessage("Store " + id + " removed.");
            }
        }
    }

    public void resupply() {
        for (Store s : stores) {
            s.resupply();
        }
        messageHandler.showMessage("All stores resupplied.");
    }

    public Robot placeRobot(int id, int position) {
        Robot robot = new Robot(id, position);
        robots.add(robot);
        robotVisitCounts.put(id, 0);
        robotEarnings.put(id, 0);
        return robot; // Devolver el objeto Robot creado
    }

    public void removeRobot(int id) {
        for (Robot r : robots) {
            if (r.getId() == id) {
                r.remove();
                robotVisitCounts.remove(id);
                robotEarnings.remove(id);
                messageHandler.showMessage("Robot " + id + " removed.");
            }
        }
    }

    public void moveRobot(int id, int newPos) {
        for (Robot r : robots) {
            if (r.getId() == id) {
                r.moveToNewPos(new Position(newPos));
                messageHandler.showMessage("Robot " + id + " moved to position " + newPos + ".");
            }
        }
    }

    /**
     * EXTENSIÓN - Movimiento optimizado de robots para maximizar ganancia (Requisito 11)
     */
    public void moveRobotOptimized(int robotId, int targetPosition) {
        Robot robot = findRobotById(robotId);
        if (robot == null) return;

        // Calcular la mejor ruta considerando las tiendas disponibles
        List<Integer> bestPath = calculateOptimalPath(robot.getPosition().getValue(), targetPosition);
        
        for (int i = 1; i < bestPath.size(); i++) {
            robot.moveToNewPos(new Position(bestPath.get(i)));
            
            // Verificar si hay tienda en esta posición y actualizar estadísticas
            Store storeAtPosition = findStoreAtPosition(bestPath.get(i));
            if (storeAtPosition != null && !storeAtPosition.isRemoved()) {
                robotVisitCounts.put(robotId, robotVisitCounts.get(robotId) + 1);
                int earnings = storeAtPosition.getTenges();
                robotEarnings.put(robotId, robotEarnings.get(robotId) + earnings);
            }
        }
        
        messageHandler.showMessage("Robot " + robotId + " moved optimally to position " + targetPosition + 
                                 " via path: " + bestPath);
    }

    /**
     * Calcula la ruta óptima entre dos posiciones considerando las tiendas
     */
    private List<Integer> calculateOptimalPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        path.add(start);
        
        // Algoritmo simple de pathfinding que considera tiendas en el camino
        int current = start;
        while (current != end) {
            int next = current < end ? current + 1 : current - 1;
            
            // Verificar si hay tiendas rentables en el camino
            Store nearbyStore = findMostProfitableStoreNear(current, end);
            if (nearbyStore != null && !path.contains(nearbyStore.getPositionX())) {
                path.add(nearbyStore.getPositionX());
                current = nearbyStore.getPositionX();
            } else {
                path.add(next);
                current = next;
            }
        }
        
        return path;
    }

    private Store findMostProfitableStoreNear(int current, int target) {
        Store bestStore = null;
        int maxProfit = 0;
        
        for (Store store : stores) {
            if (!store.isRemoved() && 
                Math.abs(store.getPositionX() - current) <= 2 && 
                store.getTenges() > maxProfit) {
                bestStore = store;
                maxProfit = store.getTenges();
            }
        }
        
        return bestStore;
    }

    public void returnRobot(int id) {
        for (Robot r : robots) {
            if (r.getId() == id) {
                r.reset();
                messageHandler.showMessage("Robot " + id + " returned to initial position.");
            }
        }
    }

    public void rebootRobot(int id) {
        returnRobot(id);
        messageHandler.showMessage("Robot " + id + " rebooted.");
    }

    public void reboot() {
        stores.clear();
        robots.clear();
        robotVisitCounts.clear();
        robotEarnings.clear();
        optimalPath.clear();
        profitBar.reset();
        ok = true;
        messageHandler.showMessage("System rebooted.");
    }

    public void calculateMaxProfit() {
        ProfitCalculator calculator = new ProfitCalculator();
        int profit = calculator.calculateMaxProfit(robots, stores);
        profitBar.updateProfit(profit);
        messageHandler.showMessage("Día " + dayManager.getCurrentDay() +
                ": Profit = " + profit);
        dayManager.nextDay();
        if (dayManager.isFinished()) {
            finish();
        }
    }

    /**
     * EXTENSIÓN - Método consult para consultar profits (Requisitos 12 y 13)
     */
    public void consult() {
        ProfitCalculator calculator = new ProfitCalculator();
        int profit = calculator.calculateMaxProfit(robots, stores);
        profitBar.updateProfit(profit);
        
        Robot bestRobot = calculator.getBestRobot();
        Store bestStore = calculator.getBestStore();
        
        messageHandler.showMessage("=== PROFIT ANALYSIS ===");
        messageHandler.showMessage("Day " + dayManager.getCurrentDay() + ": Max Profit = " + profit);
        if (bestRobot != null) {
            messageHandler.showMessage("Best Robot: " + bestRobot.getId() + 
                                     " (Earnings: " + robotEarnings.get(bestRobot.getId()) + ")");
        }
        if (bestStore != null) {
            messageHandler.showMessage("Best Store: " + bestStore.getId() + 
                                     " (Tenges: " + bestStore.getTenges() + ")");
        }
        
        // Mostrar estadísticas de visitas (Requisito 12)
        messageHandler.showMessage("=== STORE VISIT STATISTICS ===");
        for (Map.Entry<Integer, Integer> entry : robotVisitCounts.entrySet()) {
            messageHandler.showMessage("Robot " + entry.getKey() + " visited stores " + 
                                     entry.getValue() + " times");
        }
        
        // Mostrar ganancias por robot (Requisito 13)
        messageHandler.showMessage("=== ROBOT EARNINGS ===");
        for (Map.Entry<Integer, Integer> entry : robotEarnings.entrySet()) {
            messageHandler.showMessage("Robot " + entry.getKey() + " earned " + 
                                     entry.getValue() + " tenges");
        }
        
        dayManager.nextDay();
        if (dayManager.isFinished()) {
            finish();
        }
    }

    /**
     * EXTENSIÓN - Consulta la ruta óptima de la seda (Requisito 10)
     */
    public void consultSilkRoad() {
        if (robots.isEmpty() || stores.isEmpty()) {
            messageHandler.showMessage("No robots or stores available for route calculation.");
            return;
        }

        // Calcular la ruta óptima que conecta todas las tiendas
        List<Store> sortedStores = new ArrayList<>(stores);
        sortedStores.removeIf(Store::isRemoved);
        sortedStores.sort(Comparator.comparingInt(s -> s.getPositionX()));

        messageHandler.showMessage("=== OPTIMAL SILK ROAD ROUTE ===");
        messageHandler.showMessage("Recommended path through stores:");
        
        StringBuilder route = new StringBuilder();
        int totalDistance = 0;
        int totalTenges = 0;

        for (int i = 0; i < sortedStores.size(); i++) {
            Store store = sortedStores.get(i);
            route.append("Store ").append(store.getId())
                 .append(" (pos: ").append(store.getPositionX())
                 .append(", tenges: ").append(store.getTenges()).append(")");
            
            totalTenges += store.getTenges();
            
            if (i < sortedStores.size() - 1) {
                int distance = Math.abs(sortedStores.get(i + 1).getPositionX() - store.getPositionX());
                totalDistance += distance;
                route.append(" -> ");
            }
        }

        messageHandler.showMessage(route.toString());
        messageHandler.showMessage("Total distance: " + totalDistance + " units");
        messageHandler.showMessage("Total potential tenges: " + totalTenges);
        
        // Guardar la ruta óptima para uso futuro
        optimalPath.clear();
        for (Store store : sortedStores) {
            optimalPath.add(store.getPositionX());
        }
    }

    // Métodos auxiliares
    private Robot findRobotById(int id) {
        return robots.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    private Store findStoreAtPosition(int position) {
        return stores.stream().filter(s -> s.getPositionX() == position).findFirst().orElse(null);
    }

    // Métodos existentes
    public Robot getBestRobot() {
        ProfitCalculator calculator = new ProfitCalculator();
        calculator.calculateMaxProfit(robots, stores);
        return calculator.getBestRobot();
    }

    public Store getBestStore() {
        ProfitCalculator calculator = new ProfitCalculator();
        calculator.calculateMaxProfit(robots, stores);
        return calculator.getBestStore();
    }

    public List<Robot> robots() {
        return robots;
    }

    public List<Store> stores() {
        return stores;
    }

    public void makeVisible() {
        messageHandler.setVisible(true);
        messageHandler.showMessage("Simulation made visible.");
    }

    public void makeInvisible() {
        messageHandler.setVisible(false);
    }

    public void finish() {
        messageHandler.showMessage("Simulation finished.");
        messageHandler.showMessage("Final Statistics:");
        
        // Mostrar estadísticas finales
        messageHandler.showMessage("=== FINAL ROBOT EARNINGS ===");
        for (Map.Entry<Integer, Integer> entry : robotEarnings.entrySet()) {
            messageHandler.showMessage("Robot " + entry.getKey() + " earned " + 
                                     entry.getValue() + " tenges total");
        }
        
        messageHandler.showMessage("=== FINAL STORE VISITS ===");
        for (Map.Entry<Integer, Integer> entry : robotVisitCounts.entrySet()) {
            messageHandler.showMessage("Robot " + entry.getKey() + " visited stores " + 
                                     entry.getValue() + " times total");
        }
        
        ok = false;
    }

    public boolean ok() {
        return ok;
    }

    /**
     * Método alternativo para crear robot directamente
     */
    public Robot createRobot(int id, int position) {
        return placeRobot(id, position);
    }
    
    /**
     * Método alternativo para crear store directamente
     */
    public Store createStore(int id, int position, int tenges) {
        return placeStore(id, position, tenges);
    }
    
    /**
     * Obtener robot por ID
     */
    public Robot getRobot(int id) {
        return findRobotById(id);
    }
    
    /**
     * Obtener store por ID
     */
    public Store getStore(int id) {
        return stores.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    /**
     * Obtiene las estadísticas de visitas (para requisito 12)
     */
    public Map<Integer, Integer> getVisitCounts() {
        return new HashMap<>(robotVisitCounts);
    }

    /**
     * Obtiene las ganancias de robots (para requisito 13)
     */
    public Map<Integer, Integer> getRobotEarnings() {
        return new HashMap<>(robotEarnings);
    }
    
    /**
     * Obtiene la ruta óptima calculada (para requisito 10)
     */
    public List<Integer> getOptimalPath() {
        return new ArrayList<>(optimalPath);
    }
}