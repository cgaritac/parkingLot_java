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
public class ManejoDatos extends Vehiculo {
    
    private static String parqueo[][] = {
        {"F/C"," ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
        {"0  ", " ","O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
        {"1  ", " ","O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
        {"2  ", " ","O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}
    };
     
    public ManejoDatos() {       

    }    
       
    public void muestraParqueo(){
        for(int i = 0; i < 4; i++){            
            for (int j = 0; j < 12; j++){
                System.out.print(this.parqueo[i][j]+" ");
            }            
            System.out.println("\n");
        }    
    }
    
    public boolean verificarEspacio(int fila, int columna){        
        if (this.parqueo[fila][columna].equals("O")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void ingresarVehiculo(int fila, int columna){
        this.parqueo[fila][columna] = "X";         
    }
    
    public int montoTotalPagar(int fila, int columna, int horaEntrada, int horaSalida){
        int montoTotal = (horaSalida - horaEntrada)*500;
        if(montoTotal==0){
            return montoTotal = 500;
        }else{
            return montoTotal;
        }    
    }
    
    public void limpiarEspacio(int fila, int columna){
        this.parqueo[fila][columna] = "O"; 
        Vehiculo.placaVehiculo[fila][columna] = "O"; 
        Vehiculo.horaEntrada[fila][columna] = 0;
    }
}
