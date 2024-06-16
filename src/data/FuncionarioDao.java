/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author LuizVagner
 */
public class FuncionarioDao {
        Conexao conexao = new Conexao();
    Connection conn;

    public boolean conectar(){
        conn = conexao.getConectar();
        if(conn == null){
            return false;
        }
        else{
            return true;
        }
    }

    private PreparedStatement st;
    private ResultSet rs;
    
   
   
  
   
    public int salvar(Funcionario f){
     
       try{
           st = conn.prepareStatement("INSERT INTO funcionario (nome_funcionario, cargo) VALUES( ?, ?)");
           st.setString(1,f.getNomeFuncionario());
           st.setString(2, f.getCargo());
           
           return  st.executeUpdate();
            
           
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar  " + ex.getErrorCode());
         return ex.getErrorCode();
       }
   }
    
        public int excluir( int id){
        
        try{
            st = conn.prepareStatement("DELETE FROM funcionario WHERE id = ?");
            st.setInt(1, id);
           return st.executeUpdate();
        }
        catch(SQLException ex){
           return ex.getErrorCode();
            
        }
    }
        
        public int atualizar(Funcionario funcionario, int id){
        
          try{
            st = conn.prepareStatement("UPDATE funcionario SET  nome_funcionario = ?, cargo = ?  WHERE  id =" +  id);
            st.setString(1, funcionario.getNomeFuncionario());
            st.setString(2, funcionario.getCargo());
            
            return st.executeUpdate();
            
        }
        catch(SQLException ex){
            
            return ex.getErrorCode();
        }
    }
        
         public Funcionario consulta(int id){
             
             try {
                 Funcionario funcionarioEncontrado = new Funcionario();
                 st = conn.prepareStatement("SELECT * FROM funcionario WHERE id = " + id + "");
                 rs = st.executeQuery();
                 if (rs.next()) {
                     funcionarioEncontrado.setId(rs.getInt("id"));
                     funcionarioEncontrado.setNomeFuncionario(rs.getString("nome_funcionario"));
                     funcionarioEncontrado.setCargo(rs.getString("cargo"));
                 }
             return funcionarioEncontrado;
             }
              catch(SQLException ex){
                  return null;
              }
         }
         
         public List<Funcionario> listagem(String filtro){
             try{
                 List<Funcionario> lista =  new ArrayList<>();
                 String sqlFiltro = "SELECT * FROM funcionario";
                 
                 if(! filtro.isEmpty()){
                     sqlFiltro =  sqlFiltro+ " WHERE nome_funcionario like ?";
                 }
                 
                 st = conn.prepareStatement(sqlFiltro);
                 
                 if(!filtro.isEmpty()){
                     st.setString(1, "%" + filtro + "%");
                 }
                 
                 rs = st.executeQuery();
                 
                 while (rs.next()) {
                     Funcionario funcionarioEncontrado = new Funcionario();
                      funcionarioEncontrado.setId(rs.getInt("id"));
                      funcionarioEncontrado.setNomeFuncionario(rs.getString("nome_funcionario"));
                      funcionarioEncontrado.setCargo(rs.getString("cargo"));

                      lista.add(funcionarioEncontrado);
                 }
                 return lista;
             }
        
        
        catch(SQLException ex){
            return null;
        }
            
    }
         
           public List<Funcionario> getFuncionario(){
               
            try{
                st = conn.prepareStatement("SELECT * FROM funcionario");
                rs=  st.executeQuery();
                List <Funcionario> listaFuncionarios = new ArrayList<>();
                 
                 while(rs.next()){
                 Funcionario funcionario = new Funcionario();
                 funcionario.setId(rs.getInt("id"));
                 funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
                 funcionario.setCargo(rs.getString("cargo"));
                 listaFuncionarios.add(funcionario);
                 }
                 return listaFuncionarios;
            }
            catch(SQLException ex){
                return null;
            }
            
        }
   
   
   public void desconectar(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar" + ex.getMessage());
        }
    }
    
}
