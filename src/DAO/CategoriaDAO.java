/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO extends ExecuteSQL  {
    public CategoriaDAO(Connection con){
        super(con);
    }
    public String Inserir_Categoria(Categoria a){
        String sql = "INSERT INTO categoria VALUES(0,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            
              
            if(ps.executeUpdate() > 0){
                return "inserido com sucesso.";
            }else{
                return "erro ao inserir";
            }
              
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
         public List<Categoria> ListarCategoria(){
          String sql ="select idcategoria,nome";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
         
         public List<Categoria> ListarComboCategoria(){
             String sql = "select nome from categoria order by nome";
             List<Categoria> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while (rs.next()){
                         Categoria a = new Categoria();
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
         public List<Categoria> ConsultaCodigoCliente(String nome){
             String sql = "select idcategoria from categoria where nome = '"+ nome + "'";
             List<Categoria> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while(rs.next()){
                         Categoria a = new Categoria();
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
         public String Excluir_Categoria(Categoria a){
             String sql = "delete from categoria where idcliente = ? and nome = ?";
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

