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

/**
 * Importando classes e extensões necessárias.
 */
import java.sql.ResultSet;
import br.com.projeto_kevin.dto.ProdutoDTO;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dao.ProdutoDAO;

/**
 * Classe responsável pelo controle de informações.
 *
 * @author Kevin
 * @version 1.0
 */
public class ProdutoCTR {
    /**
     * Método construtor da classe.
     */
    public ProdutoCTR() {
    }// Fecha o método construtor.
    
    ProdutoDAO produtoDAO = new ProdutoDAO(); // Instanciando objeto do tipo ProdutoDAO.
    
    /**
     * Método responsável por retrasmitir informações para a classe ProdutoDAO.
     * 
     * @param produtoDTO, vindo da classe ProdutoDTO.
     * @return uma String.
     */
    public String inserirProduto(ProdutoDTO produtoDTO) {
        try {
            // Chamando o método que está na classe DAO aguardando resposta.
            if (produtoDAO.inserirProduto(produtoDTO)) {
                return "Produto cadastrado com sucesso!"; // String retornada.
            } else {
                return "Produto não cadastrado!"; // String retornada.
            }
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto não cadastrado!"; // String retornada.
        }// Fecha catch.
    }// Fecha o método inserirProduto(ProdutoDTO produtoDTO).
    
    /**
     * Método responsável por retransmitir informações para a classe ProdutoDAO.
     * 
     * @param produtoDTO, vindo da classe ProdutoDTO.
     * @return uma String.
     */
    public String alterarProduto(ProdutoDTO produtoDTO) {
        try {
            // Chamando o método que está na classe DAO aguardando resposta.
            if (produtoDAO.alterarProduto(produtoDTO)) {
                return "Produto alterado com sucesso!"; // String retornada.
            } else {
                return "Produto não alterado!"; // String retornada.
            }
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto não alterado!"; // String retornada.
        }// Fecha catch.
    }// Fecha o método alterarProduto(ProdutoDTO produtoDTO).
    
    /**
    * Método responsável por retransmitir informações para a classe ProdutoDAO.
    * 
    * @param produtoDTO, vindo da classe ProdutoDTO.
    * @return uma String.
    */
    public String excluirProduto(ProdutoDTO produtoDTO) {
        try {
            // Chamando o método que está na classe DAO aguardando resposta.
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto excluido com sucesso!"; // String retornada.
            } else {
                return "Produto não excluido!"; // String retornada.
            }
        }// Fecha try. 
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto não excluido!"; // String retornada.
        }// Fecha catch.
    }// Fecha o método excluirProduto(ProdutoDTO produtoDTO).
    
    /**
    * Método responsável por retransmitir informações para a classe ProdutoDAO.
    * 
    * @param produtoDTO, vindo da classe ProdutoDTO.
    * @param opcao, vindo da classe ProdutoDAO.
    * @return uma variável do tipo ResultSet.
    */
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        ResultSet rs = null; // Criando um atributo do tipo ResultSet.
        
        // Chamando o método consultarProduto que está na classe ProdutoDAO. 
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        
        return rs; // Retornando a variável com o valor atualizado.
    }// Fecha o método consultarProduto(ProdutoDTO produtoDTO, int opcao).
    
    /**
     * Método responsável por fechar o Banco de Dados.
     */
    public void CloseDB() {
        // Chamando o método CloseDB que está na classe ConexaoDAO.
        ConexaoDAO.CloseDB();
    }// Fecha o método CloseDB().
}// Fecha a classe ProdutoCTR.
