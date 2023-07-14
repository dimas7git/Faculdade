/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.dao;

import java.sql.*;
import br.com.projeto_2.dto.FornecedorDTO;
import java.text.SimpleDateFormat;
/**
 *
 * @author aluno
 */
public class FornecedorDAO {
    public FornecedorDAO(){
    }
    
    SimpleDateFormat date_format = new SimpleDateFormat("dd/mm/yyyy");
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO){
        try {
            ConexaoDAO.conectDb();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into fornecedor (nome_for, cnpj_for, "
                    + "tel_for, data_cad_for) values ("
                    + "'" + fornecedorDTO.getNome_for() +  "', "
                    + "'" + fornecedorDTO.getCnpj_for() + "', "
                    + "'" + fornecedorDTO.getTel_for() + "', "
                    + "to_date('" + date_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/mm/yyyy')) ";
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            
            return true;
        } catch(Exception err){
            System.out.println("Erro FornecedorDAO.inserirFornecedor(): " + err.getMessage());
            
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }
    
     public boolean alterarFornecedor(FornecedorDTO fornecedorDTO){
         try {
             ConexaoDAO.conectDb();
             
             stmt = ConexaoDAO.con.createStatement();
             
             String comando = "Update fornecedor set "
                     + "nome_for = '" + fornecedorDTO.getNome_for() + "', "
                     + "cnpj_for = '" + fornecedorDTO.getCnpj_for() + "', "
                     + "tel_for = '" + fornecedorDTO.getTel_for() + "', "
                     + "data_cad_for = to_date('" + date_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/mm/yyyy') "
                     + "where id_for = " + fornecedorDTO.getId_for();
             
             stmt.execute(comando.toUpperCase());
             ConexaoDAO.con.commit();
             stmt.close();
             
             return true;
         } catch(Exception err){
            System.out.println("Erro FornecedorDAO.alterarFornecedor(): " + err.getMessage());
            
            return false;
         } finally {
             ConexaoDAO.closeDb();
         }
     }
     
     public boolean excluirFornecedor(FornecedorDTO fornecedorDTO){
         try{
             ConexaoDAO.conectDb();
             
             stmt = ConexaoDAO.con.createStatement();
             
             String comando = "Delete from fornecedor where id_for = " + fornecedorDTO.getId_for();
             
             stmt.execute(comando.toUpperCase());
             ConexaoDAO.con.commit();
             stmt.close();
             
             return true;
         } catch(Exception err){
            System.out.println("Erro FornecedorDAO.excluirFornecedor(): " + err.getMessage());
            
            return false;
         } finally {
             ConexaoDAO.closeDb();
         }
     }
     
     public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
         try{
             ConexaoDAO.conectDb();
             
             stmt = ConexaoDAO.con.createStatement();
             
             String comando = "";
             
             switch(opcao){
                 case 1:
                     comando = "Select f.id_for, f.cnpj_for, f.nome_for "
                             + "from fornecedor f " 
                             + "where f.nome_for like '" + fornecedorDTO.getNome_for() + "%' " 
                             + "order by f.nome_for";
                     break;
                 case 2:
                     comando = "select f.nome_for, f.cnpj_for, f.tel_for, "
                             + "to_char(f.data_cad_for, 'dd/mm/yyyy') as data_cad_for "
                             + "from fornecedor f "
                             + "where f.id_for = " + fornecedorDTO.getId_for();
                     break;
             }
             rs = stmt.executeQuery(comando.toUpperCase());
             
             return rs;
         }catch(Exception err){
            System.out.println("Erro FornecedorDAO.consultarFornecedor(): " + err.getMessage());
            
            return rs;
         }
     }
}
