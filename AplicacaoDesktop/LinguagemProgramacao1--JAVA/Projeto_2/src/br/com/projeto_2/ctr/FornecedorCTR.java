/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.ctr;

import br.com.projeto_2.dao.ConexaoDAO;
import java.sql.*;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dao.FornecedorDAO;
/**
 *
 * @author aluno
 */
public class FornecedorCTR {
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public FornecedorCTR(){
    }
    
    public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try {
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor cadastrado com sucesso.";
            } else {
                return "Fornecedor não cadastrado.";
            }
        } catch(Exception err){
            System.out.println("Erro FornecedorCTR.inserirFornecedor(): " + err.getMessage());
            
            return "Fornecedor não cadastrado";
        }
    }
    
    public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try {
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor alterado com sucesso.";
            } else {
                return "Fornecedor não alterado.";
            }
        } catch(Exception err){
            System.out.print("Erro FornecedorCTR.alterarFornecedor(): " + err.getMessage());
            return "Fornecedor não alterado.";
        }
    }
    
    public String excluirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor excluido com sucesso.";
            } else {
                return "Fornecedor não excluido.";
            }
        } catch(Exception err){
            System.out.print("Erro FornecedorCTR.excluirFornecedor(): " + err.getMessage());
            return "Fornecedor não excluido.";
        }
    }
    
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
        ResultSet rs = null;
        
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }
    
    public void closeDb(){
        ConexaoDAO.closeDb();
    }
}
