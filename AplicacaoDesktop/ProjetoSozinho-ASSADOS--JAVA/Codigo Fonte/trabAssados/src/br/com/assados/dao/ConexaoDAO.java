package br.com.assados.dao;

import java.sql.*;

/**
 *
 * @author sassmatheus
 */
public class ConexaoDAO {
    public static Connection con = null;
    
    public ConexaoDAO(){
    }
    
    public static void ConectDB(){
        try{
            String dsn = "assados";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            if (con == null){
                System.out.println("Erro ao abrir banco de dados!");
            }        
        } catch (Exception erro){
            System.out.println("Problema ao abrir banco de dados!" + erro.getMessage());
        }
    }
    
    public static void CloseDB(){
        try{
            con.close();
        } catch (Exception erro){
            System.out.println("Problema ao fechar banco de dados!"  +
                erro.getMessage());
        }
    }
}
