/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.untels.config.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class Eliminartabla {
    public static void inicio(){
        ConectarBD cn=new ConectarBD();
        Connection c=null;
        PreparedStatement pst =null;
        try {
            c=cn.getConnection();
            String sql="""
                       DROP TABLE PRODUCTO;
                       """;
            pst=c.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            c.close();
            
        } catch (SQLException e) {
                System.err.println(e.getClass().getName()+":"+e.getMessage());
                System.out.println("Problemas al eliminar la tabla Producto.");
            System.exit(0);
        }
        System.out.println("Tabla eliminada correctamente.");
    }
    
    public static void main(String[] args) {
        inicio();
    }
    
}