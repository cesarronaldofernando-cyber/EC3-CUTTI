/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.untels.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Alumno
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto_CUTTI {
    private int idproducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String pais;
    
    
}
