/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aluno
 */
public class Conector {
    
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "bancokantine";
            String usuario = "root";
            String senha = "";
            
            return DriverManager.getConnection(url+banco,usuario,senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
