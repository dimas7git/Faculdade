package exercicio1;

import javax.swing.JOptionPane;

public class Exercicio1 {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
        int[] notas = new int[3];
        double media = 0;
        for (int i = 0; 3 > i; i++) {
            notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a nota da " + (i + 1) + "° prova deste aluno"));
            media += notas[i];
        }
        aluno.setNotas(notas);
        JOptionPane.showMessageDialog(null, "Nome do aluno: " + aluno.getNome()
                + "\nMédia final do aluno: " + (media / 3));
    }

}
