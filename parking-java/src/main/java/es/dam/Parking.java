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
                    System.out.println("TEMPORAL -> vehículos: " + totalVehiculos + ", horas: " + totalHorasRegistradas);
                    break;

                case 2:
                    System.out.println("Calcular tarifa (pendiente)");
                    break;
                case 3:
                    System.out.println("Ver resumen (pendiente)");
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

    public static void mostrarMenu() {
        System.out.println("=== PARKING DAM PRO ===");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Calcular tarifa");
        System.out.println("3. Ver resumen del día");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");


    }
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
}


