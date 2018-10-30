/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public String Inserir_Cliente(Cliente a){
        String sql = "INSERT INTO cliente VALUES(0,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNascimento());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getCPF());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getTelefone());
            ps.setString(7, a.getBairro());
            ps.setString(8, a.getRua());
            ps.setInt(9, a.getNumero());
            ps.setString(10, a.getCEP());
              
            if(ps.executeUpdate() > 0){
                return "inserido com sucesso.";
            }else{
                return "erro ao inserir";
            }
              
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private Object getCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
