package exercicio2;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        while (JOptionPane.showConfirmDialog(null, "Deseja registrar mais um aluno?", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Aluno aluno = new Aluno();
            aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
            int[] notas = new int[3];
            for (int i = 0; 3 > i; i++) {
                notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a nota da " + (i + 1) + "° prova deste aluno"));
            }
            aluno.setNotas(notas);
            alunos.add(aluno);
        }
        for (int i = 0; alunos.size() > i; i++) {
            Aluno alunoAtual = alunos.get(i);
            double media = 0;
            for (int j = 0; alunoAtual.getNotas().length > j; j++) {
                media += alunoAtual.getNotas()[j];
            }
            media = media / 3;
            JOptionPane.showMessageDialog(null, "Nome do aluno: " + alunoAtual.getNome()
                    + "\nMédia final do aluno: " + media);
        }
    }

}
