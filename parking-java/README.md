# PARKING DAM-PRO — Implementación Java

## 1. Objetivo

Este es mi programa del parking, hecho en Java 21. Al arrancarlo te pide el nombre y te sale un menú con 4 opciones: registrar vehículos, calcular una tarifa (a 1,50 € la hora), ver un resumen de lo que llevas y salir. El menú se va repitiendo hasta que le das a salir.

Es la segunda parte del trabajo. La primera, la de los diagramas, la tienes en el [README principal](../README.md).

## 2. Relación entre diagramas y código

### 2.1. Menú

El menú es el diagrama 2. Lo hice con un do-while porque el menú tiene que salir sí o sí al menos una vez, y luego se repite hasta que eliges la 4. Cada rombo del diagrama (opcion==1, opcion==2...) es un case del switch, y el de "Opción no válida" es el default.

```java
do {
    mostrarMenu();
    opcion = scanner.nextInt();
    scanner.nextLine();
    switch (opcion) {
        // un case para cada opción
    }
} while (opcion != 4);
```

### 2.2. Registro de vehículos

Es el diagrama 3. Aquí usé un for porque ya sé cuántas vueltas va a dar: las que diga el usuario al principio. En cada vuelta pido la matrícula y las horas de un vehículo.

### 2.3. Validaciones y cálculo de tarifas

Las validaciones son los rombos que vuelven para atrás, como "cantidad > 0" o "horas > 0". En el código es un while: si pones un 0 o un negativo, te sale "Debe ser un número positivo." y te lo vuelve a pedir hasta que pongas algo que valga.

La tarifa (diagrama 4) es simplemente las horas por 1,50. Por ejemplo, 2 horas son 3 € y 5 horas son 7,50 €.

### 2.4. Cómo se sale

Cuando eliges la 4 (diagrama 6) sale la despedida, se acaba el bucle y se cierra el Scanner.

Mirando los diagramas de ejemplo me di cuenta de que la opción 4 volvía al menú, y eso no es lo que hace el programa, así que en los míos lo cambié para que vaya al final. También le puse al for su rombo, para que se vea cuándo se sale del bucle.

## 3. Métodos implementados

El main casi no hace nada por su cuenta: pide el nombre, enseña el menú y, según lo que elijas, llama a un método. Los que hacen el trabajo de verdad son los métodos.

### 3.1. mostrarMenu()

Solo enseña las 4 opciones. No le paso nada y no me devuelve nada.

### 3.2. leerEnteroPositivo(...)

Le paso el scanner y la pregunta que quiero hacer. Te pide un número y, si no es mayor que 0, te lo vuelve a pedir. Cuando ya vale, me lo devuelve.

Lo uso para tres cosas: la cantidad de vehículos, las horas de cada vehículo y las horas de la tarifa. Así no tengo el mismo while copiado tres veces.

### 3.3. registrarVehiculos(...)

Le paso el scanner y cuántos vehículos hay que meter. Con el for pide la matrícula y las horas de cada uno, va sumando las horas y al final me devuelve el total.

Aquí me tuve que fijar en una cosa: si le paso los totales al método y los cambio dentro, en el main no cambian, porque Java le pasa una copia. Por eso hago que el método me devuelva las horas, y los totales los sumo yo en el main:

```java
int horasOperacion = registrarVehiculos(scanner, cantidad);
totalVehiculos += cantidad;
totalHorasRegistradas += horasOperacion;
```

### 3.4. calcularTarifa(...)

Le paso las horas y lo que cuesta cada hora, y me devuelve la multiplicación. No pide nada ni imprime nada, solo hace la cuenta. Con 5 horas me devuelve 7.5.

### 3.5. mostrarResumen(...)

Le paso el nombre y los totales y los saca por pantalla: el usuario, los vehículos, las horas, cuántas tarifas he calculado y el dinero total. Solo imprime, no toca nada.

## 4. Pruebas realizadas

Todas las pruebas las hice desde IntelliJ. Algunas las hice seguidas sin cerrar el programa (la 6, 7, 8 y 9 juntas, y la 10 y 11 juntas), por eso los totales se van sumando. Los decimales salen con punto (3.0) porque Java los escribe así.

1. Puse mi nombre, Alvaro, y me saludó con "Hola Alvaro". Bien.
2. Elegí la opción 9 y me salió "Opción no válida." y otra vez el menú. Bien.
3. En la cantidad de vehículos puse 0 y no me dejó. Luego puse 2 y ya sí. Bien.
4. Metí 2 vehículos, uno de 2 horas y otro de 3, y en el resumen salieron 2 vehículos y 5 horas. Bien.
5. En las horas puse -2 y me las volvió a pedir. Luego puse 4 y lo aceptó. Bien.
6. Calculé la tarifa de 2 horas y me salió 3.0 euros. Bien.
7. Calculé la de 5 horas y me salió 7.5 euros. Bien.
8. Puse 0 horas y no me dejó. Luego puse 3 y me salió 4.5 euros. Bien.
9. Después de calcular dos tarifas seguidas, el contador de cálculos estaba en 2. Bien.
10. Registré vehículos y luego calculé una tarifa, y los vehículos y las horas no cambiaron. Bien.
11. Con la opción 3 me salió todo correcto: Alvaro, 2 vehículos, 5 horas, 1 cálculo y 3.0 euros.
12. Con la opción 4 me salió "Gracias por utilizar PARKING DAM-PRO" y se cerró el programa. Bien.

## 5. Historial de desarrollo con Git

He ido haciendo un commit cada vez que acababa una parte y la había probado. Los commits que hice son estos:

- Con "build: crear proyecto Maven parking-java" creé el proyecto Maven dentro del repo.
- Con "build: configurar Java 21 en parking-java" cambié la versión de Java, porque el pom venía con la 27 y la tarea pide la 21.
- Con "feat: implementar menu principal con do-while" hice el menú que se repite.
- Con "feat: registrar vehiculos con for y validar datos" hice la opción 1.
- Con "refactor: mover registro de vehiculos a metodos" pasé la opción 1 a métodos.
- Con "feat: calcular tarifas y acumular importes" hice la opción 2.
- Con "feat: mostrar resumen mediante metodos" hice la opción 3.
- Con "docs: incluir diagramas de flujo del parking" subí los diagramas.

Lo empecé en el ordenador de clase y lo terminé en casa. En casa cloné el repo y, antes de tocar nada, miré que estuvieran todos los commits.

## 6. Dificultades y soluciones

- Las llaves. Una vez metí el método del menú dentro del main sin darme cuenta y no compilaba, y otra vez se me quedó el default fuera del switch por cerrar una llave antes de tiempo. Lo arreglé mirando bien qué llave cerraba cada cosa y con Ctrl+Alt+L, que en IntelliJ te ordena el código y se ve mejor dónde está el fallo.
- Los métodos eran nuevos para mí. Para no liarme, primero hacía cada parte dentro del main, como en las otras tareas, y cuando ya funcionaba la pasaba a un método.
- La versión de Java. El pom venía con Java 27 y la tarea pide la 21, así que la cambié.

## 7. Conclusión

Con esta tarea he pillado para qué sirven los métodos: el main queda mucho más corto y se entiende mejor, y lo que se repite lo escribo una vez y lo uso cuando me hace falta. También he visto la diferencia entre un método que solo hace algo y uno que te devuelve un valor.

De los bucles me quedo con esto: el do-while para el menú, el for cuando sé cuántas vueltas hay y el while para validar. Y con Git he aprendido a ir guardando cada parte por separado y a seguir el trabajo en otro ordenador sin perder nada.