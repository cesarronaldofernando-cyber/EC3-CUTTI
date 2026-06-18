/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.untels.vista;

/**
 *
 * @author Alumno
 */

    
 import java.util.List;
import pe.edu.untels.dao.Productodao_CUTTI;
import pe.edu.untels.daoimpl.Productodaoimpl_CUTTI;
import pe.edu.untels.modelo.Producto_CUTTI;
import pe.edu.untels.utils.Lectura;
import pe.edu.untels.utils.Utilitarios;

/**
 *
 * @author Alumno
 */
public class Indexproducto {
     private static Lectura leer=new Lectura();
     private static Productodao_CUTTI daoimpl= new Productodaoimpl_CUTTI();
     public static void agregar(){
         System.out.println("Agregar producto");
         System.out.println(">Nombre:");
         String nombre=leer.cadena();
         System.out.println(">Cantidad:");
         int cantidad=leer.entero();
         System.out.println(">Precio:");
         double precio=leer.decimal();
         System.out.println(">Pais:");
         String pais=leer.cadena();
         Producto_CUTTI producto_CUTTI=new Producto_CUTTI(cantidad, nombre, cantidad, precio, pais);
         daoimpl.agregar(producto_CUTTI);
        }
     public static void eliminar(){
         listar();
         System.out.println("Indique el ID del producto a eliminar.");
         int id=leer.entero();
         daoimpl.eliminar(id);
         System.out.println("Se elimino correctamente. ");
         
     }
     public static void editar(){
         listar();
         System.out.println("Indique el ID del producto a editar.");
         int id=leer.entero();
         System.out.println("Asignar los datos correctos");
         System.out.println(">Nuevo Nombre:");
         String nombre=leer.cadena();
         System.out.println(">Nueva Cantidad:");
         int cantidad=leer.entero();
         System.out.println(">Nuevo Precio:");
         double precio=leer.decimal();
         System.out.println(">Nuevo Pais:");
         String pais=leer.cadena();
        Producto_CUTTI producto_CUTTI=new Producto_CUTTI(id, nombre, cantidad, precio, pais);
         daoimpl.editar(producto_CUTTI);
         System.out.println("Se edito correctamente.");
         
     }
     public static void listar(){
         List<Producto_CUTTI> producto_CUTTIs=daoimpl.listar();
         System.out.println("Listado de producto");
         System.out.println("#\tID\tNombre\tCantidad\tPrecio\tPais");
         int num=0;
         for (Producto_CUTTI producto_CUTTI : producto_CUTTIs) {
                 num++;
                 System.out.println(num+"\t"
                 +producto_CUTTI.getIdproducto()+"\t"
                 +producto_CUTTI.getNombre()+"\t"
                 +producto_CUTTI.getCantidad()+"\t"
                 +producto_CUTTI.getPrecio()+"\t"
                 +producto_CUTTI.getPais()
                         );
         }
         
     }
     public static void menu(){
         System.out.println("""
                            ***DATOS PRODUCTOS***
                            1.Agregar
                            2.Eliminar
                            3.Editar
                            4.Listar
                            5.Salir""");
         System.out.println("Elija una de las opciones[1-5]:");
     }
    public static void inicio(){
        int opcion;
        do{
            Utilitarios.lineasenblanco(3);
            menu();
            opcion=leer.entero();
            switch (opcion) {
                case 1 -> agregar();
                case 2 -> eliminar();
                case 3 -> editar();
                case 4 -> listar();
                case 5 -> Utilitarios.salir();
                default -> Utilitarios.error(1);
            }
        }while(opcion!=6);
        leer.cerrar();
    }
    
}
