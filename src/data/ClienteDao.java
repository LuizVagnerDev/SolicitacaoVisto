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
public class ClienteDao {
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
    
   
   
  
   
    public int salvar(Cliente c){
     
       try{
           st = conn.prepareStatement("INSERT INTO cliente (nome, cpf, data_nasc, endereco, email, id_funcionario) VALUES(?, ?, ?, ?, ?, ?)");
           st.setString(1,c.getNome());
           st.setString(2, c.getCpf());
           st.setDate(3, c.getData_nasc());
           st.setString(4, c.getEndereco());
           st.setString(5, c.getEmail());
           st.setInt(6, c.getId_funcionario().getId());
          
           
           return  st.executeUpdate();
            
           
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar  " + ex.getErrorCode());
         return ex.getErrorCode();
       }
   }
    
        public int excluir( int id){
        
        try{
            st = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            st.setInt(1, id);
           return st.executeUpdate();
        }
        catch(SQLException ex){
           return ex.getErrorCode();
            
        }
    }
        
        public int atualizar(Cliente c, int id){
        
          try{
            st = conn.prepareStatement("UPDATE cliente SET  nome = ?, cpf = ?, data_nasc = ?, endereco = ?, email = ?, id_funcionario = ?  WHERE  id =" +  id);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setDate(3, c.getData_nasc());
            st.setString(4, c.getEndereco());
            st.setString(5, c.getEmail());
            st.setInt(6, c.getId_funcionario().getId());
            
            return st.executeUpdate();
            
        }
        catch(SQLException ex){
            
            return ex.getErrorCode();
        }
    }
        
         public Cliente consulta(int id){
        try{
            Cliente clienteEncontrado = new Cliente();
            st = conn.prepareStatement("SELECT * FROM cliente A inner join funcionario B on (A.id_funcionario = b.id)  WHERE A.id = "+ id + "");
            rs = st.executeQuery();
           if( rs.next()){
                clienteEncontrado.setMatricula(rs.getInt("id"));
                clienteEncontrado.setNome(rs.getString("nome"));
                clienteEncontrado.setCpf(rs.getString("cpf"));
                clienteEncontrado.setData_nasc(rs.getDate("data_nasc"));
                clienteEncontrado.setEndereco(rs.getString("endereco"));
                clienteEncontrado.setEmail(rs.getString("email"));
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNomeFuncionario(rs.getString("nome_funcionario"));
                f.setCargo(rs.getString("cargo"));
                clienteEncontrado.setId_funcionario(f);
           }
            
            return clienteEncontrado;
            
        }
        catch(SQLException ex){
       
            return null;
        }
    }
        
        
        public List<Cliente> listagem(String filtro){
        
        try{
             List<Cliente> lista =  new ArrayList<>();
                     
            String sqlFiltro = "SELECT * FROM cliente A inner join funcionario B on (A.id_funcionario = b.id)";
            
            if(! filtro.isEmpty()){
                sqlFiltro =  sqlFiltro+ " WHERE A.nome like ?";   
            }
            
            st = conn.prepareStatement(sqlFiltro);
           
            if(!filtro.isEmpty()){
                st.setString(1, "%" + filtro + "%");
            }
            
            
             rs = st.executeQuery();
             
             while(rs.next()){
                 Cliente clienteEncontrado = new Cliente();
                 
                 clienteEncontrado.setMatricula(rs.getInt("id"));
                 clienteEncontrado.setNome(rs.getString("nome"));
                 clienteEncontrado.setCpf(rs.getString("cpf"));
                 clienteEncontrado.setData_nasc(rs.getDate("data_nasc"));
                 clienteEncontrado.setEndereco(rs.getString("endereco"));
                 clienteEncontrado.setEmail(rs.getString("email"));
                 
                 Funcionario f = new Funcionario();
                 f.setId(rs.getInt("id"));
                 f.setNomeFuncionario(rs.getString("nome_funcionario"));
                 f.setCargo(rs.getString("cargo"));
                 clienteEncontrado.setId_funcionario(f);
                 lista.add(clienteEncontrado);
             }
             return lista;
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
