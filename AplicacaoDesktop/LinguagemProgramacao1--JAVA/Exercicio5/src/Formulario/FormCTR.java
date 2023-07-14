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
public class FormCTR {
    FormDAO formDAO = new FormDAO();
    
    public String mostraCadastro(FormDTO formDTO){
        return formDAO.mostraCadastro(formDTO);
    }
}
