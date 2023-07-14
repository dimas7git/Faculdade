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
public class CnhDAO {
    public String checarIdade(CnhDTO cnhDTO){
        if(cnhDTO.getIdade() < 18){
            return "Não pode tirar o CNH";
        } else {
            return "Pode tirar o CNH";
        }
    }
}
