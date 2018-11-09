package DAO;

import Modelo.Categoria;
import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class CategoriaDAO  extends ExecuteSQL{
public CategoriaDAO(Connection con){
super(con);
}
    

public  String Inserir_Categoria (Categoria a){

String sql = "INSERT INTO categoria VALUES (0,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    

public List<Categoria>  ListarCategoria(){
    
    String sql = "SELECT idcategoria,nome FROM categoria";
    List<Categoria> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
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
    
    }catch( SQLException e){
        return null;
    }
    
}
     
   public List<Categoria> Pesquisar_Nome_Categoria( String nome){
   String sql = "SELECT * FROM categoria WHERE nome LIKE '%"+nome+"%'";
   List<Categoria> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
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
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
    
   public List<Categoria> Pesquisar_Cod_Categoria( String cod){
   String sql = "SELECT * FROM categoria WHERE idcategoria LIKE '%"+cod+"%'";
   List<Categoria> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
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
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
    public boolean Testar_Categoria(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM categoria WHERE idcategoria = "+cod+"";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet  rs = ps.executeQuery();

if( rs!= null){
        while(rs.next()){
        Resultado = true;
        }
    }
    }catch(SQLException ex){
    ex.getMessage();
    }
        return Resultado;
    }

            public List<Categoria> CapturarCategoria(int cod){
            String sql = "SELECT *  FROM categoria WHERE idcategoria = "+cod+"";
        List<Categoria> lista = new ArrayList<>();
        try{
             PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
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
    }catch( SQLException ex ){
    return null;
    }

    }
    
    public String Alterar_Categoria( Categoria a){
    String sql = "UPDATE categoria SET nome = ?   WHERE idcategoria = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1, a.getNome());
    ps.setInt(2, a.getCodigo());
        if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Categoria> ListarComboCategoria(){
   String sql = "SELECT nome FROM categoria ORDER BY nome";
   List<Categoria> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Categoria a = new Categoria();
   a.setNome(rs.getString(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Categoria> ConsultaCodigoCategoria( String nome){
   String sql = "SELECT idcategoria FROM categoria WHERE nome = '"+ nome +"'";
   List<Categoria> lista = new ArrayList<>();
   try{
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
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Cliente(Categoria a){
   String sql = "DELETE FROM categoria WHERE idcategoria = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ps.setInt(1, a.getCodigo());
   ps.setString(2,a.getNome());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   
  
   public List<Categoria> IDCategoria(){
   String sql = "SELECT MAX(idcategoria) FROM `categoria`";
   List<Categoria> lista = new ArrayList<>();
   try{
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
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
}
