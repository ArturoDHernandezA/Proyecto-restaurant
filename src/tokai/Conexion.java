/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokai;

import java.sql.*;
import javax.swing.JComboBox;

/**
 *
 * @author hinse
 */
public class Conexion {
    public static Connection conexion(String controlador, String usuario, String password, String base) {
        Connection BD = null;
        try{
            // SQL
            if (controlador.equals("SQL") == true) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                BD = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=" 
                        + base + ";user=" + usuario + ";password=" + password + ";");
            }
            // MySQL
            if (controlador.equals("MySQL") == true) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                BD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + base, usuario, password);
            }
        }catch (Exception e) {
            System.out.println("Error en conexion " + e);
        }
        return (BD);
    }
    
    public static JComboBox LlenarCB(String query, JComboBox selector, String base, String user, String password, String controlador){
        Connection C = conexion(controlador, user, password, base);
        try{
            if(C != null){
            PreparedStatement B2 = C.prepareStatement(query);
            ResultSet R2 = B2.executeQuery();
            while(R2.next()){
                selector.addItem(R2.getString(1));
            }
            return selector;
        }else{
                System.out.println("No Existe Conexión");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
}
