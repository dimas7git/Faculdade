package Exemplo_While;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String args[]) {
        String letra;
        Exemplo exemplo = new Exemplo();

        letra = JOptionPane.showInputDialog("Informe a letra");

        while (letra.equalsIgnoreCase("x")) {
          exemplo.verificar(letra);
          letra = JOptionPane.showInputDialog("Informe a letra ");
        }
        JOptionPane.showMessageDialog(null, exemplo.mostra());
    }
}