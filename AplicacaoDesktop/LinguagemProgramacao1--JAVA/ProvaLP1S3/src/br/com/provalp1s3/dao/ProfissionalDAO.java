/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.provalp1s3.dao;

import java.sql.*;
import br.com.provalp1s3.dto.ProfissionalDTO;
/**
 *
 * @author aluno
 */
public class ProfissionalDAO {
    
    public ProfissionalDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirProfissional(ProfissionalDTO profissionalDTO){
        try{
           ConexaoDAO.ConnectDB();
           
           stmt = ConexaoDAO.conn.createStatement();
           
           String comando = "Insert into profissionais (nome, descricao, "
                   + "habilidades, experiencias, contato, cursos, preco) values ("
                   + "'" + profissionalDTO.getNome() + "', "
                   + "'" + profissionalDTO.getDescricao() + "', "
                   + "'" + profissionalDTO.getHabilidades() + "', "
                   + "'" + profissionalDTO.getExperiencias() + "', "
                   + "'" + profissionalDTO.getContato() + "', "
                   + "'" + profissionalDTO.getCursos() + "', "
                   + profissionalDTO.getPreco() + ")";
            
           stmt.execute(comando.toUpperCase());
           ConexaoDAO.conn.commit();
           
           stmt.close();
           
            return true;
        } catch(Exception e){
            System.out.println("Erro ProfissionalDAO.inserirProfissional: "+ e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarProfissional(ProfissionalDTO profissionalDTO, int opcao){
        try {
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "select p.* from profissionais p " +
                            "where nome like '" + profissionalDTO.getNome() + "%' " +
                            "order by p.nome";
                    break;
                case 2:
                    comando = "select p.* from profissionais p " + 
                            "where p.id_profissional = " + profissionalDTO.getIdProfissional();
                    break;
                case 3:
                    comando = "select p.nome, p.id_profissional from profissionais p";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
                    
            return rs;
        } catch(Exception e){
            System.out.println("Erro ProfissionalDAO.consultarProfissional: "+ e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarProfissional(ProfissionalDTO profissionalDTO){
        try{
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "update profissionais set "+
                    "nome = '"+ profissionalDTO.getNome()+ "', "+
                    "descricao = '" + profissionalDTO.getDescricao() + "', "+
                    "habilidades = '" + profissionalDTO.getHabilidades() + "', "+
                    "experiencias = '" + profissionalDTO.getExperiencias()+ "', "+
                    "contato = '"+profissionalDTO.getContato()+ "', "+
                    "cursos = '"+profissionalDTO.getCursos()+ "', "+ 
                    "preco = "+profissionalDTO.getPreco() + 
                    " where id_profissional = " + profissionalDTO.getIdProfissional();
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            
            stmt.close();
            
            return true;
        }catch(Exception e){
            System.out.println("Erro ProfissionalDAO.alterarProfissional: "+ e.getMessage());
            return false;
        } finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirProfissional(ProfissionalDTO profissionalDTO){
        try{
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.conn.createStatement();
            
            String comando = "delete from profissionais where id_profissional = " + profissionalDTO.getIdProfissional();
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.conn.commit();
            
            stmt.close();
            
            return true;
        }catch(Exception e){
            System.out.println("Erro ProfissionalDAO.excluirProfissional: "+ e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
