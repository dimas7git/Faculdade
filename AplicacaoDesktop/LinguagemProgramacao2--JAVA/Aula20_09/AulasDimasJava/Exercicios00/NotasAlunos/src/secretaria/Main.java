package secretaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static String cf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<>();

		System.out.print("Numero de alunos: ");
		Scanner sc = new Scanner(System.in);
		int numAlunos = sc.nextInt();
		for (int i = 1; i <= numAlunos; i++) {
			System.out.println("");
			System.out.print("nome: ");
			String nome = sc.next();
			System.out.print("nota (A1): ");
			double n1 = Double.parseDouble(sc.next());
			System.out.print("nota (A2): ");
			double n2 = Double.parseDouble(sc.next());
			double nf = (n1 + n2) / 2;

			if (nf > 8) {
				cf = "A";
			} else if ((nf <= 8) && (nf >= 7)) {
				cf = "B";
			}

			else if ((nf < 7) && (nf >= 6)) {
				cf = "C";
			}

			else if ((nf <= 6) && (nf >= 5)) {
				cf = "D";
			}

			else {
				cf = "E";
			}

			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setN1(n1);
			aluno.setN2(n2);
			aluno.setNf(nf);
			aluno.setConceito(cf);
			alunos.add(aluno);
		}
		sc.close();

		for (int i = 0; i < alunos.size(); i++) {

			System.out.println(alunos.get(i).nome);
			System.out.println(alunos.get(i).nf);
			System.out.println(alunos.get(i).cf);

		}

	}
}
