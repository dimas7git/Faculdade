/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.vtp.projetoteste;

public class Status {
    private  int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
        }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Status() {
    }
    
}
