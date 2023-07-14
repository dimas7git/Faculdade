package br.com.projeto_2.ctr;

import java.sql.ResultSet;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dto.ProdutoDTO;
import br.com.projeto_2.dao.ConexaoDAO;
import br.com.projeto_2.dao.ProdutoDAO;

public class ProdutoCTR {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoCTR() {
    }

    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)) {
                return "Produto cadastrado com sucesso!!";
            } else {
                return "Produto não cadasrado";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NAO cadastrado";
        }
    }

    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)) {
                return "Produto alterado com sucesso!! ";
            } else {
                return "Produto NAO alterado!! ";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NAO alterado";
        }
    }

    public String excluirProduto(ProdutoDTO produtoDTO) {
        try {
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto excluido cmo sucesso";
            } else {
                return "Produto NAO excluido ";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NAO excluido";
        }
    }

    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }
    
    public void closeDb(){
    ConexaoDAO.closeDb();
    }
}
