/**
 * Representa una tienda en SilkRoad.
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class Store {
    private int id;
    private Position position;
    private int tenges;
    private int initialTenges;
    private Rectangle shape;
    private boolean active;
    
    public Store(int id, int x, int tenges) {
        this.id = id;
        this.position = new Position(x);
        this.tenges = tenges;
        this.initialTenges = tenges;
        this.active = true;
        this.shape = null;
    }
    
    public int getId() {
        return id;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public int getTenges() {
        return tenges;
    }
    
    public int getInitialTenges() {
        return initialTenges;
    }
    
    public void resupply() {
        if (active) {
            tenges = initialTenges;
        }
    }
    
    public void collect() {
        if (active) {
            tenges = 0;
        }
    }
    
    // Método collect que acepta parámetro
    public int collect(int amount) {
        if (!active) return 0;
        
        int collected = Math.min(tenges, amount);
        tenges -= collected;
        return collected;
    }
    
    public void remove() {
        active = false;
        tenges = 0;
    }
    
    public boolean isActive() {
        return active;
    }
    
    // Método isRemoved() requerido por SilkRoad
    public boolean isRemoved() {
        return !active;
    }
    
    // Método para verificar si la tienda tiene tenges disponibles
    public boolean hasStock() {
        return active && tenges > 0;
    }
    
    // Método para obtener la posición como int (usado en algoritmos de pathfinding)
    public int getPositionX() {
        return position.getX();
    }
    
    public void draw() {
        // TODO: gráfico si se desea
    }
    
    @Override
    public String toString() {
        return "Store{id=" + id + ", position=" + position.getX() + 
               ", tenges=" + tenges + ", active=" + active + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Store store = (Store) obj;
        return id == store.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}