package Introducao_Ex01;
import javax.swing.JOptionPane;

public class Principal_Cliente {
   public static void main(String[] args){
    Cliente cliente = new Cliente();
    
    String nome, rg;
    int idade;
    idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade "));
    nome = JOptionPane.showInputDialog("Informe o nome ");
    rg = JOptionPane.showInputDialog("Informe o rg ");
    
    cliente.mostrar(nome, rg);
    cliente.mostrarNome(nome, idade);
   }//fecha main 
}//fecha classe
