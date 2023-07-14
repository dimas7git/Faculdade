
package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dto.ProdutoDTO;
import br.com.projeto_3.dao.ProdutoDAO;
import br.com.projeto_3.dao.ConexaoDAO;

public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public ProdutoCTR(){
        
    }
/*
    Método utilizado para controlar acesso ao método inserirProduto
*/

    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto CAdastrado com sucesso!!";
             }    
            else{
                return "Prodto não cadastrado";
                }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto não cadastrado";
        }
        
        
    }

    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        
        try{
            if(produtoDAO.alterarCliente(produtoDTO, fornecedorDTO)){
                return "Produto Alterado com Sucesso!!";
            }
            else{
                return "Produto não Alterado";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Alterado";
        }
        
    }
    
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.excluirProduto(produtoDTO)){
               return "Produto excluído com sucesso!!";
        } else{
                return "Produto não Excluído";
            }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        return "Produto não excluído";
    }
    }
        
        
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        ResultSet rs = null;
        
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }
     
    
    public void closeDB(){
        ConexaoDAO.ConectDB();
    }
        
}
