/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.untels.config.bd;
import java.sql.*;
/**
 *
 * @author Alumno
 */
public class ConectarBD {
    private static Connection c = null;
    private static final String BD = "Academico.db";
    private static final String DRIVER="org.sqlite.JDBC";
    private static final String URL="jdbc:sqlite:";
    public Connection getConnection(){
        try{
            Class.forName(DRIVER);
            c=DriverManager.getConnection(URL+BD);
            
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        System.out.println("<Base de Datos:"+BD+"OK>");
        return c;
    }
    
}
