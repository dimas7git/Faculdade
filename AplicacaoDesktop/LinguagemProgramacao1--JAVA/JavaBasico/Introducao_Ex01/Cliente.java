package Introducao_Ex01;
import javax.swing.JOptionPane;

public class Cliente {

    private String nome, rg;
    private int idade;
    public void mostrar(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
        JOptionPane.showMessageDialog(null, "O nome informado foi: " + this.nome + " E o rg informado foi: " + this.rg);
    }

    public void mostrarNome(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        JOptionPane.showMessageDialog(null, "O nome informado foi: " + this.nome + " A idade é: " + this.idade);
    }
}
