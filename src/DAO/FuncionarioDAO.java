/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ExecuteSQL {
    public FuncionarioDAO(Connection con){
        super(con);
    }
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        try {
            String consulta = "select login, senha from funcionario where login = '" +login +"'and senha = '" + senha + "'";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
       
            if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
                
            }
        }
    
        }catch (SQLException ex) {
            ex.getMessage();
     
        }
        return finalResult;
    }
    public String Inserir_Funcionario(Funcionario a){
        String sql = "INSERT INTO funcionario VALUES(0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
          
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getLogin());
            ps.setString(4, a.getSenha());
              
            if(ps.executeUpdate() > 0){
                return "inserido com sucesso.";
            }else{
                return "erro ao inserir";
            }
              
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
         public List<Funcionario> ListarFuncionario(){
          String sql ="select idfuncionario,nome,login,senha from cliente";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    
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
         
         public List<Funcionario> ListarComboFuncionario(){
             String sql = "select nome from cliente order by nome";
             List<Funcionario> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while (rs.next()){
                        Funcionario  a = new Funcionario();
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
         public List<Funcionario> ConsultaCodigoFuncionario(String cod){
             String sql = "select idfuncionario from funcionario where nome = '"+ cod + "'";
             List<Funcionario> lista = new ArrayList<>();
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 if(rs != null){
                     while(rs.next()){
                         Funcionario a = new Funcionario();
                         a.setCod(rs.getInt(1));
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
         public String Excluir_Funcionario(Funcionario a){
             String sql = "delete from funcionario where funcionario = ? and nome = ?";
             try {
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ps.setInt(1, a.getCod());
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
