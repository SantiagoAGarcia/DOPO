# DOPO
Repositorio creado para el proyecto y los distintos ciclos


Retrospectiva ciclo 2:
### 1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.

## 1. CICLO DE CREACIÓN DE OBJETOS

### 1.1 Mini-Ciclo de Inicialización del Mapa
**Secuencia:** `SilkRoad()` → `ok()` → `makeVisible()`
- **Propósito:** Crear la estructura base del mapa con dimensiones válidas
- **Funciones:** Inicializar la matriz del mapa, validar dimensiones mínimas/máximas, crear la cuadrícula de coordenadas
- **Validación:** Verificar que el mapa tenga dimensiones apropiadas y estructura correcta

### 1.2 Mini-Ciclo de Posicionamiento del Robot
**Secuencia:** `placeRobot()` → `getBestRobot()` → `reboot()`
- **Propósito:** Ubicar y configurar el robot en su posición inicial
- **Funciones:** Colocar robot en coordenadas de inicio, validar que la posición esté libre, inicializar atributos del robot
- **Validación:** Confirmar que el robot esté correctamente posicionado y configurado

### 1.3 Mini-Ciclo de Distribución de Tiendas
**Secuencia:** `placeStore()` → `getBestStore()` → `stores()`
- **Propósito:** Distribuir estratégicamente las tiendas en el mapa
- **Funciones:** Calcular posiciones óptimas, evitar solapamiento, asegurar accesibilidad desde el camino principal
- **Validación:** Verificar que todas las tiendas sean accesibles y estén bien distribuidas

### 1.4 Mini-Ciclo de Inicialización de Recursos
**Secuencia:** `resupplyStores()` → `removeStore()` → `robots()`
- **Propósito:** Configurar los recursos y precios iniciales del sistema
- **Funciones:** Asignar productos a tiendas, establecer precios base, configurar inventarios
- **Validación:** Confirmar que todos los recursos estén correctamente asignados

## 2. CICLO DE MOVIMIENTO OPTIMIZADO

### 2.1 Mini-Ciclo de Análisis del Entorno
**Secuencia:** `robotsIn()` → `stores()` → `moveRobot()`
- **Propósito:** Analizar el entorno inmediato del robot para toma de decisiones
- **Funciones:** Identificar robots en ubicación, listar tiendas disponibles, preparar movimiento básico
- **Validación:** Asegurar que el análisis sea preciso y completo

### 2.2 Mini-Ciclo de Cálculo de Rutas
**Secuencia:** `calculateOptimalPath()` → `moveRobotOptimized()` → `returnHome()`
- **Propósito:** Determinar y ejecutar la mejor ruta considerando múltiples factores
- **Funciones:** Aplicar algoritmos de pathfinding, ejecutar movimiento optimizado, regresar a casa
- **Validación:** Verificar que la ruta seleccionada sea óptima y factible

### 2.3 Mini-Ciclo de Gestión de Posición
**Secuencia:** `removeRobot()` → `dropRobot()` → `finish()`
- **Propósito:** Gestionar cambios de posición y finalización de tareas
- **Funciones:** Remover robot de posición actual, soltar robot en nueva ubicación, finalizar operación
- **Validación:** Confirmar que los cambios de posición se ejecuten correctamente

### 2.4 Mini-Ciclo de Visualización Dinámica
**Secuencia:** `moveRobotOptimizedColored()` → `makeVisible()` → `makeInvisible()`
- **Propósito:** Controlar la visualización del movimiento del robot
- **Funciones:** Ejecutar movimiento con colores, mostrar elementos, ocultar elementos
- **Validación:** Verificar que la visualización sea clara y funcional

## 3. CICLO DE CONSULTA

### 3.1 Mini-Ciclo de Procesamiento de Consultas
**Secuencia:** `consult()` → `consultSilkRoad()` → `ok()`
- **Propósito:** Procesar y validar las consultas del usuario
- **Funciones:** Realizar consulta básica, consultar información específica del camino de seda, validar operación
- **Validación:** Asegurar que la consulta sea válida y procesable

### 3.2 Mini-Ciclo de Análisis de Rendimiento
**Secuencia:** `calculateMaxProfit()` → `getBestRobot()` → `getBestStore()`
- **Propósito:** Analizar el rendimiento económico y seleccionar mejores opciones
- **Funciones:** Calcular ganancia máxima, identificar mejor robot, identificar mejor tienda
- **Validación:** Confirmar que los análisis sean matemáticamente correctos

### 3.3 Mini-Ciclo de Análisis de Recursos
**Secuencia:** `getBestStore()` → `stores()` → `robots()`
- **Propósito:** Analizar y consultar el estado de recursos del sistema
- **Funciones:** Identificar mejor tienda, listar todas las tiendas, listar todos los robots
- **Validación:** Verificar que los datos de recursos sean precisos y actuales

### 3.4 Mini-Ciclo de Gestión del Sistema
**Secuencia:** `create()` → `ok()` → `reboot()`
- **Propósito:** Gestionar operaciones generales del sistema
- **Funciones:** Crear nuevos elementos, verificar estado del sistema, reiniciar sistema
- **Validación:** Confirmar que las operaciones del sistema funcionen correctamente

## 2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?
Estado actual: Casi COMPLETADO

Funcionalidad básica implementada (creación de robots/stores)
Extensiones de requisitos funcionales (10, 11, 12, 13) implementadas
Integración con BlueJ funcional
Todas las clases modificadas y compatibles

## 3. ¿Cual fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)

Invertimos 8 horas Sergio Buitrago y 8 horas Santiago Garcia

## 4. ¿Cuál consideran fue el mayor logro? ¿Por qué?

Mayor logro: Implementación completa de los requisitos funcionales extendidos

## 5. ¿Qué consideran que es el mayor problema técnico? ¿Qué hicieron para resolverlo?
Mayor problema: Compatibilidad con BlueJ y gestión de tipos de datos
Soluciones implementadas:

Problema de getPosition(): Creé métodos específicos (getPositionX()) para evitar conflictos
Integración de objetos: Modifiqué métodos para retornar objetos (Robot, Store) directamente
Manejo de estados: Implementé tracking de estados con isRemoved(), isActive()
Estructuras de datos: Uso de HashMap y List para estadísticas eficientes

## 6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
Lo que hicimos bien:

Análisis completo de requisitos antes de implementar
Código modular y bien documentado
Pruebas incrementales de cada funcionalidad
Mantenimiento de compatibilidad con código original

Compromisos de mejora:

Implementar más casos de prueba automatizados
Mejorar documentación con ejemplos de uso
Optimizar algoritmos de pathfinding para mejor rendimiento

## 7. Considerando las instancias XP incluidas, ¿cuál fue la más difícil?, ¿cuál la más útil?
Más difícil: Integración continua con BlueJ

Requirió múltiples iteraciones para que los objetos aparezcan correctamente
Manejo de tipos de retorno y compatibilidad de métodos

Más útil: Refactoring iterativo

Permitió mejorar el diseño sin romper funcionalidad existente

## 8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.
Referencias principales:

Oracle Java Documentation (2023). Java Collections Framework. Oracle Corporation.

BlueJ Documentation (2023). BlueJ User Manual. University of Kent.

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
