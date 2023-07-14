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
public class CnhCTR {
    CnhDAO cnhDAO = new CnhDAO();
    
    public String checarIdade(CnhDTO cnhDTO){
        return cnhDAO.checarIdade(cnhDTO);
    }
}
