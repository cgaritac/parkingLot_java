/*
Universidad: UNED
Curso:        Programación Intermedia 
Código:       00824
Tema:         Proyecto Programado (I Parcial)
Estudiante:   Carlos Garita Campos
Periodo:      I Cuatrimestre 2020
 */
package proyectoprogramado;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author cgari
 */
public class ProyectoProgramado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String repetir = "N";
        String opcionIngresoSalida, placa;
        int fila = 0, columna = 0, horaEntrada, horaSalida, montoTotal = 0;
        boolean error = true;

        Scanner sc = new Scanner(System.in);
        ManejoDatos manejoDatos = new ManejoDatos();
        Vehiculo vehiculo = new Vehiculo();

        System.out.println("Sistema Manejo de Espacios Parqueo El Ángel\n");

        do {
            System.out.println("\nEstado del parqueo\n");
            manejoDatos.muestraParqueo();

            do {
                error = true;
                System.out.println("Ingrese la letra 'I' para ingreso de vehículo o 'S' para salida de vehículo:");
                opcionIngresoSalida = sc.nextLine();
                opcionIngresoSalida = opcionIngresoSalida.toUpperCase();

                if (opcionIngresoSalida.equals("I") || opcionIngresoSalida.equals("S")) {
                    error = false;
                } else {
                    System.out.println("\nError!, opción no válida, seleccione la opción correcta\n");
                }
            } while (error == true);

            do {
                do {
                    try {
                        System.out.println("Digite la fila [0 a 2] asignada para el vehículo:");
                        fila = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        fila = -1;
                        sc.nextLine();
                    }

                    if (fila < 0 || fila > 3) {
                        System.out.println("\nError!, opción no válida, seleccione la opción correcta\n");
                    } else {
                    }
                } while (fila < 0 || fila > 3);
                do {
                    try {
                        System.out.println("Digite la columna [0 a 9] asignada para el vehículo:");
                        columna = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        columna = -1;
                        sc.nextLine();
                    }
                    if (columna < 0 || columna > 10) {
                        System.out.println("\nError!, opción no válida, seleccione la opción correcta\n");
                    } else {

                    }
                } while (columna < 0 || columna > 10);

                if(manejoDatos.verificarEspacio(fila+1, columna+2) == false && opcionIngresoSalida.equals("I")){
                    System.out.println("\nError!, opción el espacio ya se encuentra ocupado, por favor seleccione otro espacio\n");
                }
            } while (manejoDatos.verificarEspacio(fila+1, columna+2) == false && opcionIngresoSalida.equals("I"));

            fila = fila + 1;
            vehiculo.setFila(fila);
            columna = columna + 2;
            vehiculo.setColumna(columna);

            if (opcionIngresoSalida.equals("I")) {
                do {
                    error = true;
                    System.out.println("Ingrese el número de placa del vahículo:");
                    placa = sc.nextLine();
                    placa = placa.toUpperCase();

                    if (placa.equals("")) {
                        error = true;
                        System.out.println("\nError!, opción no válida, seleccione la opción correcta\n");
                    } else {
                        error = false;
                        vehiculo.setPlacaVehiculo(vehiculo.getFila(), vehiculo.getColumna(), placa);
                    }
                } while (error == true);

                do {
                    try {
                        System.out.println("Digite la hora [0 a 24] de entrada:");
                        horaEntrada = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        horaEntrada = -1;
                        sc.nextLine();
                    }
                    if (horaEntrada < 0 || horaEntrada > 24) {
                        System.out.println("\nError!, valor de hora no válido\n");
                    } else {
                        vehiculo.setHoraEntrada(vehiculo.getFila(), vehiculo.getColumna(), horaEntrada);
                    }
                } while (horaEntrada < 0 || horaEntrada > 24);

                manejoDatos.ingresarVehiculo(vehiculo.getFila(), vehiculo.getColumna());
            }

            if (opcionIngresoSalida.equals("S")) {
                
                if(manejoDatos.verificarEspacio(fila, columna) == true){
                    System.out.println("El espacio no se encuentra ocupado");
                }
                
               if(manejoDatos.verificarEspacio(fila, columna) == false){
                    do {
                    try {
                        System.out.println("Digite la hora [0 a 24] de salida:");
                        horaSalida = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        horaSalida = -1;
                        sc.nextLine();
                    }
                    if (horaSalida < 0 || horaSalida > 24) {
                        System.out.println("\nError!, valor de hora no válido\n");
                    } else {
                        vehiculo.setHoraSalida(horaSalida);
                    }
                } while (horaSalida < 0 || horaSalida > 24);

                montoTotal = manejoDatos.montoTotalPagar(vehiculo.getFila(), vehiculo.getColumna(), vehiculo.getHoraEntrada(vehiculo.getFila(), vehiculo.getColumna()), vehiculo.getHoraSalida());
                
                if(montoTotal==0){
                    montoTotal = 500;
                }
                
                }            
            }

            System.out.println("\nMonto por hora: 500 colones\n");

            if (opcionIngresoSalida.equals("S")) {
                System.out.println("Monto total a pagar del vehículo placa "+vehiculo.getPlacaVehiculo(vehiculo.getFila(), vehiculo.getColumna())+" es de: " + montoTotal + " colones\n");
                manejoDatos.limpiarEspacio(vehiculo.getFila(), vehiculo.getColumna());
            }

            System.out.println("\n*********************************************************************\n");

            do {
                error = true;
                System.out.println("¿Desea ingresar otro vehículo? S/N");                
                repetir = sc.nextLine();
                repetir = repetir.toUpperCase();

                if (repetir.equals("S") || repetir.equals("N")) {
                    error = false;
                } else {
                    System.out.println("\nError!, opción no válida, seleccione la opción correcta\n");
                }
            } while (error == true);

        } while (repetir.equals("S"));
    }

}
