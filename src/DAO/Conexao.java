/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class Conexao {
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/locadora";
            con = (Connection) DriverManager.getConnection(url, "root", "123");
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "erro na conexao com o banco",
            "video locadora", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        
        }
        return con;
    }
    public static void FecharConexao(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}


