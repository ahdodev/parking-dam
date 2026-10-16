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

        System.out.println("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Hola " + nombre);

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos vehículos quieres registrar? ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    while (cantidad <= 0) {
                        System.out.println("Debe ser un número positivo.");
                        System.out.print("¿Cuántos vehículos quieres registrar? ");
                        cantidad = scanner.nextInt();
                        scanner.nextLine();
                    }

                    for (int i = 1; i <= cantidad; i++) {
                        System.out.println("Vehículo " + i);
                        System.out.print("Matrícula: ");
                        String matricula = scanner.nextLine();

                        System.out.print("Horas estacionadas: ");
                        int horas = scanner.nextInt();
                        scanner.nextLine();

                        while (horas <= 0) {
                            System.out.println("Las horas deben ser mayores que 0.");
                            System.out.print("Horas estacionadas: ");
                            horas = scanner.nextInt();
                            scanner.nextLine();
                        }

                        totalVehiculos++;
                        totalHorasRegistradas += horas;
                    }

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
        System.out.println("Elige una opción: ");


    }
}
