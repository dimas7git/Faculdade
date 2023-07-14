package secretaria;

import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

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

			Random gerador = new Random();

			double n1 = gerador.nextDouble(10);
			double n2 = gerador.nextDouble(10);
			double nf = (n1 + n2) / 2;
			System.out.println(nome);
			System.out.println(n1);
			System.out.println(n2);
			System.out.println(nf);
			if (nf > 8) {
				cf = "A";
			} else if ((nf <= 8) && (nf >= 7)) {
				cf = "B";
			}

			else if ((nf < 7) && (nf >= 6)) {
				cf = "C";
			}

			else if ((nf < 6) && (nf >= 5)) {
				cf = "D";
			}

			else {
				cf = "E";
			}

			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			System.out.println(nome);
			aluno.setN1(n1);
			System.out.println(n1);
			aluno.setN2(n2);
			System.out.println(n2);
			aluno.setNf(nf);
			System.out.println(nf);
			aluno.setConceito(cf);
			System.out.println(cf);
			alunos.add(aluno);
		}

		sc.close();

		try {

			/* Gravando os dados no arquivo cvs */
			File file = new File("./dadosOUT.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			bw.write("Nome");
			bw.write(",");
			bw.write("cf");
			bw.write(",");
			bw.write("n1");
			bw.write(",");
			bw.write("n2");
			bw.write(",");
			bw.write("nf");
			bw.write("\n");
			
			for (int i = 0; i < alunos.size(); i++) {
				bw.write(alunos.get(i).getNome());
				bw.write(",");
				bw.write(alunos.get(i).getConceito());
				bw.write(",");
				bw.write(Double.toString(alunos.get(i).getN1()));
				bw.write(",");
				bw.write(Double.toString(alunos.get(i).getN2()));
				bw.write(",");
				bw.write(Double.toString(alunos.get(i).getNf()));
				bw.write("\n");
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		read();
	}

	/* Ler arquivo gravado ao final da execução do programa */
	public static void read() {
		try {
			File file = new File("./dadosOUT.csv");
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = bf.readLine()) != null) {
				++i;
				System.out.println(i + "," + line);
			}
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
