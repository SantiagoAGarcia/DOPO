# DOPO
Repositorio creado para el proyecto y los distintos ciclos


Retrospectiva ciclo 2:
1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.

# Mini-Ciclos Expandidos para Simulación del Camino de Seda

## 1. CICLO DE CREACIÓN DE OBJETOS

### 1.1 Mini-Ciclo de Inicialización del Mapa
**Secuencia:** `initializeMap()` → `validateMapDimensions()` → `createMapGrid()`
- **Propósito:** Crear la estructura base del mapa con dimensiones válidas
- **Funciones:** Inicializar la matriz del mapa, validar dimensiones mínimas/máximas, crear la cuadrícula de coordenadas
- **Validación:** Verificar que el mapa tenga dimensiones apropiadas y estructura correcta

### 1.2 Mini-Ciclo de Posicionamiento del Robot
**Secuencia:** `placeRobot()` → `validateRobotPosition()` → `initializeRobotState()`
- **Propósito:** Ubicar y configurar el robot en su posición inicial
- **Funciones:** Colocar robot en coordenadas de inicio, validar que la posición esté libre, inicializar atributos del robot (energía, inventario, etc.)
- **Validación:** Confirmar que el robot esté correctamente posicionado y configurado

### 1.3 Mini-Ciclo de Distribución de Tiendas
**Secuencia:** `placeStore()` → `calculateStoreDistribution()` → `validateStorePositions()`
- **Propósito:** Distribuir estratégicamente las tiendas en el mapa
- **Funciones:** Calcular posiciones óptimas, evitar solapamiento, asegurar accesibilidad desde el camino principal
- **Validación:** Verificar que todas las tiendas sean accesibles y estén bien distribuidas

### 1.4 Mini-Ciclo de Inicialización de Recursos
**Secuencia:** `initializeResources()` → `populateStoreInventories()` → `setInitialPrices()`
- **Propósito:** Configurar los recursos y precios iniciales del sistema
- **Funciones:** Asignar productos a tiendas, establecer precios base, configurar demanda inicial
- **Validación:** Confirmar que todos los recursos estén correctamente asignados

## 2. CICLO DE MOVIMIENTO OPTIMIZADO

### 2.1 Mini-Ciclo de Análisis del Entorno
**Secuencia:** `scanEnvironment()` → `detectObstacles()` → `identifyOpportunities()`
- **Propósito:** Analizar el entorno inmediato del robot para toma de decisiones
- **Funciones:** Escanear casillas adyacentes, detectar obstáculos y tiendas, identificar oportunidades de comercio
- **Validación:** Asegurar que el análisis sea preciso y completo

### 2.2 Mini-Ciclo de Cálculo de Rutas
**Secuencia:** `calculateOptimalPath()` → `evaluateAlternativeRoutes()` → `selectBestPath()`
- **Propósito:** Determinar la mejor ruta considerando múltiples factores
- **Funciones:** Aplicar algoritmos de pathfinding, evaluar rutas alternativas, considerar factores como distancia, tiempo y beneficio comercial
- **Validación:** Verificar que la ruta seleccionada sea óptima y factible

### 2.3 Mini-Ciclo de Ejecución de Movimiento
**Secuencia:** `moveRobotOptimized()` → `updatePosition()` → `validateMovement()`
- **Propósito:** Ejecutar el movimiento físico del robot
- **Funciones:** Mover robot paso a paso, actualizar coordenadas, verificar colisiones
- **Validación:** Confirmar que el movimiento se ejecutó correctamente

### 2.4 Mini-Ciclo de Actualización de Estado
**Secuencia:** `updateRobotStats()` → `updateEnergyConsumption()` → `logMovementData()`
- **Propósito:** Actualizar todas las estadísticas relacionadas con el movimiento
- **Funciones:** Actualizar posición, consumir energía, registrar datos de telemetría
- **Validación:** Verificar que todas las estadísticas estén actualizadas correctamente

## 3. CICLO DE CONSULTA

### 3.1 Mini-Ciclo de Procesamiento de Consultas
**Secuencia:** `consult()` → `parseQuery()` → `validateQueryParams()`
- **Propósito:** Procesar y validar las consultas del usuario
- **Funciones:** Interpretar tipo de consulta, extraer parámetros, validar formato y permisos
- **Validación:** Asegurar que la consulta sea válida y procesable

### 3.2 Mini-Ciclo de Recolección de Datos
**Secuencia:** `consultSilkRoad()` → `gatherSystemData()` → `aggregateInformation()`
- **Propósito:** Recopilar información específica del sistema
- **Funciones:** Acceder a datos del robot, tiendas y mapa, agregar información de múltiples fuentes
- **Validación:** Verificar la integridad y actualidad de los datos

### 3.3 Mini-Ciclo de Análisis Estadístico
**Secuencia:** `analyzePerformanceData()` → `calculateMetrics()` → `generateTrends()`
- **Propósito:** Realizar análisis estadístico de los datos recopilados
- **Funciones:** Calcular métricas de rendimiento, identificar patrones, generar análisis de tendencias
- **Validación:** Confirmar que los análisis sean matemáticamente correctos

### 3.4 Mini-Ciclo de Presentación de Resultados
**Secuencia:** `formatResults()` → `generateVisualizations()` → `deliverResponse()`
- **Propósito:** Formatear y presentar los resultados al usuario
- **Funciones:** Formatear datos en formato legible, crear gráficos/visualizaciones, entregar respuesta completa
- **Validación:** Verificar que la presentación sea clara y precisa

## 4. CICLOS ADICIONALES ESPECIALIZADOS

### 4.1 Mini-Ciclo de Gestión de Comercio
**Secuencia:** `evaluateTradeOpportunities()` → `negotiateTransaction()` → `executeTransaction()`
- **Propósito:** Gestionar las transacciones comerciales del robot
- **Funciones:** Evaluar oportunidades de compra/venta, negociar precios, ejecutar transacciones
- **Validación:** Confirmar que las transacciones sean rentables y válidas

### 4.2 Mini-Ciclo de Gestión de Energía
**Secuencia:** `monitorEnergyLevels()` → `optimizeEnergyUsage()` → `planEnergyRecovery()`
- **Propósito:** Optimizar el uso y recuperación de energía del robot
- **Funciones:** Monitorear niveles de energía, aplicar estrategias de ahorro, planificar paradas de recarga
- **Validación:** Asegurar que el robot mantenga niveles de energía adecuados

### 4.3 Mini-Ciclo de Manejo de Errores
**Secuencia:** `detectErrors()` → `classifyErrors()` → `executeRecoveryAction()`
- **Propósito:** Detectar, clasificar y recuperarse de errores del sistema
- **Funciones:** Identificar anomalías, clasificar tipo de error, aplicar estrategias de recuperación
- **Validación:** Verificar que los errores se manejen apropiadamente

### 4.4 Mini-Ciclo de Optimización Dinámica
**Secuencia:** `assessPerformance()` → `identifyBottlenecks()` → `applyOptimizations()`
- **Propósito:** Mejorar continuamente el rendimiento del sistema
- **Funciones:** Evaluar rendimiento actual, identificar cuellos de botella, aplicar optimizaciones en tiempo real
- **Validación:** Confirmar que las optimizaciones mejoren efectivamente el rendimiento

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
