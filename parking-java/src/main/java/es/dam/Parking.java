package es.dam;

import java.util.Scanner;

/**
 * @author ahdodev
 * @version 1.0.0
 */

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float tarifaHora = 1.50f;
        int totalVehiculos = 0;
        int totalHorasRegistradas = 0;
        int totalCalculosTarifa = 0;
        float importeTotalCalculado = 0f;

        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Hola " + nombre);

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    int cantidad = leerEnteroPositivo(scanner, "¿Cuántos vehículos quieres registrar? ");
                    int horasOperacion = registrarVehiculos(scanner, cantidad);

                    totalVehiculos += cantidad;
                    totalHorasRegistradas += horasOperacion;

                    System.out.println("Vehículos registrados: " + cantidad);
                    break;

                case 2:
                    int horasTarifa = leerEnteroPositivo(scanner, "Horas para calcular la tarifa: ");
                    float importe = calcularTarifa(horasTarifa, tarifaHora);

                    totalCalculosTarifa++;
                    importeTotalCalculado += importe;

                    System.out.println("Importe: " + importe + " euros");
                    break;
                case 3:
                    mostrarResumen(nombre, totalVehiculos, totalHorasRegistradas,
                            totalCalculosTarifa, importeTotalCalculado);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar PARKING DAM-PRO");
                    break;

                    default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
        scanner.close();
    }

    /**
     * Enseña al usuario el menú con las 4 opciones.
     */
    public static void mostrarMenu() {
        System.out.println("=== PARKING DAM PRO ===");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Calcular tarifa");
        System.out.println("3. Ver resumen del día");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");


    }

    /**
     * Pide un numero entero y no deja seguir hasta que sea mayor que 0
     * Si pones 0 o un negativo, avisa al usuario y lo vuelve a pedir
     * @param scanner Para leer lo que escribe el usuario.
     * @param mensaje La pregunta que se le enseña al usuario
     * @return con esto ya asegura que el número es positivo.
     */
    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        int numero = scanner.nextInt();
        scanner.nextLine();

        while (numero <= 0) {
            System.out.println("Debe ser un número positivo.");
            System.out.print(mensaje);
            numero = scanner.nextInt();
            scanner.nextLine();
        }

        return numero;
    }

    /**
     * Pide la matrícula y las horas de cada vehículo con un for
     * @param scanner Para leer lo que escribe el usuario
     * @param cantidad Cuandtos vehículos hay que registrar
     * @return Esto da el total de horas de los vehículos registrados esta vez
     */
    public static int registrarVehiculos(Scanner scanner, int cantidad) {
        int horasOperacion = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Vehículo " + i);
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            int horas = leerEnteroPositivo(scanner, "Horas estacionadas: ");
            horasOperacion += horas;
        }

        return horasOperacion;
    }

    /**
     * Calcula lo que hay qe pagar multiplicando las horas por el precio de la hora
     * @param horas Las horas en las que ha estado aparcado
     * @param tarifaHora  Lo que cuesta cada hora (1,50€)
     * @return  el importe a pagar
     */
    public static float calcularTarifa(int horas, float tarifaHora) {
        return horas * tarifaHora;
    }

    /**
     * Enseña el resumén de todo
     * @param nombre El nombre del usuario
     * @param totalVehiculos Cuantos vehículos se registran
     * @param totalHorasRegistradas La suma de todas las horas registradas
     * @param totalCalculosTarifa Cuantas tarifas se han calculado
     * @param importeTotalCalculado El dinero total de todas las tarifas
     */
    public static void mostrarResumen(String nombre, int totalVehiculos, int totalHorasRegistradas,
                                      int totalCalculosTarifa, float importeTotalCalculado) {
        System.out.println();
        System.out.println("=== RESUMEN DEL DÍA ===");
        System.out.println("Usuario: " + nombre);
        System.out.println("Vehículos registrados: " + totalVehiculos);
        System.out.println("Horas registradas: " + totalHorasRegistradas);
        System.out.println("Cálculos de tarifas: " + totalCalculosTarifa);
        System.out.println("Importe total calculado: " + importeTotalCalculado + " euros");
    }
}


