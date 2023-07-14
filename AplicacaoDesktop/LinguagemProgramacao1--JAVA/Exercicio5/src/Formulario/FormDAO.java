/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

/**
 *
 * @author aluno
 */
public class FormDAO {
    public String mostraCadastro(FormDTO formDTO){
        return "Os dados gravaods são: \nNome: " +
                formDTO.getNome() + "\nLogadouro: " +
                formDTO.getLogadouro() + "\nBairro: " +
                formDTO.getBairro() + "\nCidade: " +
                formDTO.getCidade() + "\nEstado: " +
                formDTO.getEstado() + "\nCEP: " +
                formDTO.getCep() + "\nCPF: " +
                formDTO.getCpf()+ "\nRG: " +
                formDTO.getRg() + "\nNúmero: " +
                formDTO.getnCasa();
    }
}
