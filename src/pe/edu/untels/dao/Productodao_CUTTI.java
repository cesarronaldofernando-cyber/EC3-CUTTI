/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.untels.dao;

import java.util.List;
import  pe.edu.untels.modelo.Producto_CUTTI;

/**
 *
 * @author Alumno
 */
public interface Productodao_CUTTI {
    public List listar();
    public boolean agregar(Producto_CUTTI producto_CUTTI);
    public boolean eliminar( int idproducto );
    public boolean editar(Producto_CUTTI producto_CUTTI);
    
}
