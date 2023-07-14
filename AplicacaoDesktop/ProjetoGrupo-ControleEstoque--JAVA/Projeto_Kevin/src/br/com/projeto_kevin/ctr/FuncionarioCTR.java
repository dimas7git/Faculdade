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
package br.com.projeto_kevin.ctr;

import java.sql.ResultSet;
import br.com.projeto_kevin.dto.FuncionarioDTO;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dao.FuncionarioDAO;
import br.com.projeto_kevin.dao.ProdutoDAO;
import br.com.projeto_kevin.dto.ProdutoDTO;

/**
 * Classe responsável por controle das informações.
 *
 * @author Kevin
 * @version 1.0
 */
public class FuncionarioCTR {
    /**
     * Método construtor da classe.
     */
    public FuncionarioCTR() {
    }// Fecha o método construtor.
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    /**
     * Método responsável por retransmitir informações para a classe ProdutoDAO.
     * 
     * @param funcionarioDTO, vindo da classe FuncionarioDTO.
     * @return uma String.
     */
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionário cadastrado com sucesso!";
            } else {
                return "Funcionário não cadastrado";
            }
        }// Fecha try. 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionário não cadastrado!";
        }// Fecha catch.
    }// Fecha o método inserirFuncionario(FuncionarioDTO funcionarioDTO).
    
    /**
    * Método responsável por retransmitir informações para a classe ProdutoDAO.
    * 
    * @param funcionarioDTO, vindo da classe ProdutoDTO.
    * @param opcao, vindo da classe ProdutoDAO.
    * @return uma variável do tipo ResultSet.
    */
    public ResultSet consultarFuncionarios(FuncionarioDTO funcionarioDTO, int opcao) {
        ResultSet rs = null; // Criando um atributo do tipo ResultSet.
        
        // Chamando o método consultarProduto que está na classe ProdutoDAO. 
        rs = funcionarioDAO.consultarFuncionarios(funcionarioDTO, opcao);
        
        return rs; // Retornando a variável com o valor atualizado.
    }// Fecha o método consultarProduto(ProdutoDTO produtoDTO, int opcao).
    
    /**
    * Método responsável por retransmitir informações para a classe ProdutoDAO.
    * 
    * @param funcionarioDTO, vindo da classe ProdutoDTO.
    * @param opcao, vindo da classe ProdutoDAO.
    * @return uma variável do tipo ResultSet.
    */
    public ResultSet consultarProduto(FuncionarioDTO funcionarioDTO, int opcao) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        ResultSet rs = null; // Criando um atributo do tipo ResultSet.
        
        // Chamando o método consultarProduto que está na classe ProdutoDAO. 
        rs = funcionarioDAO.consultarFuncionarios(funcionarioDTO, opcao);
        
        return rs; // Retornando a variável com o valor atualizado.
    }// Fecha o método consultarProduto(ProdutoDTO produtoDTO, int opcao).
    
    /**
     * Método responsável por retransmitir informações para a classe ProdutoDAO.
     * 
     * @param funcionarioDTO, vindo da classe ProdutoDTO.
     * @return uma String.
     */
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            // Chamando o método que está na classe DAO aguardando resposta.
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionario alterado com sucesso!"; // String retornada.
            } else {
                return "Funcionario não alterado!"; // String retornada.
            }
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario não alterado!"; // String retornada.
        }// Fecha catch.
    }// Fecha o método alterarProduto(ProdutoDTO produtoDTO).
    
    /**
    * Método responsável por retransmitir informações para a classe ProdutoDAO.
    * 
    * @param funcionarioDTO, vindo da classe ProdutoDTO.
    * @return uma String.
    */
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            // Chamando o método que está na classe DAO aguardando resposta.
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario excluido com sucesso!"; // String retornada.
            } else {
                return "Funcionario não excluido!"; // String retornada.
            }
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario não excluido!"; // String retornada.
        }// Fecha catch.
    }// Fecha o método excluirProduto(ProdutoDTO produtoDTO).

    /**
     * Método responsável por fechar o Banco de Dados.
     */
    public void CloseDB() {
        // Chamando o método CloseDB que está na classe ConexaoDAO.
        ConexaoDAO.CloseDB();
    }// Fecha o método CloseDB().
}// Fecha classe FuncionarioCTR.
