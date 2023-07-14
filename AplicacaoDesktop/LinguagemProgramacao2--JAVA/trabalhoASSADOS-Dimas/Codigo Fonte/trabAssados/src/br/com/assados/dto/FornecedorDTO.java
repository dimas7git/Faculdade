package br.com.assados.dto;

/**
 *
 * @author DimasFerreira
 */
public class FornecedorDTO {
    String nomeForne, produtoForne;
    double qtdProd, precoTotal;
    int idFornec;

    public int getIdFornec() {
        return idFornec;
    }

    public void setIdFornec(int idFornec) {
        this.idFornec = idFornec;
    }
    

    public String getNomeForne() {
        return nomeForne;
    }

    public void setNomeForne(String nomeForne) {
        this.nomeForne = nomeForne;
    }

    public String getProdutoForne() {
        return produtoForne;
    }

    public void setProdutoForne(String produtoForne) {
        this.produtoForne = produtoForne;
    }

    public double getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(double qtdProd) {
        this.qtdProd = qtdProd;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
}
