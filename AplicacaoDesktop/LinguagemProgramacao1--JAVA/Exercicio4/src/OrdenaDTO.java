/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class OrdenaDTO {
    private int[] numeros = new int[4];
    
    public void setNumeros(int e[]){
        this.numeros = e;
    }
    
    public int[] getNumeros(){
        return this.numeros;
    }
}
