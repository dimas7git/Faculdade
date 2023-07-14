/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.provalp1s3.ctr;

import java.sql.ResultSet;
import br.com.provalp1s3.dao.ConexaoDAO;
import br.com.provalp1s3.dao.ProfissionalDAO;
import br.com.provalp1s3.dto.ProfissionalDTO;
/**
 *
 * @author aluno
 */
public class ProfissionalCTR {
    ProfissionalDAO profissionalDAO = new ProfissionalDAO();
    
    public ProfissionalCTR(){
    }
    
    public String inserirProfissional(ProfissionalDTO profissionalDTO){
        try {
            if(profissionalDAO.inserirProfissional(profissionalDTO)){
                return "Profissional cadastrado com sucesso";
            } else {
                return "Profissional não cadastrado";
            }
        } catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
            return "Profissional não cadastrado";
        }
    }
    
    public String alterarProfissional(ProfissionalDTO profissionalDTO){
        try {
            if(profissionalDAO.alterarProfissional(profissionalDTO)){
                return "Profissional alterado com sucesso";
            } else {
                return "Profissional não alterado";
            }
        } catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
            return "Profissional não alterado";
        }
    }
    
    public String deletarProfissional(ProfissionalDTO profissionalDTO){
        try {
            if(profissionalDAO.excluirProfissional(profissionalDTO)){
                return "Profissional deletado com sucesso";
            } else {
                return "Profissional não deletado";
            }
        } catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
            return "Profissional não deletado";
        }
    }
    
    public ResultSet consultarProfissional(ProfissionalDTO profissionalDTO, int opcao){
        ResultSet rs = null;
        
        rs =  profissionalDAO.consultarProfissional(profissionalDTO, opcao);
        
        return rs;
    }
    
    public void closeDb(){
        ConexaoDAO.CloseDB();
    }
}
