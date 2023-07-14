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
import br.com.projeto_kevin.dto.ProdutoDTO;

/**
 * Classe responsável por manipular dados dos Produtos.
 *
 * @author Kevin
 * @version 1.0
 */
public class ProdutoDAO {
    /**
     * Método construtor da classe.
     */
    public ProdutoDAO() {
    }
    
    private ResultSet rs = null; // Atributo usado para realizar consultas.
    private Statement stt = null;
    private PreparedStatement stmt = null; // Atributo utilizado para manipular o Banco.
    Boolean retorno = null;
    
    /**
     * Método responsável por inserir produtos no Banco.
     * 
     * @param produtoDTO, vindo da classe ProdutoDTO.
     * @return true ou false.
     */
    public Boolean inserirProduto(ProdutoDTO produtoDTO) {
        try {
            ConexaoDAO.ConectDB(); // Conectando com o Banco de Dados.
            
            // Comando sql que será executado no Banco.
            String sql = "INSERT INTO produto(produto, data, tipo, valor, responsavel, descricao, imagem) values (?,?,?,?,?,?,?)";
            
            stmt = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            stmt.setString(1, produtoDTO.getProduto());
            stmt.setString(2, produtoDTO.getData());
            stmt.setString(3, produtoDTO.getTipo());
            stmt.setInt(4, produtoDTO.getValor());
            stmt.setString(5, produtoDTO.getResponsavel());
            stmt.setString(6, produtoDTO.getDescricao());
            stmt.setBytes(7, produtoDTO.getProduto_img());
            
            stmt.executeUpdate(); // Executa o comando sql no Banco de Dados.
            retorno = true; // Retorna verdadeiro.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            return retorno;
        }// Fecha try.
        // Tratamento de erro para o código acima.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return retorno;
        }// Fecha catch.
        //Independentemente de erro, fecha o Banco de Dados.
        finally {
            ConexaoDAO.CloseDB(); // Método responsável por fechar a conexão com o Banco.
            retorno = false;
        }// Fecha finally.
    }// Fecha o método inserirProduto(ClienteDTO clienteDTO).
    
    /**
     * Método responsável por alterar dados do produto no Banco.
     * 
     * @param produtoDTO, que vem da classe ProdutoCTR.
     * @return true ou false.
     */
    public boolean alterarProduto(ProdutoDTO produtoDTO) {
        try {
            ConexaoDAO.ConectDB(); // Conectando com o Banco de Dados.
             
            // Comando sql que será executado no Banco de Dados.
            String sql = "UPDATE produto SET "
                       + "produto = ?, data = ?, tipo = ?, valor = ?, responsavel = ?, descricao = ?, imagem = ? "
                       + "WHERE id_produto = ?";
            
            stmt = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            stmt.setString(1, produtoDTO.getProduto());
            stmt.setString(2, produtoDTO.getData());
            stmt.setString(3, produtoDTO.getTipo());
            stmt.setInt(4, produtoDTO.getValor());
            stmt.setString(5, produtoDTO.getResponsavel());
            stmt.setString(6, produtoDTO.getDescricao());
            stmt.setBytes(7, produtoDTO.getProduto_img());
            stmt.setInt(8, produtoDTO.getId_produto());
              
            stmt.executeUpdate(); // Executa o comando sql no Banco de Dados.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            stmt.close(); // Fecha o Statement.
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
     * @param produtoDTO, vindo da classe ProdutoCTR.
     * @return true ou false.
     */
    public boolean excluirProduto(ProdutoDTO produtoDTO) {
        try {
            ConexaoDAO.ConectDB(); // Conectando com o Banco de Dados.
                
            // Comando sql que será executado no Banco de Dados.
            String sql = "DELETE FROM produto WHERE id_produto = ?";
            
            stmt = ConexaoDAO.con.prepareStatement(sql); // Prepara a SQL.
            
            stmt.setInt(1, produtoDTO.getId_produto());
            
            stmt.executeUpdate(); // Executa o comando sql no Banco de Dados.
            ConexaoDAO.con.commit(); // Commita o Banco de Dados.
            stmt.close(); // Fecha o Statement.
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
    
    /**
     * Método responsável por consultar produtos no Banco de Dados.
     * 
     * @param produtoDTO, vindo da classe ProdutoDTO.
     * @param opcao, variável local do tipo Int.
     * @return variável do tipo ResultSet.
     */
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        try {
            //Chama o mÃ©todo que estÃ¡ na classe ConexaoDAO para abrir o banco de dados.
            ConexaoDAO.ConectDB();
            //Cria o Statement que Ã© responsÃ¡vel por executar alguma coisa no banco de dados.
            stt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados.
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.* "+
                              "from produto p "+
                              //"where produto like '" + produtoDTO.getProduto()+ "%' " +
                              "order by p.id_produto";
                break;
                case 2:
                    comando = "Select p.* "+
                              "from produto p "+
                              "where p.id_produto = " + produtoDTO.getId_produto();
                break;
                case 3:
                    comando = "Select c.id_cliente, c.nome " +
                              "from cliente c";
                break;
            }
            //Executa o comando SQL no banco de dados.
            rs = stt.executeQuery(comando.toUpperCase());
            return rs;
        }//Caso tenha algum erro no codigo acima Ã© enviado uma mensagem no console
         //com o que estÃ¡ acontecendo. 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }// Fecha o método consultarProduto(ProdutoDTO produtoDTO, int opcao).
}// Fecha a classe ProdutoDAO.
