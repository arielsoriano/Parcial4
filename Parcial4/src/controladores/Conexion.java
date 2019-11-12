/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    private static Connection conexion = null;
    private static String connectionString = null;
    public static  Connection conectarDB(){
        connectionString = "jdbc:postgresql://localhost:5432/TrabajoFinal";
        try {
            Class.forName("org.postgresql.Driver"); //Levanta un driven en memoria
            conexion = DriverManager.getConnection(connectionString, "postgres", "50ja10po65n7");
            
            return conexion;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
