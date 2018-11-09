/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


/**
 *
 * @author Valéria
 */


import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DVDDAO extends  ExecuteSQL{

   
public DVDDAO(Connection con){
super(con);
}

public  String Inserir_DVD(DVD a){

String sql = "INSERT INTO dvd VALUES (0,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(1,a.getCod_filme());
    ps.setDouble(2,a.getPreco());
    ps.setString(3,a.getData_compra());
    ps.setString(4,a.getSituacao());
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    

public List<DVD>  ListarDVD(){
    
    String sql = "SELECT iddvd,idfilme,preco_compra,data_compra,situacao FROM dvd";
    List<DVD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            DVD a = new DVD();
            a.setCodigo(rs.getInt(1));
            a.setCod_filme(rs.getInt(2));
            a.setPreco(rs.getDouble(3));
            a.setData_compra(rs.getString(4));
            a.setSituacao(rs.getString(5));
            
                lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}
    
   public List<DVD> Pesquisar_Id_Filme( String cod){
   String sql = "SELECT * FROM dvd WHERE idfilme LIKE '%"+cod+"%'";
   List<DVD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            DVD a = new DVD();
            a.setCodigo(rs.getInt(1));
            a.setCod_filme(rs.getInt(2));
            a.setPreco(rs.getDouble(3));
            a.setData_compra(rs.getString(4));
            a.setSituacao(rs.getString(5));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
   
 
   public List<DVD> Pesquisar_Id_DVD( String cod){
   String sql = "SELECT * FROM dvd WHERE iddvd LIKE '%"+cod+"%'";
   List<DVD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            DVD a = new DVD();
            a.setCodigo(rs.getInt(1));
            a.setCod_filme(rs.getInt(2));
            a.setPreco(rs.getDouble(3));
            a.setData_compra(rs.getString(4));
            a.setSituacao(rs.getString(5));
            
   
                lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
   
    public List<DVD> ListarCodDVD(int cod){
    String sql = "SELECT idfilme FROM dvd WHERE iddvd "+cod+"";
    List<DVD> lista = new ArrayList<>();
        try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if( rs!= null){
        while(rs.next()){
            DVD a = new DVD();
            a.setCod_filme(rs.getInt(1));
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
   
    
    public boolean Testar_DVD(int codDVD){
    boolean teste = false;
    try {
        String sql = "SELECT iddvd FROM dvd  WHERE iddvd = "+ codDVD+"" ;
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if( rs!= null){
        while(rs.next()){
        teste = true;
        }
        }
        
        } catch (SQLException e) {
        }
        return teste;
    }
    public boolean Testar_Situacao(int cod){
    boolean teste = false;
        try {
          
        String sql = "SELECT iddvd FROM dvd  WHERE iddvd = "+ cod +"" + "AND situacao = 'Disponivel'" ;
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if( rs!= null){
        while(rs.next()){
        teste = true;
        }
        }
          
        } catch (SQLException e) {
        
        }
        return teste;
    }
   
   
    
   
    public List<DVD> CapturarDVD(int codDVD){
    String sql = "SELECT *  FROM dvd WHERE iddvd = "+codDVD+"";
    List<DVD> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    DVD a = new DVD();
    a.setCodigo(rs.getInt(1));
    a.setCod_filme(rs.getInt(2));
    a.setPreco(rs.getDouble(3));
    a.setData_compra(rs.getString(4));
    a.setSituacao(rs.getString(5));
            lista.add(a);

    }
    return lista;

    }else{
        return null;
    }   
    }catch( SQLException ex ){
    return null;
    }

    } 

    public String Alterar_DVD( DVD a){
    String sql = "UPDATE dvd SET  situacao = ?  WHERE iddvd = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1, a.getSituacao());
    ps.setInt(2, a.getCodigo());
        if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<DVD> ListarComboDVD(){
   String sql = "SELECT iddvd FROM dvd ORDER BY iddvd";
   List<DVD> lista = new ArrayList<>();
   try{
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
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<DVD> ConsultaCodigoDVD( String cod){
   String sql = "SELECT idcliente FROM cliente WHERE iddvd = '"+ cod +"'";
   List<DVD> lista = new ArrayList<>();
   try{
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
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   
   public String Excluir_DVD(DVD a){
   String sql = "DELETE FROM dvd WHERE iddvd = ? AND idfilme = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ps.setInt(1, a.getCodigo());
   ps.setInt(2,a.getCod_filme());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
  
   public List<DVD> ProximoDVD(){
   String sql = "SELECT MAX(idDVD) FROM `dvd`";
   List<DVD> lista = new ArrayList<>();
   try{
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
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
}



