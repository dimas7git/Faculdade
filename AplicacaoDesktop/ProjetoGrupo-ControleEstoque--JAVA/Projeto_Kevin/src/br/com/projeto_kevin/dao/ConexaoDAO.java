/*
 * The MIT License
 *
 * Copyright 2022 Kevin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.projeto_kevin.dao;

import java.sql.*;

/**
 * Classe responsável por fazer a conexão com o Banco de Dados.
 *
 * @author Kevin
 * @version 1.0
 */
public class ConexaoDAO {
    public static Connection con = null; // Atributo do tipo connection.
    
    /**
     * Método construtor da classe.
     */
    public ConexaoDAO() {    
    }
    
    /**
     * Método que abre a conexão com o banco de dados.
     */
    public static void ConectDB() {
        try {
            // Dados que serão usados para se conectar com o Banco.
            String dsn = "projeto_kevin"; // Nome do banco que será acessado.
            String user = "postgres"; // Usuário que acessa o banco.
            String senha = "postdba"; // Senha de acesso ao banco.
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            con.setAutoCommit(false);
            
            if (con == null) {
                System.out.println("Erro ao se conectar com o Banco!");
            }// Fecha if.
        } // Fecha o try.
        // Tratamento de erro ao se conectar ao Banco de Dados.
        catch (Exception e) {
            System.out.println("Problemas ao se conectar ao Banco de Dados\n" + 
                                e.getMessage());
        }// Fecha o catch.
    }// Fecha o método ConectDB().
    
    /**
     * Método que encerra a conexão com o Banco de Dados.
     */
    public static void CloseDB() {
        try {
            con.close();
        } // Fecha o try.
        // Tratamento de erro ao fechar o Banco de Dados.
        catch (Exception e) {
            System.out.println("Problemas ao fechar o Banco de Dados\n" + 
                                e.getMessage());
        }// Fecha o catch.
    }// Fecha o método CloseDB().
}// Fecha a classe ConexaoDAO().
