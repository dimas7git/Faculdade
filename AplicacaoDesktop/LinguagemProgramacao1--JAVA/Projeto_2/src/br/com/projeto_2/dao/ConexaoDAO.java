/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.dao;

import java.sql.*;
/**
 *
 * @author aluno
 */
public class ConexaoDAO {
    public static Connection con = null;
    
    public ConexaoDAO(){
    }
    
    public static void conectDb(){
        try {
            String dsn = "projeto_2";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            if(con == null){
                System.out.println("Erro ao abrir o banco");
            }
        } catch(Exception err){
            System.out.println("Erro ConexaoDAO.conectDb(): " + err.getMessage());
        }
    }
    
    public static void closeDb(){
        try{
            con.close();
        } catch(Exception err){
            System.out.println("Erro ConexaoDAO.closeDb(): " + err.getMessage());
        }
    }
}
