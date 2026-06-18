/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.untels.utils;


/**
 *
 * @author Alumno
 */
public class Utilitarios {
    public static void volver(){
        System.out.println("Volver al MENU PRINCIPAL.");
    }
    public static void salir(){
        System.out.println("Gracias por su visita.");
    }
    public static void error(int tipo){
        System.out.println("Error");
        switch (tipo) {
            case 1 -> System.out.println("Opcion invalida");
            default -> System.out.println("--");
        }
    }
    public static void lineasenblanco(int cantidad){
        for (int i = 1; i <=cantidad; i++){ 
            System.out.println("");
        }
    }   
}
