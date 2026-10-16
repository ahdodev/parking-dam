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
          System.out.println("=== PARKING DAM PRO ===");
          System.out.println("1. Registrar vehiculo");
          System.out.println("2. Calcular tarifa");
          System.out.println("3. Ver resumen");
          System.out.println("4. Salir");
          System.out.println("Elige una opción: ");
          opcion = scanner.nextInt();
          scanner.nextLine();

          switch (opcion) {
              case 1:
                  System.out.println();
                  break;

          }

      } while (opcion !=4);
    }
}
