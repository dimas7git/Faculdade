package secretaria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {

		/* OPÇÃO 1 */
	/*	try {
			FileOps.read();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(" ");
*/
		
		/* OPÇÃO 2 */
/*		try {
			CSVReader.read();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(" ");
*/
		
		/* OPÇÃO 3 */

	/*	try {
			FileBufferred.read();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		System.out.println(" ");
*/
		
		/* OPÇÃO 4 */
/*		try {
			FileOps.read();
		} catch (FileNotFoundException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		System.out.println(" ");
*/
		
		/* OPÇÃO 5 - MELHOR */
		String path = "./dados.csv";

		List<Aluno> list = new ArrayList<Aluno>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine(); //ler próxima linha para evitar o nome dos atributos
			while (line != null) {

				String[] vect = line.split(",");
				String nome = vect[0];
				String cf = vect[1];
				Double n1 = Double.parseDouble(vect[2]);
				Double n2 = Double.parseDouble(vect[3]);
				Double nf = Double.parseDouble(vect[4]);

				nf = 0.0;
				nf = (n1 + n2) / 2;

				if (nf > 8) {
					cf = "A";
				} else if ((nf <= 8) && (nf >= 7)) {
					cf = "B";
				} else if ((nf < 7) && (nf >= 6)) {
					cf = "C";
				} else if ((nf < 6) && (nf >= 5)) {
					cf = "D";
				} else {
					cf = "E";
				}

				Aluno aluno = new Aluno(nome, cf, n1, n2, nf);
				list.add(aluno);
				line = br.readLine();
			}

			System.out.println("Alunos:");
			for (Aluno p : list) {
				System.out.println(p);
			}

		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
