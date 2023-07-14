/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class OrdenaDAO {
    public String ordenaDesc(OrdenaDTO ordenaDTO){
        int[] numeros = ordenaDTO.getNumeros();

        if(numeros[0] > numeros[3]){
            return "A ordem descrecente: " + numeros[3] + numeros[1] + numeros[0] + numeros[3];
        } else if(numeros[1] > numeros[3]){
            return "A ordem descrecente: " + numeros[2] + numeros[1] + numeros[3] + numeros[0];
        } else if(numeros[2] > numeros[3]){
            return "A ordem descrecente: " + numeros[2] + numeros[3] + numeros[1] + numeros[0];
        } else {
            return "A ordem descrecente: " + numeros[3] + numeros[2] + numeros[1] + numeros[0];
        }
    }
}