/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto1.ctr;

import java.sql.ResultSet;
import br.com.projeto1.dto.ClienteDTO;
import br.com.projeto1.dao.ClienteDAO;
import br.com.projeto1.dao.ConexaoDAO;
/**
 *
 * @author aluno
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public ClienteCTR(){
        
    }
    
    public String inserirCliente(ClienteDTO clienteDTO){
        try {
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente cadastrado";
            } else {
                return "Cliente não cadastrado";
            }
        } catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return "Cliente não cadastrado";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        ResultSet rs = null;
        
        rs= clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return rs;
    }
    
    public String alterarCliente(ClienteDTO cliente){
        try{
            if(this.clienteDAO.alterarCliente(cliente)){
                return "Cliente alterado com sucesso!";
            } else {
                return "Cliente não alterado";
            }
        } catch (Exception e){
            System.out.println("Erro alterarCliente()"+ e.getMessage());
            return "Cliente não alterado";
        }
    }
    
    public String excluirCliente(ClienteDTO cliente){
        try{
            if(this.clienteDAO.excluirCliente(cliente)){
                return "Cliente deletado com sucesso!";
            } else {
                return "Cliente não deletado";
            }
        } catch (Exception e){
            System.out.println("Erro excluirCliente()"+ e.getMessage());
            return "Cliente não deletado";
        }
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}