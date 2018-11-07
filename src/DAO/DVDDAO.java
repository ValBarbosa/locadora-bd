/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valéria
 */
public class DVDDAO extends ExecuteSQL {
    public DVDDAO(Connection con){
        super(con);
    }
    public String Inserir_DVD(DVD a){
        String sql = "INSERT INTO dvd VALUES(0,?,?,?,?)";
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
         public List<DVD> ListarDVD(){
          String sql ="select idcliente,nome,rg,cpf,telefone,email from cliente";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    
                    lista.add(a);
                    
                }
                return lista;
            }else{
                return null;
            }
            
            
        } catch (SQLException e) {
            return null;
        }
        

        
    }
         
         public List<DVD> ListarComboCliente(){
             String sql = "select nome from dvd order by nome";
             List<DVD> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while (rs.next()){
                         DVD a = new DVD();
                         a.setNome(rs.getString(1));
                         lista.add(a);
                     }
                     return lista;
                 }else{
                     return null;
                 }
             } catch (Exception e) {
                 return null;
             }
             
         }
         public List<DVD> ConsultaCodigoDVD(String codigo){
             String sql = "select iddvd from dvd where nome = '"+ codigo + "'";
             List<DVD> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while(rs.next()){
                         DVD a = new DVD();
                         a.setCodigo(rs.getInt(1));
                         lista.add(a);
                         
                     }
                     return lista;
                 }else{
                     return null;
                 }
                 
             } catch (Exception e) {
                 return null;
             }
         }
         public String Excluir_DVD(DVD a){
             String sql = "delete from dvd where iddvd = ? and nome = ?";
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ps.setInt(1, a.getCodigo());
                 ps.setString(2, a.getNome());
                 if(ps.executeUpdate() > 0){
                     return "excluido com sucesso";
                 }else{
                     return "erro ao excluir";
                 }
                 
             } catch (SQLException e) {
                 return e.getMessage();
             }
         }

}
