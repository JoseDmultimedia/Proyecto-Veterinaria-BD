/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;


/**
 *
 * @author chiom
 */
public class ConnectBD {
    
    Connection conexion;
    Statement st;

    public Statement getSt() {
        return st;
    }

    public ConnectBD() {
        //conexion
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/veterinaria", "root", "root");
            st = conexion.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
}
