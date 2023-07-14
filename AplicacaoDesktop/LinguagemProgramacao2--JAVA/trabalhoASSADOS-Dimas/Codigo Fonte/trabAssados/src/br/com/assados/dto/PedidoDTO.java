package br.com.assados.dto;

/**
 *
 * @author DimasFerreira
 */
public class PedidoDTO {
    String nomeCli, assadosComprados, end;
    double precoTotal;
    int id_ped;

    public int getId_ped() {
        return id_ped;
    }

    public void setId_ped(int id_ped) {
        this.id_ped = id_ped;
    }
       

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getAssadosComprados() {
        return assadosComprados;
    }

    public void setAssadosComprados(String assadosComprados) {
        this.assadosComprados = assadosComprados;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}
