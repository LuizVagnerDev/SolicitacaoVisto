/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Scanner;


/**
 *
 * @author LuizVagner
 */
public class Funcionario{
    Scanner teclado = new Scanner(System.in);    
    private int  id;
    
    private String nomeFuncionario;
    
    private String cargo;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    @Override
    public String toString(){
        return nomeFuncionario;
    }
    
   @Override
   public boolean equals(Object objeto){
       Funcionario f = (Funcionario) objeto;
       if(id == f.getId()){
           return true;
       }
       else{
           return false;
       }
   }
    
}
