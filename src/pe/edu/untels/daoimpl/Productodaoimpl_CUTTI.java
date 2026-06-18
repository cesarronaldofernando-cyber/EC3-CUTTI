package pe.edu.untels.daoimpl;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.untels.config.bd.ConectarBD;
import pe.edu.untels.dao.Productodao_CUTTI;
import pe.edu.untels.modelo.Producto_CUTTI;




/**
 *
 * @author Alumno
 */
public class Productodaoimpl_CUTTI implements Productodao_CUTTI{
    ConectarBD cn = new ConectarBD();
    Connection c = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public List<Producto_CUTTI> listar() {
        List<Producto_CUTTI> producto_CUTTIs = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM PRODUCTO
                     ORDER BY NOMBRE
                     """;
        try {
            c = cn.getConnection();
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Producto_CUTTI producto_CUTTI=new Producto_CUTTI();
                producto_CUTTI.setIdproducto(rs.getInt("Idproducto"));
                producto_CUTTI.setNombre(rs.getString("Nombre")); 
                producto_CUTTI.setCantidad(rs.getInt("Cantidad"));
                producto_CUTTI.setPrecio(rs.getDouble("Precio"));
                producto_CUTTI.setPais(rs.getString("Pais"));
                producto_CUTTIs.add(producto_CUTTI);
            }
            rs.close();
            pst.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudo listar.");
        }
        return producto_CUTTIs;
    }

    @Override
    public boolean agregar(Producto_CUTTI producto_CUTTI) {
        String sql = """
                     INSERT INTO PRODUCTO(NOMBRE,CANTIDAD,PRECIO,PAIS)
                     VALUES(?,?,?,?)
                     """;
        try {
            c = cn.getConnection();
            pst = c.prepareStatement(sql);
            pst.setString(1, producto_CUTTI.getNombre());
            pst.setInt(2, producto_CUTTI.getCantidad());
            pst.setDouble(3, producto_CUTTI.getPrecio());
            pst.setString(4, producto_CUTTI.getPais());
            pst.executeUpdate();
            System.out.println("<Se agrego un nuevo producto a la BD>");
            pst.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("<No se pudo agregar un nuevo producto a la BD>");
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int idproducto) {
        String sql = """
                     DELETE FROM PRODUCTO
                     WHERE 
                     IDPRODUCTO = ?""";
        
        try {
            c = cn.getConnection();
            pst = c.prepareStatement(sql);
            pst.setInt(1, idproducto);
            pst.executeUpdate();
            System.out.println("<Se elimino el registro de un producto en la BD>");
            pst.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("<No se pudo eliminar el registro de un producto>");
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Producto_CUTTI producto_CUTTI)  {
        String sql = """
                     UPDATE PRODUCTO
                     SET
                     NOMBRE=?,
                     CANTIDAD=?,
                     PRECIO=?,
                     PAIS=?
                     WHERE 
                     IDPRODUCTO=?
                     """;
        try {
            c = cn.getConnection();
            pst = c.prepareStatement(sql);
            pst.setString(1, producto_CUTTI.getNombre());
            pst.setInt(2, producto_CUTTI.getCantidad());
            pst.setDouble(3, producto_CUTTI.getPrecio());
            pst.setString(4, producto_CUTTI.getPais());
            pst.setInt(5, producto_CUTTI.getIdproducto()); 
            pst.executeUpdate();
            System.out.println("<Se edito el registro de un producto en la BD>");
    
            pst.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("<No se pudo editar el registro de un producto>");
            return false;
        }
        return true;
    }

    
    
}
