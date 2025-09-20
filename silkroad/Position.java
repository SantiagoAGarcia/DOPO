/**
 * Representa una posición en 1D (solo eje X).
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class Position {
    private int xPosition;
    
    public Position(int x) {
        this.xPosition = x;
    }
    
    public int getX() {
        return xPosition;
    }
    
    // Método getValue() agregado para compatibilidad con SilkRoad
    public int getValue() {
        return xPosition;
    }
    
    public void setX(int x) {
        this.xPosition = x;
    }
    
    public int distanceToOther(Position other) {
        return Math.abs(this.xPosition - other.xPosition);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return xPosition == position.xPosition;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(xPosition);
    }
    
    @Override
    public String toString() {
        return "Position(" + xPosition + ")";
    }
}