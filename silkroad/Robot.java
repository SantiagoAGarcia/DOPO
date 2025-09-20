import java.util.*;

/**
 * Representa un robot en SilkRoad.
 * Los robots recolectan tenges de las tiendas.
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class Robot {
    private int id;
    private Position position;
    private Position initialPosition;
    private int collectedTenges;
    private Circle shape;
    private boolean active;
    private Set<Integer> visitedStores; // Para rastrear tiendas visitadas
    private List<Position> movementHistory; // Para rastrear historial de movimiento
    
    public Robot(int id, int x) {
        this.id = id;
        this.position = new Position(x);
        this.initialPosition = new Position(x);
        this.collectedTenges = 0;
        this.active = true;
        this.shape = null;
        this.visitedStores = new HashSet<>();
        this.movementHistory = new ArrayList<>();
        this.movementHistory.add(new Position(x)); // Agregar posición inicial
    }
    
    public int getId() {
        return id;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Position getInitialPosition() {
        return initialPosition;
    }
    
    public void moveToNewPos(Position newPos) {
        if (active && newPos != null) {
            this.position = new Position(newPos.getX());
            this.movementHistory.add(new Position(newPos.getX()));
        }
    }
    
    // Método sobrecargado para mover con coordenada int
    public void moveToNewPos(int x) {
        moveToNewPos(new Position(x));
    }
    
    public void reset() {
        this.position = new Position(initialPosition.getX());
        this.collectedTenges = 0;
        this.visitedStores.clear();
        this.movementHistory.clear();
        this.movementHistory.add(new Position(initialPosition.getX()));
    }
    
    public void collect(int tenges) {
        if (active && tenges > 0) {
            collectedTenges += tenges;
        }
    }
    
    // Método para recolectar de una tienda específica
    public int collectFromStore(Store store) {
        if (!active || store == null || store.isRemoved()) {
            return 0;
        }
        
        // Verificar si el robot está en la misma posición que la tienda
        if (position.getX() != store.getPositionX()) {
            return 0;
        }
        
        int collected = store.collect(store.getTenges());
        this.collectedTenges += collected;
        this.visitedStores.add(store.getId());
        
        return collected;
    }
    
    public int getCollectedTenges() {
        return collectedTenges;
    }
    
    public void remove() {
        active = false;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public boolean hasVisited(Store store) {
        return store != null && visitedStores.contains(store.getId());
    }
    
    // Método para verificar si visitó una tienda por ID
    public boolean hasVisitedStore(int storeId) {
        return visitedStores.contains(storeId);
    }
    
    // Métodos para obtener estadísticas del robot
    public Set<Integer> getVisitedStores() {
        return new HashSet<>(visitedStores);
    }
    
    public int getVisitedStoreCount() {
        return visitedStores.size();
    }
    
    public List<Position> getMovementHistory() {
        return new ArrayList<>(movementHistory);
    }
    
    public int getTotalDistanceTraveled() {
        int totalDistance = 0;
        for (int i = 1; i < movementHistory.size(); i++) {
            totalDistance += movementHistory.get(i - 1).distanceToOther(movementHistory.get(i));
        }
        return totalDistance;
    }
    
    // Método para calcular la eficiencia del robot (tenges por distancia)
    public double getEfficiency() {
        int distance = getTotalDistanceTraveled();
        return distance > 0 ? (double) collectedTenges / distance : 0;
    }
    
    // Método para verificar si el robot puede moverse a una posición
    public boolean canMoveTo(Position targetPosition) {
        return active && targetPosition != null;
    }
    
    // Método para obtener la distancia a una tienda
    public int distanceToStore(Store store) {
        if (store == null || store.isRemoved()) {
            return Integer.MAX_VALUE;
        }
        return Math.abs(position.getX() - store.getPositionX());
    }
    
    @Override
    public String toString() {
        return "Robot{id=" + id + ", position=" + position.getX() + 
               ", collectedTenges=" + collectedTenges + ", active=" + active + 
               ", visitedStores=" + visitedStores.size() + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Robot robot = (Robot) obj;
        return id == robot.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}