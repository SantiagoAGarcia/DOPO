# DOPO
Repositorio creado para el proyecto y los distintos ciclos


Retrospectiva ciclo 2:
1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.
Mini-ciclos identificados:

Ciclo de creación de objetos: placeRobot() → placeStore() → inicialización
Ciclo de movimiento optimizado: moveRobotOptimized() → calculateOptimalPath() → actualización de estadísticas
Ciclo de consulta: consult() → consultSilkRoad() → análisis de datos

Justificación: Cada mini-ciclo representa una funcionalidad completa que se puede probar independientemente y aporta valor incremental al sistema.
2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?
Estado actual: Casi COMPLETADO

Funcionalidad básica implementada (creación de robots/stores)
Extensiones de requisitos funcionales (10, 11, 12, 13) implementadas
Integración con BlueJ funcional
Todas las clases modificadas y compatibles

3. ¿Cual fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)

Invertimos 8 horas Sergio Buitrago y 8 horas Santiago Garcia

4. ¿Cuál consideran fue el mayor logro? ¿Por qué?
Mayor logro: Implementación completa de los requisitos funcionales extendidos

5. ¿Qué consideran que es el mayor problema técnico? ¿Qué hicieron para resolverlo?
Mayor problema: Compatibilidad con BlueJ y gestión de tipos de datos
Soluciones implementadas:

Problema de getPosition(): Creé métodos específicos (getPositionX()) para evitar conflictos
Integración de objetos: Modifiqué métodos para retornar objetos (Robot, Store) directamente
Manejo de estados: Implementé tracking de estados con isRemoved(), isActive()
Estructuras de datos: Uso de HashMap y List para estadísticas eficientes

6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
Lo que hicimos bien:

Análisis completo de requisitos antes de implementar
Código modular y bien documentado
Pruebas incrementales de cada funcionalidad
Mantenimiento de compatibilidad con código original

Compromisos de mejora:

Implementar más casos de prueba automatizados
Mejorar documentación con ejemplos de uso
Optimizar algoritmos de pathfinding para mejor rendimiento

7. Considerando las instancias XP incluidas, ¿cuál fue la más difícil?, ¿cuál la más útil?
Más difícil: Integración continua con BlueJ

Requirió múltiples iteraciones para que los objetos aparezcan correctamente
Manejo de tipos de retorno y compatibilidad de métodos

Más útil: Refactoring iterativo

Permitió mejorar el diseño sin romper funcionalidad existente

8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.
Referencias principales:

Oracle Java Documentation (2023). Java Collections Framework. Oracle Corporation.

BlueJ Documentation (2023). BlueJ User Manual. University of Kent.

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
