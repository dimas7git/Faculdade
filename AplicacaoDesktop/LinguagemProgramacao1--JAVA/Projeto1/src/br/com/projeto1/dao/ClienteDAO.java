/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto1.dao;

import java.sql.*;
import br.com.projeto1.dto.ClienteDTO;
/**
 *
 * @author aluno
 */
public class ClienteDAO {

    public ClienteDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirCliente(ClienteDTO clienteDTO){
        try{
            ConexaoDAO.ConnectDB();
                    
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "Insert into clientes (nome, logradouro, numero,"
                    + "bairro, cidade, estado, cep, cpf, rg) values ("
                    + "'" + clienteDTO.getNome() + "',"
                    + "'" + clienteDTO.getLogradouro() + "',"
                    + clienteDTO.getNumero() + ","
                    + "'" + clienteDTO.getBairro() + "',"
                    + "'" + clienteDTO.getCidade() + "',"
                    + "'" + clienteDTO.getEstado() + "',"
                    + "'" + clienteDTO.getCep() + "',"
                    + "'" + clienteDTO.getCpf() + "',"
                    + "'" + clienteDTO.getRg() + "')";
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            
            stmt.close();
            
            return true;
        } catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        try {
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "select c.* from clientes c " + 
                            "where nome like '" + clienteDTO.getNome() + "%' " +
                            "order by c.nome";
                    break;
                case 2:
                    comando = "select c.* from clientes c " + 
                            "where c.id_cliente = " + clienteDTO.getIdCliente() ;
                    break;
                case 3:
                    comando = "select c.id_cliente, c.nome from clientes c";
                    break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch(Exception e){
            System.out.println("Erro consultarCliente(): " + e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarCliente(ClienteDTO clienteDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "Update clientes set " +
                    "nome = '" + clienteDTO.getNome() + "', " +
                    "bairro = '" + clienteDTO.getBairro() + "', " +
                    "cep = '" + clienteDTO.getCep() + "', " +
                    "cidade = '" + clienteDTO.getCidade() + "', " +
                    "cpf = '" + clienteDTO.getCpf() + "', " +
                    "estado = '" + clienteDTO.getEstado() + "', " +
                    "rg = '" + clienteDTO.getRg() + "', " +
                    "numero = " + clienteDTO.getNumero() + ", " +
                    "logradouro = '" + clienteDTO.getLogradouro() + "' " +
                    "WHERE id_cliente = " + clienteDTO.getIdCliente();
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            
            stmt.close();
            
            return true;
        } catch (Exception e){
            System.out.println("Erro alterarCliente(): " + e.getMessage());
            return false;
        } finally {
           ConexaoDAO.CloseDB();
        }    
    }
    
    public boolean excluirCliente(ClienteDTO clienteDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "delete from clientes where id_cliente = "+ clienteDTO.getIdCliente();
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            
            stmt.close();
            
            return true;
        } catch (Exception e){
            System.out.println("Erro excluirCliente(): " + e.getMessage());
            return false;
        } finally {
           ConexaoDAO.CloseDB();
        }    
    }
}