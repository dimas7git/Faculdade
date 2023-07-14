/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto1.dao;

import java.sql.*;
/**
 *
 * @author aluno
 */
public class ConexaoDAO {
    public static Connection conn = null;
    
    public ConexaoDAO(){
    }
    
    public static void ConnectDB(){
        try {
             String dsn = "LS1";
             String user = "postgres";
             String senha = "postdba";
             
             DriverManager.registerDriver(new org.postgresql.Driver());
             
             String url = "jdbc:postgresql://localhost:5432/" + dsn;
             
             conn = DriverManager.getConnection(url, user, senha);
             
             conn.setAutoCommit(false);
             
             if(conn == null){
                 System.out.println("Erro ao abrir o banco de dados");
             }
        } catch (Exception e){
            System.out.println("Erro" + e.getMessage());
        }
    }
    
    public static void CloseDB(){
        try {
            conn.close();
        } catch(Exception e){
            System.out.println("Erro" + e.getMessage());
        }
    }
}