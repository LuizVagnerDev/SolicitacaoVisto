/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author LuizVagner
 */
public class Conexao {
    
     private Connection conn;

private String url = "jdbc:mysql://127.0.0.1:3306/solicitacaodevisto";
private String user = "root";
private String password = "Gigi@2010";
    
     public Connection getConectar(){
       try{
           conn = DriverManager.getConnection(url, user, password);
             
           return conn;
           
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ");
           return null;
           
       }
       
   }
}
