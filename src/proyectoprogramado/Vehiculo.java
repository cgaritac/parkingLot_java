/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

/**
 *
 * @author cgari
 */
public class Vehiculo {
    protected static String placaVehiculo[][] = {        
        {"F/C"," ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
        {"0  "," ", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
        {"1  "," ", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
        {"2  "," ", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}
    };
    protected static int horaEntrada[][] = {
        {0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private int horaSalida;
    private int fila;
    private int columna;
    private final int montoXhora = 500;

    public Vehiculo() {
    }

    public String getPlacaVehiculo(int fila, int columna) {
        return placaVehiculo[fila][columna];
    }

    public void setPlacaVehiculo(int fila, int columna, String placa) {
        this.placaVehiculo[fila][columna] = placa; 
    }

    public int getHoraEntrada(int fila, int columna) {
        return horaEntrada[fila][columna];
    }

    public void setHoraEntrada(int fila, int columna, int horaEntrada) {
        this.horaEntrada[fila][columna] = horaEntrada;
    }   

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    @Override
    public String toString() {
        return "Vehiculo{" + "placaVehiculo=" + placaVehiculo + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", fila=" + fila + ", columna=" + columna + ", montoXhora=" + montoXhora + '}';
    }    
}
