package br.com.assados.dto;

import java.sql.Date;

public class ClienteDTO {
    double preco, qtdAssado,totalDia;
    String nomeAssados;
    Date data;
    int id_adm;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }
    
    

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdAssado() {
        return qtdAssado;
    }

    public void setQtdAssado(double qtdAssado) {
        this.qtdAssado = qtdAssado;
    }

    public double getTotalDia() {
        return totalDia;
    }

    public void setTotalDia(double totalDia) {
        this.totalDia = totalDia;
    }

    public String getNomeAssados() {
        return nomeAssados;
    }

    public void setNomeAssados(String nomeAssados) {
        this.nomeAssados = nomeAssados;
    }
    
}
