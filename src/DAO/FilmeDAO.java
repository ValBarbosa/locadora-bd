/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL{

    public  FilmeDAO(Connection con) {
    super(con);
    }


public  String Inserir_Filme(Filme a){

String sql = "INSERT INTO filme VALUES (0,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
   
    ps.setString(1,a.getTitulo());
    ps.setInt(2,a.getAno());
    ps.setString(3,a.getDuracao());
    ps.setInt(4,a.getCod_categoria());
    ps.setInt(5,a.getCod_classificacao());
    ps.setString(6,a.getCapa());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    

public List<Filme>  ListarFilme(){
    
    String sql = "SELECT * FROM filme";
    List<Filme> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Filme a = new Filme();
            a.setCodigo(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            a.setAno(rs.getInt(3));
            a.setDuracao(rs.getString(4));
            a.setCod_categoria(rs.getInt(5));
            a.setCod_classificacao(rs.getInt(6));
            a.setCapa(rs.getString(7));
            
            
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
     
                public List<Filme> Pesquisar_Nome_Filme( String nome){
                String sql = "SELECT * FROM filme WHERE titulo LIKE '%"+nome+"%'";
                List<Filme> lista = new ArrayList<>();

                 try{
                 PreparedStatement ps = getCon().prepareStatement(sql);
                 ResultSet rs =  ps.executeQuery();

                 if(rs != null){
                     while(rs.next()){
                         Filme a = new Filme();
                         a.setCodigo(rs.getInt(1));
                         a.setTitulo(rs.getString(2));
                         a.setAno(rs.getInt(3));
                         a.setDuracao(rs.getString(4));
                         a.setCod_categoria(rs.getInt(5));
                         a.setCod_classificacao(rs.getInt(6));
                         a.setCapa(rs.getString(7));
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


           public List<Filme> Pesquisar_Cod_Filme( String cod){
           String sql = "SELECT * FROM filme WHERE idfilme LIKE '%"+cod+"%'";
           List<Filme> lista = new ArrayList<>();

            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                   a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));


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

            public boolean Testar_Filme(int cod){
            boolean Resultado = false;
            try{
            String sql  = "SELECT * FROM filme WHERE idfilme = "+cod+"";
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

            public List<Filme> CapturarFilme(int cod){
            String sql = "SELECT *  FROM filme WHERE idfilme = "+cod+"";
            List<Filme> lista = new ArrayList<>();
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if( rs!= null){
            while(rs.next()){
            Filme a = new Filme();
            a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
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

            public String Alterar_Filme( Filme a){
            String sql = "UPDATE filme SET titulo = ? ,ano = ?,duracao = ?, idcategoria= ? , idclassificacao = ? , capa = ?  WHERE idfilme = ? ";
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getTitulo());
            ps.setInt(2,a.getAno() );
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(6, a.getCapa());
             ps.setInt(7, a.getCodigo());
                if(ps.executeUpdate() > 0){
                return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
            }catch(SQLException e){
            return e.getMessage();
            }

            }

           public List<Filme> ListarComboFilme(){
           String sql = "SELECT titulo FROM filme ORDER BY titulo";
           List<Filme> lista = new ArrayList<>();
           try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();

           if(rs != null){
           while(rs.next()){
           Filme a = new Filme();
           a.setTitulo(rs.getString(1));
           lista.add(a);
           }
           return lista;
           }else{

           return null;}

           }catch(Exception e){
           return null;}

           }


           public List<Filme> ConsultaCodigoFilme( String nome){
           String sql = "SELECT idfilme FROM filme WHERE titulo = '"+ nome +"'";
           List<Filme> lista = new ArrayList<>();
           try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();

           if(rs != null){
           while(rs.next()){
           Filme a = new Filme();
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


           public String Excluir_Filme(Filme a){
           String sql = "DELETE FROM filme WHERE idfilme = ? AND titulo = ?";
           try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, a.getCodigo());
           ps.setString(2,a.getTitulo());

           if(ps.executeUpdate() > 0){
           return "Excluido com Sucesso";

           }else{

           return "Erro ao Excluir";}

           }catch( SQLException e){
           return e.getMessage();
           }

           }
           public List<Filme> IDFilme(){
           String sql = "SELECT MAX(idfilme) FROM `filme`";
           List<Filme> lista = new ArrayList<>();
           try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();

           if(rs != null){
           while(rs.next()){
           Filme a = new Filme();
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
