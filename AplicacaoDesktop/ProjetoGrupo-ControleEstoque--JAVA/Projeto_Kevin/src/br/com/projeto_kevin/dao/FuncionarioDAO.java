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
import br.com.projeto_kevin.dto.FuncionarioDTO;

/**
 * Classe responsável por manipular dados dos Funcionarios.
 * 
 * @author Kevin
 * @version 1.0
 */
public class FuncionarioDAO {
    /**
     * Método construtor da classe.
     */
    public FuncionarioDAO() {
    }
    
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private Statement stt = null;
    
    /**
     * Método responsável por inserir Funcionários no Banco de Dados.
     * 
     * @param funcionarioDTO, vindo da classe FuncionarioDTO.
     * @return verdadeiro ou falso.
     */
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();
            
            // String SQL que será executada no Banco de Dados.
            String sql = "INSERT INTO funcionario(nome, idade, dataNascimento, imagem) VALUES (?,?,?,?)";
            
            pst = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            pst.setString(1, funcionarioDTO.getNome());
            pst.setInt(2, funcionarioDTO.getIdade());
            pst.setString(3, funcionarioDTO.getDataNascimento());
            pst.setBytes(4, funcionarioDTO.getFuncionario_img());
            
            pst.executeUpdate(); // Executa o comando no Banco de Dados.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            return true;
        }// Fecha try. 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }// Fecha catch.
        finally {
            ConexaoDAO.CloseDB();
        }// Fecha finally.
    }// Fecha o método inserirFuncionario.
    
    /**
     * Método responsável por pesquisar funcionários no Banco de Dados.
     * 
     * @param funcionarioDTO, vindo da classe FuncionarioDTO.
     * @param opcao, variável local.
     * @return variável do tipo ResultSet.
     */
    public ResultSet consultarFuncionarios(FuncionarioDTO funcionarioDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            
            stt = ConexaoDAO.con.createStatement();
            
            String sql = "";
            switch (opcao) {
                case 1:
                    sql = "SELECT * FROM funcionario ORDER BY funcionario";
                break;
                case 2:
                    sql = "Select f.* "+
                          "from funcionario f "+
                          "where f.id_funcionario = " + funcionarioDTO.getId_funcionario();
                break;
            }
            
            rs = stt.executeQuery(sql);
            return rs;
        }// Fecha try. 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }// Fecha catch.
    }// Fecha método consultarFuncionarios.
    
    /**
     * Método responsável por alterar dados do produto no Banco.
     * 
     * @param funcionarioDTO, que vem da classe ProdutoCTR.
     * @return true ou false.
     */
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB(); // Conectando com o Banco de Dados.
             
            // Comando sql que será executado no Banco de Dados.
            String sql = "UPDATE funcionario SET "
                       + "nome = ?, idade = ?, dataNascimento = ?, imagem = ? "
                       + "WHERE id_funcionario = ?";
            
            pst = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            pst.setString(1, funcionarioDTO.getNome());
            pst.setInt(2, funcionarioDTO.getIdade());
            pst.setString(3, funcionarioDTO.getDataNascimento());
            pst.setBytes(4, funcionarioDTO.getFuncionario_img());
            pst.setInt(5, funcionarioDTO.getId_funcionario());
              
            pst.executeUpdate(); // Executa o comando sql no Banco de Dados.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            pst.close(); // Fecha o Statement.
            return true; // Retorna verdadeiro.
        }// Fecha o try.
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false; // Retorna falso.
        }// Fecha catch.
        // Independentemente de erro, fecha o Banco de Dados.
        finally {
            ConexaoDAO.CloseDB(); // Método responsável por fechar a conexão com o Banco.
        }// Fecha finally.
    }// Fecha o método alterarProduto(ProdutoDTO produtoDTO).
    
    /**
     * Método responsável por excluir um produto no Banco.
     * 
     * @param funcionarioDTO, vindo da classe ProdutoCTR.
     * @return true ou false.
     */
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB(); // Conectando com o Banco de Dados.
                
            // Comando sql que será executado no Banco de Dados.
            String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
            
            pst = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            pst.setInt(1, funcionarioDTO.getId_funcionario());
            
            pst.executeUpdate(); // Executa o comando sql no Banco de Dados.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            pst.close(); // Fecha o Statement.
            return true; // Retorna verdadeiro.
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
                System.out.println(e.getMessage());
                return false; // Retorna falso.
        }// Fecha catch.
        finally {
            ConexaoDAO.CloseDB(); // Método responsável por fechar a conexão com o Banco.
        }// Fecha finally.
    }// Fecha o método excluirProduto(ProdutoDTO produtoDTO).
}// Fecha a classe FuncionarioDAO.
