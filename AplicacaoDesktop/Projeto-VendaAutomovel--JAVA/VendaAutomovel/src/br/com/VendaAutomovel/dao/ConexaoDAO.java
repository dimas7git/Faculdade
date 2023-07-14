/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VendaAutomovel.dao;

import java.sql.*;

/**
 *
 * @author Aluno
 */

public class ConexaoDAO {

    public ConexaoDAO() {
    }

    //guarda a conexão do banco de dados 
    public static Connection con = null;

    public static void ConectDB() {
        try {
            String dsn = "automovel";//nome do banco de dados(igual o criado no postgree)
            String user = "postgres";//nome do usuario utilizado para se conectar
            String senha = "postdba";//senha do usuario acima informado

            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;

            con = DriverManager.getConnection(url, user, senha);

            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("Erro ao abrir o banco");
            }
        } catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados" + e.getMessage());
        }
    }

    public static void CloseDB() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados" + e.getMessage());
        }
    }

}

