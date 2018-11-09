package DAO;

import Modelo.Cliente;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClienteDAO extends ExecuteSQL {

public ClienteDAO(Connection con){
        super(con);}


public  String Inserir_Cliente(Cliente a){

String sql = "INSERT INTO cliente VALUES (0,?,?,?,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    ps.setString(2,a.getNascimento());
    ps.setString(3,a.getRG());
    ps.setString(4,a.getCPF());
    ps.setString(5,a.getEmail());
    ps.setString(6,a.getTelefone());
    ps.setString(7,a.getBairro());
    ps.setString(8,a.getRua());
    ps.setInt(9,a.getNumero());
    ps.setString(10,a.getCEP());

    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Inserir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    

public List<Cliente>  ListarCliente(){
    
    String sql = "SELECT idcliente,nome,rg,cpf,telefone,email FROM cliente";
    List<Cliente> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Cliente a = new Cliente();
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
    
    }catch( SQLException e){
        return null;
    }
    
}
    
   public List<Cliente> Pesquisar_Nome_Cliente( String nome){
   String sql = "SELECT * FROM cliente WHERE nome LIKE '%"+nome+"%'";
   List<Cliente> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Cliente a = new Cliente();
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
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
   
   public List<Cliente> Pesquisar_Cod_Cliente( String cod){
   String sql = "SELECT * FROM cliente WHERE idcliente LIKE '%"+cod+"%'";
   List<Cliente> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Cliente a = new Cliente();
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
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
    public boolean Testar_Cliente(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM cliente WHERE idcliente = "+cod+"";
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

    public List<Cliente> CapturarCliente(int cod){
    String sql = "SELECT *  FROM cliente WHERE idcliente = "+cod+"";
    List<Cliente> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Cliente a = new Cliente();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
    a.setNascimento(rs.getString(3));
    a.setRG(rs.getString(4));
    a.setCPF(rs.getString(5));
    a.setEmail(rs.getString(6));
    a.setTelefone(rs.getString(7));
    a.setBairro(rs.getString(8));
    a.setRua(rs.getString(9));
    a.setNumero(rs.getInt(10));
    a.setCEP(rs.getString(11));
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
    
    public String Alterar_Cliente( Cliente a){
    String sql = "UPDATE cliente SET nome = ? ,data_nasc = ?,rg = ?, cpf = ? , email = ? , telefone = ? , bairro = ?,  rua = ?, numero  = ? ,cep = ? WHERE idcliente = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1, a.getNome());
    ps.setString(2,a.getNascimento() );
    ps.setString(3, a.getRG() );
    ps.setString(4, a.getCPF());
    ps.setString(5, a.getEmail());
    ps.setString(6, a.getTelefone());
    ps.setString(7, a.getBairro());
    ps.setString(8, a.getRua());
    ps.setInt(9, a.getNumero());
    ps.setString(10, a.getCEP());
    ps.setInt(11, a.getCodigo());
        if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Cliente> ListarComboCliente(){
   String sql = "SELECT nome FROM cliente ORDER BY nome";
   List<Cliente> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Cliente a = new Cliente();
   a.setNome(rs.getString(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Cliente> ConsultaCodigoCliente( String nome){
   String sql = "SELECT idcliente FROM cliente WHERE nome = '"+ nome +"'";
   List<Cliente> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Cliente a = new Cliente();
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
   
   public String Excluir_Cliente(Cliente a){
   String sql = "DELETE FROM cliente WHERE idcliente = ? AND nome = ?";
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
   
   public List<Cliente> ProximoCliente(){
   String sql = "SELECT MAX(idfuncionario) FROM `funcionario`";
   List<Cliente> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Cliente a = new Cliente();
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