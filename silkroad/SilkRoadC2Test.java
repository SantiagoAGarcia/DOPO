
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Clase de pruebas unitarias para la clase SilkRoad.
 * Estas pruebas cubren los requisitos de la simulación SilkRoad.
 * 
 * @version 1.0
 */
public class SilkRoadC2Test {

    private SilkRoad silkRoad;

    @BeforeEach
    public void setUp() {
        // Inicializar la simulación antes de cada prueba.
        silkRoad = new SilkRoad(10); // Simulación con 10 días.
    }

    /**
     * Test para verificar que al colocar una tienda, esta se agrega correctamente.
     */
    @Test
    public void accordingDAShouldAddStoreCorrectly() {
        Store store = silkRoad.placeStore(1, 5, 50);
        assertNotNull(store, "Store should be created.");
        assertEquals(1, store.getId(), "Store ID should match.");
        assertEquals(5, store.getPositionX(), "Store position should match.");
        assertEquals(50, store.getTenges(), "Store tenges should match.");
    }

    /**
     * Test para verificar que al eliminar una tienda, esta se elimina correctamente.
     */
    @Test
    public void accordingDAShouldRemoveStoreCorrectly() {
        silkRoad.placeStore(1, 5, 50);
        silkRoad.removeStore(1);
        assertNull(silkRoad.getStore(1), "Store should be removed from the list.");
    }

    /**
     * Test para verificar que un robot se mueve correctamente a una nueva posición.
     */
    @Test
    public void accordingDBShouldMoveRobotCorrectly() {
        Robot robot = silkRoad.placeRobot(1, 0);
        silkRoad.moveRobot(1, 5); // Mover robot a posición 5
        assertEquals(5, robot.getPosition().getX(), "Robot's position should be updated.");
    }

    /**
     * Test para verificar que un robot se mueve de manera optimizada maximizando las ganancias.
     */
    @Test
    public void accordingDBShouldMoveRobotOptimally() {
        // Crear tiendas
        silkRoad.placeStore(1, 3, 20);
        silkRoad.placeStore(2, 6, 50);
        silkRoad.placeStore(3, 9, 10);
        
        // Crear robot
        Robot robot = silkRoad.placeRobot(1, 0);
        
        // Mover robot de forma optimizada hacia la tienda en posición 6 (con 50 tenges)
        silkRoad.moveRobotOptimized(1, 6);
        
        // El robot debería haber ganado 50 tenges al visitar la tienda en posición 6
        assertEquals(50, robot.getCollectedTenges(), "Robot should collect 50 tenges.");
    }

    /**
     * Test para verificar que al consultar la ruta óptima, se genera correctamente.
     */
    @Test
    public void accordingDAShouldCalculateOptimalPath() {
        silkRoad.placeStore(1, 1, 10);
        silkRoad.placeStore(2, 4, 20);
        silkRoad.placeStore(3, 7, 30);
        
        silkRoad.consultSilkRoad(); // Llamar para calcular la ruta óptima
        
        List<Integer> optimalPath = silkRoad.getOptimalPath();
        assertNotNull(optimalPath, "Optimal path should not be null.");
        assertEquals(3, optimalPath.size(), "There should be 3 stores in the optimal path.");
    }

    /**
     * Test para verificar que se calculan correctamente las ganancias de un robot.
     */
    @Test
    public void accordingDBShouldTrackRobotEarnings() {
        // Crear tiendas
        silkRoad.placeStore(1, 5, 50);
        silkRoad.placeStore(2, 8, 70);
        
        // Crear robot
        Robot robot = silkRoad.placeRobot(1, 0);
        
        // Mover robot a la tienda en posición 5
        silkRoad.moveRobot(1, 5);
        
        // El robot debería haber ganado 50 tenges
        assertEquals(50, robot.getCollectedTenges(), "Robot should collect 50 tenges.");

        // Mover robot a la tienda en posición 8
        silkRoad.moveRobot(1, 8);
        
        // El robot debería haber ganado 70 tenges
        assertEquals(120, robot.getCollectedTenges(), "Robot should collect a total of 120 tenges.");
    }

    /**
     * Test para verificar que el método `getBestRobot` devuelve el robot con las mayores ganancias.
     */
    @Test
    public void accordingDAShouldReturnBestRobot() {
        silkRoad.placeStore(1, 5, 50);
        silkRoad.placeStore(2, 8, 70);
        
        Robot robot1 = silkRoad.placeRobot(1, 0);
        Robot robot2 = silkRoad.placeRobot(2, 2);
        
        silkRoad.moveRobot(1, 5);  // Robot 1 gana 50 tenges
        silkRoad.moveRobot(2, 8);  // Robot 2 gana 70 tenges
        
        Robot bestRobot = silkRoad.getBestRobot();
        
        assertEquals(robot2.getId(), bestRobot.getId(), "Robot 2 should be the best robot with the highest earnings.");
    }
}