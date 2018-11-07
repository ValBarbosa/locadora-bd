/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
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
      public class ClassificacaoDAO extends ExecuteSQL {
          public ClassificacaoDAO(Connection con){
        super(con);
    }
    public String Inserir_Classificacao(Classificacao a){
        String sql = "INSERT INTO classificacao VALUES(0,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
              
            if(ps.executeUpdate() > 0){
                return "inserido com sucesso.";
            }else{
                return "erro ao inserir";
            }
              
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
         public List<Classificacao> ListarClassificacao(){
          String sql ="select idclassificacao,nome from classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
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
         
         public List<Classificacao> ListarComboClassificacao(){
             String sql = "select nome from categoria order by nome preco";
             List<Classificacao> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while (rs.next()){
                         Classificacao a = new Classificacao();
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
         public List<Classificacao> ConsultaCodigoClassificacao(String codigo){
             String sql = "select idclassificacao from classificacao where nome = '"+ codigo + "'";
             List<Classificacao> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while(rs.next()){
                         Classificacao a = new Classificacao();
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
         public String Excluir_Classificacao(Classificacao a){
             String sql = "delete from classificacao where idclassificacao = ? and nome = ?";
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

